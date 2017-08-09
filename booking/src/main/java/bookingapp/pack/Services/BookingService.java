package bookingapp.pack.Services;


import bookingapp.pack.Dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingService {

    @Autowired
    BookingDao dao;


}
