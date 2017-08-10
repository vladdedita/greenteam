package bookingapp.pack.Models;




import com.fasterxml.jackson.core.JsonEncoding;

import javax.persistence.*;

@Entity
@Table(name="service")
public class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="duration")
    private String duration;

    @Column(name="places")
    private String places;

    @Column(name="price")
    private String price;

    @Column(name="available")
    private int available;

    @Column(name="id_company")
    private long idCompany;

    @Column(name="calendar")
    private JsonEncoding calendar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public JsonEncoding getCalendar() {
        return calendar;
    }

    public void setCalendar(JsonEncoding calendar) {
        this.calendar = calendar;


    }

    protected Service(){

    }
    public Service(String name, String description, String duration, String places, String price, int available, long idCompany) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.places = places;
        this.price = price;
        this.available = available;
        this.idCompany = idCompany;
    }

}
