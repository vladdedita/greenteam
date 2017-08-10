package bookingapp.pack.Models;


import javax.persistence.*;


@Entity
@Table(name="service")
public class Cservice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="duration")
    private int duration;

    @Column(name="spaces")
    private int spaces;

    @Column(name="price")
    private int price;

    @Column(name="available")
    private int available;

    @Column(name="companyid")
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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


    @Override
    public String toString() {
        return "Cservice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", spaces=" + spaces +
                ", price=" + price +
                ", available=" + available +
                ", idCompany=" + idCompany +
                ", calendar='" + calendar + '\'' +
                '}';
    }


    protected Cservice(){
    }

    public Cservice(String name, String description, int duration, int spaces, int price, int available, long idCompany, String calendar) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.spaces = spaces;
        this.price = price;
        this.available = available;
        this.idCompany = idCompany;
        this.calendar=calendar;
    }

}
