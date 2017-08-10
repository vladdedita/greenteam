package bookingapp.pack.Services;


import bookingapp.pack.Dao.CompanyDao;
import bookingapp.pack.Models.Company;
import javassist.bytecode.ByteArray;
import org.aspectj.bridge.Message;
import org.bouncycastle.crypto.generators.BCrypt;
import org.bouncycastle.jcajce.provider.digest.SHA1;
import org.bouncycastle.jcajce.provider.digest.SHA3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyService {


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

    public boolean addCompany(String name,String email, String password) throws NoSuchAlgorithmException {

        MessageDigest md=MessageDigest.getInstance("SHA-512");
        byte[] hash=md.digest(password.getBytes());

        try{
        dao.save(new Company(name ,email, hash));
        return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }

        
    }

    public boolean addCompany(Company c) throws NoSuchAlgorithmException {



        MessageDigest md=MessageDigest.getInstance("SHA-512");
        byte[] hash=md.digest(c.getPassword());

        try{
            dao.save(new Company(c.getName() ,c.getName(), hash));
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }


    }

    public boolean changeDescription(String name,String description)
    {


        List<Company> companies=new ArrayList<Company>();

        for(Company c : dao.findAll())
        {
            if(c.getName().equals(name))
            {
                c.setDescription(description);
                dao.save(c);
                return true;
            }
        }

        return false;

    }

    public boolean changePassword (String email,String password) throws NoSuchAlgorithmException
    {

        MessageDigest md=MessageDigest.getInstance("SHA-512");
        byte[] hash=md.digest(password.getBytes());

        List<Company> companies=new ArrayList<Company>();

        for(Company c : dao.findAll())
        {
            if(c.getEmail().equals(email))
            {
                c.setPassword(hash);
                dao.save(c);
                return true;
            }
        }

        return false;

    }


    public boolean changeLogoPath(String name,String logopath)
    {


        List<Company> companies=new ArrayList<Company>();

        for(Company c : dao.findAll())
        {
            if(c.getName().equals(name))
            {

                dao.save(c);
                return true;
            }
        }

        return false;

    }






}
