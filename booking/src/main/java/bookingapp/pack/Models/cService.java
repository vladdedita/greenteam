package bookingapp.pack.Models;




import javax.persistence.*;

@Entity
@Table(name="service")
public class cService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="duration")
    private Integer duration;

    @Column(name="places")
    private Integer places;

    @Column(name="price")
    private Integer price;

    @Column(name="available")
    private int available;

    @Column(name="id_company")

    private long idCompany;

    @Column(name="calendar")
    private String calendar;

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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;


    }



    protected cService(){

    }
    public cService(String name, String description, Integer duration, Integer places, Integer price, int available, long idCompany) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.places = places;
        this.price = price;
        this.available = available;
        this.idCompany = idCompany;
    }

}
