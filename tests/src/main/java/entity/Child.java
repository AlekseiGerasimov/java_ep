package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "child")
public class Child extends BaseClassTree{
    @Basic
    private String name;

    @Column(name = "id_f", nullable = false, insertable = false, updatable = false)
    private Integer id_f;

    public Child() {
    }

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_f() {
        return id_f;
    }

    public void setId_f(Integer id_f) {
        this.id_f = id_f;
    }
}
