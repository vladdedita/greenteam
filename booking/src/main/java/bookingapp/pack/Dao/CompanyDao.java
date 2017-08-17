package bookingapp.pack.Dao;

import bookingapp.pack.Models.Company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CompanyDao extends CrudRepository<Company,Long> {

    public Company findById(Long id);
    public Company findByEmail(String email);


}
