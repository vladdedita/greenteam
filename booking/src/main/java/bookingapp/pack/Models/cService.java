package bookingapp.pack.Models;




import com.google.gson.Gson;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<String,Map<Integer,Integer>> calendar=new HashMap<String, Map<Integer, Integer>>();

        List<String> zi=new ArrayList<String>();

        zi.add("0");
        zi.add("1");
        zi.add("2");
        zi.add("3");
        zi.add("4");
        zi.add("5");
        zi.add("6");

        Map<Integer,Integer> ora=new HashMap<Integer, Integer>();


        for(int i=7;i<=18;i++)
        {
            ora.put(i,10);
        }

        for(String s : zi)
        {
            calendar.put(s,ora);
        }

        this.calendar=new Gson().toJson(calendar);


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
