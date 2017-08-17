package bookingapp.pack.Services;


import bookingapp.pack.Dao.BookingDao;
import bookingapp.pack.Dao.ServiceDao;
import bookingapp.pack.Dao.UserDao;
import bookingapp.pack.Models.Booking;
import bookingapp.pack.Models.CompanyBooking;
import bookingapp.pack.Models.User;
import bookingapp.pack.Models.cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingService {

    @Autowired
    private BookingDao dao;
    @Autowired
    private UserDao udao;

    @Autowired
    private ServiceDao sdao;


    public List<Booking> getAllBookings()
    {
        List<Booking> bookings=new ArrayList<Booking>();

        for(Booking b : dao.findAll())
            bookings.add(b);

        return bookings;
    }

    public boolean addBooking(Booking b,User u)
    {
        try {


            udao.save(u);
            b.setId_user(u.getId());
            dao.save(b);

            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }
    }

    public List<CompanyBooking> getServiceBookings(Long companyId)
    {
        List<CompanyBooking> obj=new ArrayList<CompanyBooking>();



        for(Booking b : dao.findAll()){

            cService s=sdao.findById(b.getId_service());

            if(s.getIdCompany() == companyId) {

                for (User u : udao.findAll()) {
                    if (b.getId_user() == u.getId()) {


                        obj.add(new CompanyBooking(s.getName(),u.getName(),u.getEmail(),u.getPhone()));

                    }
                }
            }


            }
        return obj;


    }



}
