package bookingapp.pack.Controllers;


import bookingapp.pack.Models.Booking;
import bookingapp.pack.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {


    @Autowired
    BookingService bookingService;

    @RequestMapping("/bookings")
    public List<Booking> getBookings()
    {
       return bookingService.getAllBookings();
    }

    @RequestMapping(value="/addbooking",method= RequestMethod.POST)
    public void addBooking(@RequestBody Booking b)
    {
        bookingService.addBooking(b);
    }


}
