package bookingapp.pack.Dao;

import bookingapp.pack.Models.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDao extends CrudRepository<Service,Long> {


}
