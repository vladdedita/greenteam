package bookingapp.pack.Models;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name="token")
public class Token {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;
    @Column(name="token")
    String token;

    @Column(name="date")
    Date date;

    @Column(name="authorized")
    boolean authorized;




    //private int sessionLife=30;

    public Token() {
        this.date = new Date();
        this.authorized=false;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public Token(String token, boolean authorized) {
        this.token = token;
        this.authorized = authorized;
    }

    public Token(String token) {
        this.token = token;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void generateAuthToken(String email)
    {
        this.token = UUID.randomUUID().toString().toUpperCase() +
                "|" + email +
                "|" + date.toString();

        this.authorized=true;
    }

    public boolean checkTokenExpiration()
    {

        Date currentDate=new Date();
        Date creationDate=date;

        creationDate.setMinutes(creationDate.getMinutes()+30);

            if(!creationDate.after(currentDate))
            {
                return false;
            }

        return true;
    }






    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", authorized='" + authorized + '\'' +
                '}';
    }
}
