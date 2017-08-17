package bookingapp.pack.Dao;

import bookingapp.pack.Models.cService;
import org.springframework.data.repository.CrudRepository;


public interface ServiceDao extends CrudRepository<cService,Long> {

        public cService findById(Long id);
}
