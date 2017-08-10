package bookingapp.pack.Services;


import bookingapp.pack.Dao.CompanyDao;
import bookingapp.pack.Models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyService {

    private BCryptPasswordEncoder crypto= new BCryptPasswordEncoder();
    @Autowired
             CompanyDao dao;


    public List<Company> getAllCompanies()
    {
        List<Company> companies=new ArrayList<Company>();

        for(Company c : dao.findAll())
        {
            companies.add(c);
        }

        return companies;
    }

    public boolean addCompany(String name,String email, String password)
    {
        /*SHA3.DigestSHA3 digest=new SHA3.Digest512();
        digest.digest(password.getBytes());*/

        try{
        dao.save(new Company(name ,email, password));
        return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }
    }

    public String passCrypter(String password){
        return crypto.encode(password);
    }


    public boolean changeDescription(String name,String description)
    {
        return true;
    }



    public boolean verify(String email, String password){
        for(Company c : dao.findAll())
            if (c.getEmail().equals(email)) {
                if (crypto.matches(password,c.getPassword())) {
                    return true;
                }
                else
                    return false;
            }
        return false;
    }


}
