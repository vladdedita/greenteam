package bookingapp.pack.Controllers;


import bookingapp.pack.Models.Booking;
import bookingapp.pack.Models.Company;
import bookingapp.pack.Models.Token;
import bookingapp.pack.Models.User;
import bookingapp.pack.Services.CompanyService;
import bookingapp.pack.Services.MailService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.RequestEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.RandomStringUtils;

import javax.mail.Multipart;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class CompanyController {


    @Autowired
    private CompanyService companyService;



    @RequestMapping(value="/companies")
    @CrossOrigin
    public List<Company> getCompanies(@RequestParam("authorization") String auth)
    {

        System.out.println(auth);

        return companyService.getAllCompanies();
    }

    @RequestMapping(value="/companies/{id}")
    @CrossOrigin
    public Company getCompanyById(@PathVariable(name="id") Long id)
    {
        return companyService.getCompanyById(id);
    }



    @RequestMapping(value="/register",method=RequestMethod.POST)
    @CrossOrigin
    public void addCompany(@RequestBody Company c)
    {
        try {
            if(!c.getName().isEmpty() && !c.getEmail().isEmpty() && !c.getPassword().equals(null))
                companyService.addCompany(c);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    @RequestMapping(value="/{id}/updateProfile",method=RequestMethod.POST)
    @CrossOrigin
    public void changeInfo(@PathVariable(name="id") Long id,@RequestBody String str) throws IOException
    {

        ObjectMapper objectMapper=new ObjectMapper();

        JsonNode node= objectMapper.readTree(str);

        String name=objectMapper.convertValue(node.get("cp_name"),String.class);
        String description=objectMapper.convertValue(node.get("cp_desc"),String.class);
        MultipartFile file=objectMapper.convertValue(node.get("cp_logopath"),MultipartFile.class);



        if(!description.isEmpty())
        {
            try {
                companyService.changeDescription(id,description);
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
        if(!name.isEmpty())
        {
            try {
                companyService.changeName(id,name);
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
        if(!file.isEmpty())
        {
            try{
                companyService.uploadFileHandler(id,file);

            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }

        }




    }


    @RequestMapping("/recovery")
    @CrossOrigin
    public void sendMail(@RequestParam(name = "email") String email)
    {



        try {

            if(companyService.getCompanyByEmail(email) != null) {


                String configFile="email-bean.xml";

                ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(configFile);

                MailService ms = (MailService) context.getBean("gtEmail");

                
                String newPassword = RandomStringUtils.randomAlphabetic(16);

                String mailBody = " Hello. Your new password is:" + newPassword;

                if (companyService.changePassword(email, newPassword) == true)
                    ms.sendSimpleMessage(email, "Booking App Password Recovery", mailBody);
            }

        }
        catch(Exception e)
        {
           System.out.println(e.toString());
        }

    }

    @RequestMapping("/calendar")
    public  String getCalendar()
    {

        return new Gson().toJson(companyService.initCalendar("asd"));
    }



    @RequestMapping(value="/companyid",method=RequestMethod.GET)
    @CrossOrigin
    public Long getCompanyId(@RequestParam(name="token") String authToken,@RequestParam(name="email")String email)
    {

        Long id=companyService.getCompanyByEmail(email).getId();
        return id;

    }


    @RequestMapping(value="/login",method=RequestMethod.POST)
    @CrossOrigin
    public String logIn(@RequestBody String str) throws IOException
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode node = objectMapper.readTree(str);

            String email = objectMapper.convertValue(node.get("email"), String.class);
            String password = objectMapper.convertValue(node.get("password"), String.class);

            return companyService.checkCredentials(email, password);

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

}
