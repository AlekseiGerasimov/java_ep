package DAO;

import javax.persistence.*;


@Entity
@Table(name="Person")
public class Person_ant {
    @Id
    @Column(name = "id_person")
    private int id;
    @Column(name = "name_person")
    private String person;
    @ManyToOne
    @JoinColumn(name="id_user_test", nullable=false)
    private User user;
    public Person_ant() {}

    public Person_ant(int id, String name_person, User user) {
        this.id = id;
        this.person = name_person;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String values) {
        this.person = values;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
