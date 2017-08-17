package bookingapp.pack.Controllers;

import bookingapp.pack.Models.cService;
import bookingapp.pack.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @RequestMapping(value="/editservice/{id}",method=RequestMethod.PUT)
    @CrossOrigin
    public boolean editService(@PathVariable Long id,@RequestBody cService s)
    {
        try {
            s.setId(id);
            System.out.println(serviceService.updateService(s));
            return true;
        }
        catch(Exception e)
        {

            System.out.println(e.toString());
            return false;
        }

    }



    @RequestMapping(value="/services/{id}")
    @CrossOrigin
    public List<cService> getCompanyServices(@PathVariable long id)
    {
        return serviceService.getServiceByCompanyId(id);
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
