package bookingapp.pack.Services;


import bookingapp.pack.Dao.TokenDao;
import bookingapp.pack.Models.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {



    @Autowired
    private TokenDao dao;


    public Token getTokenById(long id)
    {
        return dao.findById(id);
    }
    public Token getTokenByToken(String token)
    {
        return dao.findByToken(token);
    }


    public boolean isValidToken(Token tk)
    {
        if(dao.findById(tk.getId()) != null)
            return true;
        return false;
    }

    public boolean isAuthorizedToken(String token)
    {
        Token tk=getTokenByToken(token);

        if(isValidToken(tk))
        {
            return tk.isAuthorized();
        }
    return false;
    }

}
