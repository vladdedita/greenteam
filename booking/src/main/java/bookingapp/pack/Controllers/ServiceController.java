package bookingapp.pack.Controllers;

import bookingapp.pack.Models.cService;
import bookingapp.pack.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ServiceController {

    @Autowired
    private ServiceService serviceService;


    @RequestMapping("/services")
    @CrossOrigin
    public String getServices()
    {
        return serviceService.getAllServices();
    }


    @RequestMapping(value="/addservice",method= RequestMethod.POST)
    @CrossOrigin
    public String addService(@RequestBody cService s)
    {
        try {
            System.out.println(s.toString());
            serviceService.addCservice(s);
        }
        catch(Exception e)
        {
            return e.toString();
        }
        return null;
    }

    @RequestMapping(value="/editservice")
    @CrossOrigin
    public cService editService(@RequestBody cService s)
    {
        return s;
    }

    @RequestMapping(value="/updateservice",method = RequestMethod.PUT)
    @CrossOrigin
    public String updateService(@RequestBody cService s)
    {
        return serviceService.updateService(s);
    }

    @RequestMapping(value = "/deleteservice/{id}",method = RequestMethod.DELETE)
    @CrossOrigin
    public boolean deleteService(@PathVariable Long id)
    {
        return serviceService.deleteService(id);
    }

}
