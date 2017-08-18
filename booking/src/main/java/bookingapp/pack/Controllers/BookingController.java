package bookingapp.pack.Controllers;


import bookingapp.pack.Models.Booking;
import bookingapp.pack.Models.CompanyBooking;
import bookingapp.pack.Models.User;
import bookingapp.pack.Models.cService;
import bookingapp.pack.Services.BookingService;
import bookingapp.pack.Services.ServiceService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookingController {


    @Autowired
    BookingService bookingService;
    @Autowired
    ServiceService serviceService;

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
        String day=objectMapper.convertValue(node.get("day"),String.class);
        Integer hour=objectMapper.convertValue(node.get("hour"),Integer.class);


        cService s=serviceService.getServiceById(b.getId_service());

        Type type = new TypeToken<Map<String,Map<Integer,Integer>>>(){}.getType();
        Map<String,Map<Integer,Integer>> calendar= new Gson().fromJson(s.getCalendar(),type );

        Map<Integer,Integer> a=calendar.get(day);


        calendar.get(day).put(hour,calendar.get(day).get(hour)-b.getPlaces());

        s.setCalendar(new Gson().toJson(calendar));

        String sday=new String();

        if(day.equals("0"))
            sday="Monday";
        else
        if(day.equals("1"))
            sday="Tuesday";
        else

        if(day.equals("2"))
            sday="Wednesday";
        else
        if(day.equals("3"))
            sday="Thursday";
        else
        if(day.equals("4"))
            sday="Friday";
        else
        if(day.equals("5"))
            sday="Saturday";
        else
        if(day.equals("6"))
            sday="Sunday";


        b.setDate(sday+ " " + hour.toString());

        serviceService.updateService(s);


        bookingService.addBooking(b,u);


    }

    @RequestMapping(value="/getbookings/{companyId}",method= RequestMethod.GET)
    @CrossOrigin
    public List<CompanyBooking> getServiceBookings(@PathVariable(name="companyId") Long companyId)
    {


        return bookingService.getServiceBookings(companyId);

    }




}
