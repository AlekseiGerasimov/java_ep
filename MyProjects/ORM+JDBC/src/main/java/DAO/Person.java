package DAO;

public class Person {
    private int id;
    private String person;
    private User user;
    public Person() {}

    public Person(int id, String name_person, User user) {
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
