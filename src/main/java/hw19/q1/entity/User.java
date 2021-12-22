package hw19.q1.entity;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullname;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    private String username;


    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Ticket> tickets = new LinkedHashSet<>();


    public User(String fullname, Gender gender, String username, String password) {
        this.fullname = fullname;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public void setId(Integer id) {
        this.id = id;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getFullname().equals(user.getFullname()) &&
                getGender() == user.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullname(), getGender());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", gender=" + gender +
                '}';
    }


}
