package bookingapp.pack.Controllers;

import bookingapp.pack.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {


    @Autowired
    private CompanyService companyService;


    @RequestMapping(value="/companies")
    @CrossOrigin
    public String getCompanies()
    {
        return companyService.getAllCompanies();
    }


    @RequestMapping(value="/register",method=RequestMethod.POST)
    @CrossOrigin
    public void addCompany(@RequestParam(name="cp_name") String name, @RequestParam(name="cp_email") String email, @RequestParam(name="cp_password") String password)
    {
        try {
            if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty())
                companyService.addCompany(name, email, password);
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



}
