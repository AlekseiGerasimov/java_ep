package entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "parent")
public class Parent extends BaseClassTree{

    @Basic
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_f", referencedColumnName = "id", nullable = false)
    private List<Child> childList = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "childest", joinColumns = @JoinColumn(name = "id_f"))
    @MapKeyColumn(name = "name")
    @Column(name = "id")
    private Map<String,Long> longMap = new HashMap<>();

    public Parent() {
    }

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Long> getLongMap() {
        return longMap;
    }
}
