package bookingapp.pack.Controllers;


import bookingapp.pack.Models.Company;
import bookingapp.pack.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    




}
