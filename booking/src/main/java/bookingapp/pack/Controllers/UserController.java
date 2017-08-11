package bookingapp.pack.Controllers;


import bookingapp.pack.Models.User;
import bookingapp.pack.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    @CrossOrigin
    public String addUser(@RequestBody User u)
    {
        try {
            userService.addUser(u);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return null;
    }

    @RequestMapping(value = "/updateuser",method = RequestMethod.PUT)
    @CrossOrigin
    public boolean updateUser(@RequestBody User u)
    {
        return userService.updateUser(u);
    }


    @RequestMapping(value="/users")
    @CrossOrigin
    public List<User> getCompanies()
    {
        return userService.getAllUsers();
    }



}
