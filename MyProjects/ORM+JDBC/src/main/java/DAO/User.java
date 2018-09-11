package DAO;

public class User {
    private int id;
    private String values;
    public User() {}

    public User(String values) {
        this.values = values;
    }

    public User(int id, String values) {
        this.id = id;
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
