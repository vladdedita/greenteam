package bookingapp.pack.Models;

public class Token {
    String token;
    String authorized;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthorized() {
        return authorized;
    }

    public void setAuthorized(String authorized) {
        this.authorized = authorized;
    }

    public Token(String token, String authorized) {
        this.token = token;
        this.authorized = authorized;
    }

    public Token(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", authorized='" + authorized + '\'' +
                '}';
    }
}
