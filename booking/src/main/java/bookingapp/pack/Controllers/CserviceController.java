package bookingapp.pack.Controllers;


import bookingapp.pack.Models.Cservice;
import bookingapp.pack.Services.CserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@RestController
public class CserviceController {

    @Autowired
    private CserviceService cserviceService;


    @RequestMapping("/services")
    @CrossOrigin
    public String getServices()
    {
        return cserviceService.getAllServices();
    }


    @RequestMapping(value="/addservice",method= RequestMethod.POST)
    @CrossOrigin
   public String addService(@RequestBody Cservice s)

    {
        try {
            cserviceService.addCservice(s);
        }
        catch(Exception e)
        {
            return e.toString();
        }
        return null;
    }
}
