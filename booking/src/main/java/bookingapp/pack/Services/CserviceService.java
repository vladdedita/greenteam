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
    CserviceDao dao;

    public String getAllServices()
    {
        List<Cservice> services=new ArrayList<Cservice>();


        for(Cservice s : dao.findAll())
        {
            services.add(s);
        }

        return services.toString();
    }



    public boolean addCservice(String name, String description, int duration, int spaces, int price, int available, long idcompany, String calendar)
    {
        try{
            dao.save(new Cservice(name,description,duration,spaces,price,available,idcompany,calendar));
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

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
}
