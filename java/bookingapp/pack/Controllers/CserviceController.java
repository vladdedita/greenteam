package bookingapp.pack.Controllers;

import bookingapp.pack.Models.Cservice;
import bookingapp.pack.Services.CserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value="/editservice")
    @CrossOrigin
    public Cservice editService(@RequestBody Cservice s)
    {
        return s;
    }

    @RequestMapping(value="/updateservice",method = RequestMethod.PUT)
    @CrossOrigin
    public String updateService(@RequestBody Cservice s)
    {
        return cserviceService.updateService(s);
    }

    @RequestMapping(value = "/deleteservice/{id}",method = RequestMethod.DELETE)
    @CrossOrigin
    public boolean deleteService(@PathVariable Long id)
    {
        return cserviceService.deleteService(id);
    }

}
