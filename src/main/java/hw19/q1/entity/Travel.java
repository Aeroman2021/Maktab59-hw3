package hw19.q1.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "travels")
public class Travel implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_id")
    private Integer id;

    @Column(name = "origin_city")
    private String OriginCity;

    @Column(name = "destination_city")
    private String destinationCity;

    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "travel_id")
    private Ticket ticket;

    public Travel(String originCity, String destinationCity, Date date) {
        OriginCity = originCity;
        this.destinationCity = destinationCity;
        this.date = date;
    }

    public Travel() {
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getOriginCity() {
        return OriginCity;
    }

    public void setOriginCity(String originCity) {
        OriginCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Travel)) return false;
        Travel travel = (Travel) o;
        return
                getOriginCity().equals(travel.getOriginCity()) &&
                getDestinationCity().equals(travel.getDestinationCity()) &&
                getDate().equals(travel.getDate()) &&
                getTicket().equals(travel.getTicket());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOriginCity(), getDestinationCity(), getDate(), getTicket());
    }

    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", OriginCity='" + OriginCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", date=" + date +
                ", ticket=" + ticket +
                '}';
    }
}
