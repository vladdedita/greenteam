package bookingapp.pack.Models;


import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="logopath")
    private String logopath;


    protected Company() { }


    public Company(String name,  String email, String password) {
        this.name = name;

        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLogoPath() {
        return logopath;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", logopath='" + logopath + '\'' +
                '}';
    }
}
