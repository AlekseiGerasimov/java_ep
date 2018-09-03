package Objects;

import Interfaces.IIssues;
import Interfaces.IReports;
import JDBC.ConnectionDB;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Reports implements IReports{
    private Connection connection;
    private Map<Integer,String> projects;
    private Map<Integer,String> users;
    public Reports(){
        getProjects();
        getUsers();
    }

    @Override
    public void createReportBySpecifiedUserBySpecifiedProject(String userName, String projectName) {
        if(!projects.containsValue(projectName)){
            System.out.println("Введенного вами проекта не существует");
            return;
        }
        if(!users.containsValue(userName)){
            System.out.println("Введенного вами пользователя не существует");
            return;
        }
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("select issue_number,issue_description\n" +
                    "from issues i inner join users u \n" +
                    "on i.id_user = u.id_user\n" +
                    "inner join project p\n" +
                    "on i.id_project = p.id_project\n" +
                    "where project_name = ? and user_name = ?");
            statement.setString(1,projectName);
            statement.setString(2,userName);
            ResultSet set = statement.executeQuery();
            System.out.println("Номер дефекта"+ '\t' + "Описание дефекта");
            while(set.next()){
                System.out.println(set.getString("issue_number")+ '\t' + set.getString("issue_description"));
            }
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные для подключения к БД");
            System.exit(-1);
        }
    }

    public void getUsers(){
        users = new HashMap<>();
        try{
            connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("select * from users");
            ResultSet set1 = statement.getResultSet();
            while(set1.next()){
                users.put(set1.getInt("id_user"),set1.getString("user_name"));
            }
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные для подключения к БД 1 ");
            System.exit(-1);
        }
    }

    public void getProjects(){
        projects = new HashMap<>();
        try{
            connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("select * from project");
            ResultSet set = statement.getResultSet();
            while(set.next()){
                projects.put(set.getInt("id_project"),set.getString("project_name"));
            }
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные для подключения к БД 2 ");
            System.exit(-1);
        }
    }
}
