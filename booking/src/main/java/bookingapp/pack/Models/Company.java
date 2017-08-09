package bookingapp.pack.Models;


import javassist.bytecode.ByteArray;

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
    private byte[] password;

    @Column(name="logopath")
    private String logopath;


    protected Company() { }


    public Company(String name,  String email, byte[] password) {
        this.name = name;

        this.email = email;
        this.password = password;
    }

    public Company(String description) {
        this.description = description;
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

    public byte[] getPassword() {
        return password;
    }

    public String getLogoPath() {
        return logopath;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
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
