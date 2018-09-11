package Objects;

import Common.CommonFunctions;
import Common.MyLogger;
import Interfaces.IUserToProject;
import JDBC.ConnectionDB;

import java.sql.*;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;

public class UserToProject implements IUserToProject {
    private Connection connection;

    public UserToProject(){
    }

    @Override
    public void addUserToProject(String userName, String projectName) {
        if(!CommonFunctions.getListUsers().containsValue(userName)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Пользователя " + userName + " не существует в системе");
            return;
        }
        if(!CommonFunctions.getListProjects().containsValue(projectName)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Проекта " + projectName + " не существует в системе");
            return;
        }
        Map<Integer,String> projects = CommonFunctions.getListProjects();
        Map<Integer,String> users = CommonFunctions.getListUsers();
        String query = "insert into project_to_users(id_project,id_user) values(?,?) c параметрами: " + userName + ", " + projectName;
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into project_to_users(id_project,id_user) values(?,?)");
            Optional<Map.Entry<Integer,String>> projectID = projects.entrySet().stream().filter(project-> project.getValue().equals(projectName)).findFirst();
            Optional<Map.Entry<Integer,String>> userID = users.entrySet().stream().filter(user-> user.getValue().equals(userName)).findFirst();
            statement.setInt(1,projectID.get().getKey());
            statement.setInt(2,userID.get().getKey());
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,UserToProject.class.getName(),"addUserToProject(String userName, String projectName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }

    }

    @Override
    public void removeUserFromProject(String userName, String projectName) {
        if(!CommonFunctions.getListUsers().containsValue(userName)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Пользователя " + userName + " не существует в системе");
            return;
        }
        if(!CommonFunctions.getListProjects().containsValue(projectName)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Проекта " + projectName + " не существует в системе");
            return;
        }
        Map<Integer,String> projects = CommonFunctions.getListProjects();
        Map<Integer,String> users = CommonFunctions.getListUsers();
        String query = "delete from project_to_users where id_project=? and id_user=? c параметрами: " + userName + ", " + projectName;
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from project_to_users where id_project=? and id_user=?");
            Optional<Map.Entry<Integer,String>> projectID = projects.entrySet().stream().filter(project-> project.getValue().equals(projectName)).findFirst();
            Optional<Map.Entry<Integer,String>> userID = users.entrySet().stream().filter(user-> user.getValue().equals(userName)).findFirst();
            statement.setInt(1,projectID.get().getKey());
            statement.setInt(2,userID.get().getKey());
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,UserToProject.class.getName(),"removeUserFromProject(String userName, String projectName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }

    }

    @Override
    public void listUsers() {
        String query = "select project_name,user_name\n" +
                "from project_to_users pr inner join users u \n" +
                "on pr.id_user = u.id_user\n" +
                "inner join project p\n" +
                "on pr.id_project = p.id_project\n";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            System.out.printf("%-40s%-3s%-45s%n","Название проекта"," | ","Имя пользователя");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            while(set.next()){
                System.out.printf("%-40s%-3s%-45s%n",set.getString("project_name")," | ",set.getString("user_name"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,UserToProject.class.getName(),"removeUserFromProject(String userName, String projectName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

}
