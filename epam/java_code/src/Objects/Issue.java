package Objects;

import Common.CommonFunctions;
import Common.MyLogger;
import Interfaces.IIssues;
import JDBC.ConnectionDB;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;

public class Issue implements IIssues{
    private Connection connection;
    public Issue(){
    }

    @Override
    public void addIssue(String nameProject,String nameUser,String descriptionIssue) {
        if(!CommonFunctions.getListUsers().containsValue(nameUser)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Пользователя " + nameUser + " не существует в системе");
            return;
        }
        if(!CommonFunctions.getListProjects().containsValue(nameProject)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Проекта " + nameProject + " не существует в системе");
            return;
        }
        Map<Integer,String> projects = CommonFunctions.getListProjects();
        Map<Integer,String> users = CommonFunctions.getListUsers();
        String query = "insert into issues(id_project,id_user,issue_description) values(?,?,?) c параметрами: " + nameProject + ", " + nameUser + ", " + descriptionIssue;
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
            MyLogger.log(Level.WARNING,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void removeIssue(String number_issue) {
        if(!CommonFunctions.getListIssues().contains(number_issue)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Дефекта " + number_issue + " не существует в системе");
            return;
        }
        String query = "delete from issues where issue_number =" + number_issue;
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Issue.class.getName(),"removeIssue(String number_issue)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void updateIssue(String number_issue, String newDescription) {
        if(!CommonFunctions.getListIssues().contains(number_issue)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Дефекта " + number_issue + " не существует в системе");
            return;
        }
        String query = "update issues set issue_description='" +newDescription+"' where issue_number=" + number_issue;
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Issue.class.getName(),"updateIssue(String number_issue, String newDescription)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void listIssue() {
        String query = "select project_name,user_name,issue_number,issue_description\n" +
                "from issues i inner join users u \n" +
                "on i.id_user = u.id_user\n" +
                "inner join project p\n" +
                "on i.id_project = p.id_project\n";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            System.out.printf("%-40s%-3s%-45s%-3s%-18s%-3s%-2000s%n","Название проекта"," | ","Имя пользователя"," | ","Номер дефекта"," | ","Описание дефета");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            while(set.next()){
                System.out.printf("%-40s%-3s%-45s%-3s%-18s%-3s%-2000s%n",set.getString("project_name")," | ",set.getString("user_name")," | ",set.getString("issue_number")," | ",set.getString("issue_description"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Issue.class.getName(),"updateIssue(String number_issue, String newDescription)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }


}
