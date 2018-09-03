package Interfaces;

public interface IProject {
    void addProject(String projectName,String projectDescription);
    void removeProject(String projectName);
    void updateProject(String currentName, String newProjectName, String newProjectDescription);
    void listProjects();
}
