package Objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="position")
public class Position {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="users_seq")
    @SequenceGenerator(name="users_seq", sequenceName="position_id_pos_seq", allocationSize=1)
    private int id_pos;
    @Column(name = "name_pos")
    private String name_pos;
    @ManyToMany
    @JoinTable (name="worker_to_position",
            joinColumns=@JoinColumn (name="id_position"),
            inverseJoinColumns=@JoinColumn(name="id_work"))
    private List<Worker> workers;

    private int y;
    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public Position() {
    }

    public Position(String name_pos) {
        this.name_pos = name_pos;
    }

    public int getId_pos() {
        return id_pos;
    }

    public void setId_pos(int id_pos) {
        this.id_pos = id_pos;
    }

    public String getName_pos() {
        return name_pos;
    }

    public void setName_pos(String name_pos) {
        this.name_pos = name_pos;
    }
}
