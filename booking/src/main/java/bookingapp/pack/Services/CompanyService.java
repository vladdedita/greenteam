package bookingapp.pack.Services;


import bookingapp.pack.Dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class CompanyService {


    @Autowired
    CompanyDao dao;



    public String getAllCompanies()
    {
        return dao.findAll().toString();
    }



    public boolean addCompany(String name, String email, String password)
    {


    }


}
