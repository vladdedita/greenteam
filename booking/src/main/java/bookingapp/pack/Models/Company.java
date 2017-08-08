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

    @Column(name="logo_path")
    private String logoPath;


    protected Company() { }
    public Company(String name, String description, String email, String password, String logoPath) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.password = password;
        this.logoPath = logoPath;
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
        return logoPath;
    }


}
