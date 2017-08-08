package bookingapp.pack.Dao;

import bookingapp.pack.Models.Company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends CrudRepository<Company,Long> {


}
