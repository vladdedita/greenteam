package bookingapp.pack.Services;


import bookingapp.pack.Dao.BookingDao;
import bookingapp.pack.Models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingService {

    @Autowired
    BookingDao dao;


    public List<Booking> getAllBookings()
    {
        List<Booking> bookings=new ArrayList<Booking>();

        for(Booking b : dao.findAll())
            bookings.add(b);

        return bookings;
    }

    public boolean addBooking(Booking b)
    {

        try {
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
