package hw19.q1.entity;

public interface BaseEntity<ID extends Number> {
    void setId(ID id);
    ID getId();
}
