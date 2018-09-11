package Interfaces;

public interface IUserToProject {
    void addUserToProject(String userName,String projectName);
    void removeUserFromProject(String userName,String projectName);
    void listUsers();
}
