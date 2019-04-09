package entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseClassTree {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_seq")
    @SequenceGenerator(name = "parent_seq",sequenceName = "parent_id_seq")
    private Long id;

    public Long getId() {
        return id;
    }
}
