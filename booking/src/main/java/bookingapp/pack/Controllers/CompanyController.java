package bookingapp.pack.Controllers;

import bookingapp.pack.Models.Company;
import bookingapp.pack.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



    @RequestMapping(value="/register",method=RequestMethod.GET)
    @CrossOrigin
    public void addCompany(@RequestParam(name="cp_name") String name, @RequestParam(name="cp_email") String email, @RequestParam(name="cp_password") String password)
    {
        try {
            if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty())
                companyService.addCompany(name, email, companyService.passCrypter(password));
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }


    @RequestMapping(value="/desc")
    @CrossOrigin
    public void addCompanyDescription(@RequestParam(name="cp_desc", required=false) String description, @RequestParam(name="cp_logopath") String logopath)
    {

        if(!description.isEmpty())
        {
            try {


            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }

    }

    @RequestMapping(value="/login")
    @CrossOrigin
    public String loginAttempt(@RequestParam(name="email") String email, @RequestParam(name="password") String password){
        if(companyService.verify(email,password)==true)
            return "Login Succesful";
        else
            return "Login failed";
    }




}
