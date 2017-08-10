package bookingapp.pack.Services;


import bookingapp.pack.Dao.CserviceDao;
import bookingapp.pack.Models.Cservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CserviceService {

    @Autowired
    private CserviceDao dao;

    public String getAllServices()
    {
        List<Cservice> services=new ArrayList<Cservice>();


        for(Cservice s : dao.findAll())
        {
            services.add(s);
        }

        return services.toString();
    }

    public boolean addCservice(Cservice s)
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

    public String updateService(Cservice service)
    {
        for(Cservice s : dao.findAll())
            if(s.getId()==service.getId() && !s.equals(service)) {
                try{

                    for(Cservice serv: dao.findAll())
                        if(serv.getName().equals(service.getName()))
                            return "Nume deja existent";
                    s.setName(service.getName());
                    s.setDescription(service.getDescription());
                    s.setDuration(service.getDuration());
                    s.setSpaces(service.getSpaces());
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
        for(Cservice s : dao.findAll())
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
