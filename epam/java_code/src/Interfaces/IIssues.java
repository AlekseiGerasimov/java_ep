package Interfaces;

public interface IIssues {
    void addIssue(String nameProject,String nameUser,String descriptionIssue);
    void removeIssue(String number_issue);
    void updateIssue(String currentDescription, String newDescription);
    void listIssue();
}
