package bookingapp.pack.Dao;

import bookingapp.pack.Models.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenDao extends CrudRepository<Token,Long> {


    public Token findById(long id);
    public Token findByToken(String token);
}
