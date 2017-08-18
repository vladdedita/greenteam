package bookingapp.pack.Services;


import bookingapp.pack.Dao.CompanyDao;
import bookingapp.pack.Dao.TokenDao;
import bookingapp.pack.Models.Company;


import bookingapp.pack.Models.Token;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CompanyService {



    @Autowired
    CompanyDao dao;


    @Autowired
    TokenDao tdao;

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

    public boolean uploadFileHandler(Long id,String file) {


        if (!file.isEmpty()) {


            try {
                String fileBase64=file.split(",")[1];
                byte[] bytes = Base64.decodeBase64(fileBase64);




                // Creating the directory to store file
                String rootPath = "/home/ded/Documents/mygit/greenteam/booking/src/main/resources/templates/src/assets";


                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                String fileName=RandomStringUtils.randomAlphabetic(4)+".jpg";
                String filePath=dir.getAbsolutePath()
                        + File.separator + fileName;


                new FileOutputStream(filePath).write(bytes);


                Company c=dao.findById(id);
                c.setLogopath(file);
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

    public String checkCredentials(String email, String password)
    {

        Company c=dao.findByEmail(email);

        if(pw.matches(password,c.getPassword()))
        {

            Token tk=new Token();
            tk.generateAuthToken(email);
            tdao.save(tk);

            c.setTokenId(tk.getId());

            dao.save(c);

            return tk.getToken();

        }
        return null;

    }





}
