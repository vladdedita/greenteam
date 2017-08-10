package bookingapp.pack.Dao;

import bookingapp.pack.Models.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingDao extends CrudRepository<Booking,Long> {

}
