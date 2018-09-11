package Objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="worker")
public class Worker {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq")
    @SequenceGenerator(name="users_seq", sequenceName="worker_id_seq", allocationSize=1)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "male")
    private String male;
    @ManyToMany
    @JoinTable (name="worker_to_position",
            joinColumns=@JoinColumn(name="id_work"),
            inverseJoinColumns=@JoinColumn(name="id_position"))
    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Worker() {
    }

    public Worker(String name, String male) {
        this.name = name;
        this.male = male;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }
}
