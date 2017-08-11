package bookingapp.pack.Controllers;


import bookingapp.pack.Models.Company;
import bookingapp.pack.Services.CompanyService;
import bookingapp.pack.Services.MailService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.RandomStringUtils;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class CompanyController {


    @Autowired
    private CompanyService companyService;


    @RequestMapping(value="/companies")
    @CrossOrigin
    public List<Company> getCompanies()
    {
        return companyService.getAllCompanies();
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


    @RequestMapping(value="/desc")
    @CrossOrigin
    public void changeInfo(@RequestParam(name="cp_desc", required=false) String description, @RequestParam(name="cp_name", required=false) String name)
    {

        if(!description.isEmpty())
        {
            try {
                companyService.changeDescription(name,description);
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

        String configFile="email-bean.xml";

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(configFile);

        MailService ms = (MailService) context.getBean("gtEmail");


        try {


            String newPassword= RandomStringUtils.random(16);

            String mailBody=" Hello. Your new password is:" + newPassword;

            if(companyService.changePassword(email,newPassword) == true)
                ms.sendSimpleMessage(email,"Booking App Password Recovery", mailBody);


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




    




}
