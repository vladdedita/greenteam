package bookingapp.pack.Services;


import bookingapp.pack.Dao.UserDao;
import bookingapp.pack.Dao.BookingDao;
import bookingapp.pack.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private BookingDao daob;


    public boolean addUser(User u)
    {
        try{
            dao.save(u);



            //return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    public List<User> getAllUsers()
    {

        List<User> users=new ArrayList<User>();

        for(User u : dao.findAll())
            users.add(u);

        return users;

    }


    public boolean updateUser(User user)
    {
        for(User u : dao.findAll())
        {
            if(u.getId()== user.getId())
                try{
                    u.setName(user.getName());
                    u.setEmail(user.getEmail());
                    u.setPhone(user.getPhone());
                    dao.save(u);
                    return true;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    return false;
                }
        }
        return false;
    }

}
