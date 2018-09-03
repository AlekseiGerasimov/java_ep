package Objects;

import Interfaces.IIssues;
import Interfaces.IUsers;
import JDBC.ConnectionDB;

import java.sql.*;
import java.util.*;

public class Issue implements IIssues{
    private Connection connection;
    private Map<Integer,String> projects;
    private Map<Integer,String> users;
    public Issue(){
        getProjects();
        getUsers();
    }

    @Override
    public void addIssue(String nameProject,String nameUser,String descriptionIssue) {
        if(!projects.containsValue(nameProject)){
            System.out.println("Введенного вами проекта не существует");
            return;
        }
        if(!users.containsValue(nameUser)){
            System.out.println("Введенного вами пользователя не существует");
            return;
        }
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into issues(id_project,id_user,issue_description) values(?,?,?)");
            Optional<Map.Entry<Integer,String>> projectID = projects.entrySet().stream().filter(project-> project.getValue().equals(nameProject)).findFirst();
            Optional<Map.Entry<Integer,String>> userID = users.entrySet().stream().filter(user-> user.getValue().equals(nameUser)).findFirst();
            statement.setInt(1,projectID.get().getKey());
            statement.setInt(2,userID.get().getKey());
            statement.setString(3,descriptionIssue);
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void removeIssue(String number_issue) {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from issues where issue_number =?");
            statement.setInt(1,Integer.parseInt(number_issue));
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void updateIssue(String number_issue, String newDescription) {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("update issues set issue_description=? where issue_number=?");
            statement.setString(1,newDescription);
            statement.setInt(2,Integer.parseInt(number_issue));
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void listIssue() {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("select project_name,user_name,issue_number,issue_description\n" +
                    "from issues i inner join users u \n" +
                    "on i.id_user = u.id_user\n" +
                    "inner join project p\n" +
                    "on i.id_project = p.id_project\n");
            ResultSet set = statement.executeQuery();
            System.out.println("Название проекта" + '\t' + "Имя пользователя" + '\t' + "Номер дефекта"+ '\t' + "Описание дефекта");
            while(set.next()){
                System.out.println(set.getString("project_name") + '\t' + set.getString("user_name")+ '\t' + set.getString("issue_number")+ '\t' + set.getString("issue_description"));
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
