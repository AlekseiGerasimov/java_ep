package Interfaces;

public interface IUsers {
    void addUser(String userName);
    void removeUser(String userName);
    void updateUser(String currentName, String newtName);
    void listUsers();
}
