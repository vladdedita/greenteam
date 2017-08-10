package bookingapp.pack.Controllers;


import bookingapp.pack.Models.Company;
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
    public void changeInfo(@RequestParam(name="cp_desc", required=false) String description, @RequestParam(name="cp_name", required=false) String name, @RequestParam(name="cp_logo",required = false) String logopath)
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





}
