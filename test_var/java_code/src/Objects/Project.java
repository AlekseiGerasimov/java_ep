package Objects;

import Common.CommonFunctions;
import Common.MyLogger;
import Interfaces.IProject;
import JDBC.ConnectionDB;

import java.sql.*;
import java.util.logging.*;

public class Project implements IProject{
    private Connection connection;
    public Project(){
    }

    @Override
    public void addProject(String projectName, String projectDescription) {
        if(CommonFunctions.getListProjects().containsValue(projectName)){
            MyLogger.log(Level.INFO,Project.class.getName(),"removeProject(String projectName)",
                    "Проект " + projectName + " уже существует.");
            return;
        }
        String query = "insert into project(project_name,project_description) values('" + projectName + "','" + projectDescription + "')";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Project.class.getName(),"addProject(String projectName, String projectDescription)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void removeProject(String projectName) {
        if(!CommonFunctions.getListProjects().containsValue(projectName)){
            MyLogger.log(Level.INFO,Project.class.getName(),"removeProject(String projectName)",
                    "Проекта " + projectName + " не существует, проверьте корректность названия введенного Вами проекта");
            return;
        }
        String query = "delete from project where project_name='" + projectName + "'";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Project.class.getName(),"removeProject(String projectName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void updateProject(String currentName, String newProjectName, String newProjectDescription) {
        if(!CommonFunctions.getListProjects().containsValue(currentName)){
            MyLogger.log(Level.INFO,Project.class.getName(),"updateProject(String currentName, String newProjectName, String newProjectDescription)",
                    "Проекта " + currentName + " не существует, проверьте корректность названия введенного Вами проекта");
            return;
        }
        String query = "update project set project_name='" + newProjectName + "',project_description='" + newProjectDescription + "' where project_name='" + currentName +"'";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Project.class.getName(),"updateProject(String currentName, String newProjectName, String newProjectDescription)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void listProjects() {
        String query = "select * from project";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            System.out.printf("%-40s%-3s%-200s%n","Название проекта"," | ","Описание проекта");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            while(set.next()){
                System.out.printf("%-40s%-3s%-200s%n",set.getString("project_name")," | ",set.getString("project_description"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Project.class.getName(),"listProjects()","При выполнении запроса: "+query+" " +
                    "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

}
