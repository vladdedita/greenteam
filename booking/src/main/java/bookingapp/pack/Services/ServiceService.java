package bookingapp.pack.Services;


import bookingapp.pack.Dao.ServiceDao;
import bookingapp.pack.Models.cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceDao dao;

    public String getAllServices()
    {
        List<cService> services=new ArrayList<cService>();


        for(cService s : dao.findAll())
        {
            services.add(s);
        }

        return services.toString();
    }

    public boolean addCservice(cService s)
    {
        try{
            dao.save(s);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public String updateService(cService service)
    {
        for(cService s : dao.findAll())
            if(s.getId()==service.getId() && !s.equals(service)) {
                try{

                    for(cService serv: dao.findAll())
                        if(serv.getName().equals(service.getName()))
                            return "Nume deja existent";


                    s.setName(service.getName());
                    s.setDescription(service.getDescription());
                    s.setDuration(service.getDuration());
                    s.setPlaces(service.getPlaces());
                    s.setPrice(service.getPrice());
                    s.setAvailable(service.getAvailable());
                    s.setCalendar(service.getCalendar());
                    dao.save(s);
                    return "updated";
                }
                catch (Exception e) {

                    return e.getMessage();
                }
            }
        return "failed";
    }

    public boolean deleteService(Long id)
    {
        for(cService s : dao.findAll())
            if(s.getId()==id)
                try{
                    dao.delete(id);

                    return true;
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                    return false;
                }
        return false;
    }
}
