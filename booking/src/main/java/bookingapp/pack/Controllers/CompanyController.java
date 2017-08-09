package bookingapp.pack.Controllers;


import bookingapp.pack.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {


    @Autowired
    private CompanyService companyService;

    @RequestMapping(value="/companies")
    public String getCompanies()
    {
        return companyService.getAllCompanies();
    }

    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addCompany(@RequestParam(value="name") String name, @RequestParam(value="desc") String desc, @RequestParam(value="email") String email, @RequestParam(value="pass") String pass)
    {
        companyService.addCompany(name,desc,email,pass);
    }



}
