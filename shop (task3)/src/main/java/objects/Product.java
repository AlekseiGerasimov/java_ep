package objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private double cost;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name="products_to_user",
            joinColumns=@JoinColumn(name="id_product"),
            inverseJoinColumns=@JoinColumn(name="id_user"))
    private List<User> userList;
}
