package hw19.q1.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class Ticket implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @OneToOne
    private Travel travel;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


    public Ticket() {
    }

    @Override
    public void setId(Integer id) {
        this.ticketId = id;

    }

    @Override
    public Integer getId() {
        return ticketId;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Travel getTravel() {
        return travel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getTravel().equals(ticket.getTravel()) &&
                getUser().equals(ticket.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTravel(), getUser());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + ticketId +
                ", travel=" + travel +
                ", user=" + user +
                '}';
    }

}
