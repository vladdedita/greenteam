package bookingapp.pack.Models;


import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="id_service")
    private long id_service;
    @Column(name="id_user")
    private long id_user;
    @Column(name="date")
    private String date;
    @Column(name="places")

    private int places;

    public Booking(long id_service, long id_user, String date, int places) {
        this.id_service = id_service;
        this.id_user = id_user;
        this.date = date;
        this.places = places;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_service() {
        return id_service;
    }

    public void setId_service(long id_service) {
        this.id_service = id_service;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", id_service=" + id_service +
                ", id_user=" + id_user +
                ", date='" + date + '\'' +
                ", places=" + places +
                '}';
    }
}
