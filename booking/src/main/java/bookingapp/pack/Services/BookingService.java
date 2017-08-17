package bookingapp.pack.Services;


import bookingapp.pack.Dao.BookingDao;
import bookingapp.pack.Dao.UserDao;
import bookingapp.pack.Models.Booking;
import bookingapp.pack.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingService {

    @Autowired
    private BookingDao dao;
    @Autowired
    private UserDao udao;

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



}
