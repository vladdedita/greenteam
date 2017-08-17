package bookingapp.pack.Dao;

import bookingapp.pack.Models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserDao extends CrudRepository<User,Long> {

    public User findById(Long id);

}
