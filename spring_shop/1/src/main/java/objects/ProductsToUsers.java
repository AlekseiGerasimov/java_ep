package objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class ProductsToUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name="user_to_product",
            joinColumns=@JoinColumn(name="id_user"),
            inverseJoinColumns=@JoinColumn(name="id_product"))
    private List<Product> positions;

    public ProductsToUsers(String userName, List<Product> positions) {
        this.userName = userName;
        this.positions = positions;
    }

    public ProductsToUsers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Product> getPositions() {
        return positions;
    }

    public void setPositions(List<Product> positions) {
        this.positions = positions;
    }
}
