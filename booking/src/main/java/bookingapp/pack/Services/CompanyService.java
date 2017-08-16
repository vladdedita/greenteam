package bookingapp.pack.Services;


import bookingapp.pack.Dao.CompanyDao;
import bookingapp.pack.Models.Company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

   /* public boolean addCompany(String name,String email, String password) throws NoSuchAlgorithmException {

        MessageDigest md=MessageDigest.getInstance("SHA-512");
        byte[] hash=md.digest(password.getBytes());

        try{
            dao.save(new Company(name ,email, hash.toString()));
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }


    }*/

    public boolean addCompany(Company c) throws NoSuchAlgorithmException {



        MessageDigest md=MessageDigest.getInstance("SHA-512");
        byte[] hash=md.digest(c.getPassword().getBytes());

        try{
            dao.save(new Company(c.getName() ,c.getName(), hash.toString()));
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

        byte[] hash= md.digest(password.getBytes());



        List<Company> companies=new ArrayList<Company>();

        for(Company c : dao.findAll())
        {
            if(c.getEmail().equals(email))
            {
                c.setPassword(hash.toString());
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


    public String getCalendar(String name)
    {


        return null;


    }

    public  Map<String,Map<Integer,Integer>> initCalendar(String name)
    {


        Map<String,Map<Integer,Integer>> calendar=new HashMap<String, Map<Integer, Integer>>();

        List<String> zi=new ArrayList<String>();

        zi.add("Monday");
        zi.add("Tuesday");
        zi.add("Wednesday");
        zi.add("Thursday");
        zi.add("Friday");
        zi.add("Saturday");
        zi.add("Sunday");

        Map<Integer,Integer> ora=new HashMap<Integer, Integer>();
        for(int i=8;i<=23;i++)
        {
            ora.put(i,0);
        }

        for(String s : zi)
        {
            calendar.put(s,ora);
        }



        return calendar;




    }





}
