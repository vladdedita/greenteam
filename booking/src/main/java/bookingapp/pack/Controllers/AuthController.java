package bookingapp.pack.Controllers;

import bookingapp.pack.Dao.TokenDao;
import bookingapp.pack.Services.TokenService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value="/authorization",method=RequestMethod.POST)
    @CrossOrigin
    public boolean authorize(@RequestBody String body) throws IOException
    {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode node = objectMapper.readTree(body);

            String token = objectMapper.convertValue(node.get("token"), String.class);

            return tokenService.isAuthorizedToken(token);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }

    }

}
