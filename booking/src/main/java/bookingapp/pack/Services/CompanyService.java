package bookingapp.pack.Services;


import bookingapp.pack.Dao.CompanyDao;
import bookingapp.pack.Models.Company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

    private BCryptPasswordEncoder pw=new BCryptPasswordEncoder();

    private static String UPLOADED_FOLDER = "/home/ded/APP_FILE_UPLOADS/";




    public List<Company> getAllCompanies()
    {
        List<Company> companies=new ArrayList<Company>();

        for(Company c : dao.findAll())
        {
            companies.add(c);
        }

        return companies;
    }

    public Company getCompanyById(Long id)
    {
        return dao.findById(id);
    }

    public Company getCompanyByEmail(String email)
    {
        return dao.findByEmail(email);
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


        try{
            dao.save(new Company(c.getName() ,c.getEmail(), pw.encode(c.getPassword())));
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }


    }

    public boolean changeDescription(Long id,String description)
    {


        try {
            Company c=dao.findById(id);
            c.setDescription(description);
            dao.save(c);
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }


    }
    public boolean changeName(Long id,String name)
    {

    try {
        Company c=dao.findById(id);
        c.setName(name);
        dao.save(c);
        return true;
    }
    catch(Exception e)
    {
        System.out.println(e.toString());
        return false;
    }



    }

    public boolean uploadFileHandler(Long id,MultipartFile file) {


        if (!file.isEmpty()) {

            String name=file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = "/home/ded/UPLOADED/";


                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                String filePath=dir.getAbsolutePath()
                        + File.separator + name;
                File serverFile = new File(filePath);


                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                Company c=dao.findById(id);
                c.setLogopath(filePath);
                dao.save(c);


                return true;
            } catch (Exception e) {
                System.out.println(e.toString());
                return false;
            }
        } else {
            System.out.println("Empty file");
            return false;
        }
    }

    public boolean changePassword (String email,String password) throws NoSuchAlgorithmException
    {

        List<Company> companies=new ArrayList<Company>();

        for(Company c : dao.findAll())
        {
            if(c.getEmail().equals(email))
            {
                c.setPassword(pw.encode(password));
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


    public boolean checkCredentials(String email, String password)
    {

        Company c=dao.findByEmail(email);

        if(pw.matches(password,c.getPassword()))
            return true;
        return false;

    }





}
