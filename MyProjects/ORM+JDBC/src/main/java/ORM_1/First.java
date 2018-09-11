package ORM_1;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class First {
    @Id
    @Column(name = "id", nullable = false, length = 100)
    private int id;
    @Column(name = "values", nullable = false, length = 100)
    private String name;

    public First() {}
    public First(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

}