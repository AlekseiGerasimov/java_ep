package Objects;

import Interfaces.IProject;
import JDBC.ConnectionDB;

import java.sql.*;

public class Project implements IProject{
    private Connection connection;
    public Project(){
    }

    @Override
    public void addProject(String projectName, String projectDescription) {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into project(project_name,project_description) values(?,?)");
            statement.setString(1,projectName);
            statement.setString(2,projectDescription);
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void removeProject(String projectName) {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from project where project_name=?");
            statement.setString(1,projectName);
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void updateProject(String currentName, String newProjectName, String newProjectDescription) {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("update project set project_name=?,project_description=? where project_name=?");
            statement.setString(1,newProjectName);
            statement.setString(2,newProjectDescription);
            statement.setString(3,currentName);
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void listProjects() {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from project");
            ResultSet set = statement.executeQuery();
            System.out.println("Название проекта" + '\t' + "Описание проекта");
            while(set.next()){
                System.out.println(set.getString("project_name") + '\t' + set.getString("project_description"));
            }
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные для подключения к БД");
            System.exit(-1);
        }
    }

}
