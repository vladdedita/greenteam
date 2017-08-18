package bookingapp.pack.Models;

public class CompanyBooking {

    String serviceName;

    String userName;
    String email;
    String phone;



    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CompanyBooking(String serviceName, String userName, String email, String phone,String date) {
        this.serviceName = serviceName;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.date=date;
    }
}
