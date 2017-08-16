package bookingapp.pack.Controllers;


import bookingapp.pack.Models.Booking;
import bookingapp.pack.Models.User;
import bookingapp.pack.Services.BookingService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BookingController {


    @Autowired
    BookingService bookingService;

    @RequestMapping("/bookings")
    @CrossOrigin
    public List<Booking> getBookings()
    {
       return bookingService.getAllBookings();
    }

    @RequestMapping(value="/addbooking",method= RequestMethod.POST)
    @CrossOrigin
    public void addBooking (@RequestBody String str) throws IOException
    {


        ObjectMapper objectMapper=new ObjectMapper();

        JsonNode node= objectMapper.readTree(str);

        User u=objectMapper.convertValue(node.get("User"),User.class);
        Booking b=objectMapper.convertValue(node.get("Booking"),Booking.class);


        bookingService.addBooking(b,u);


    }




}
