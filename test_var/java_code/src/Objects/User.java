package Objects;

import Common.CommonFunctions;
import Common.MyLogger;
import Interfaces.IUsers;
import JDBC.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class User implements IUsers{
    private Connection connection;
    public User(){
    }

    @Override
    public void addUser(String userName) {
        if(CommonFunctions.getListUsers().containsValue(userName)){
            MyLogger.log(Level.INFO,User.class.getName(),"updateUser(String currentName, String newName) ",
                    "Пользователь " + userName + " уже присутствует в системе");
            return;
        }
        String query = "insert into users(user_name) values('" + userName + "')";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,User.class.getName(),"updateUser(String currentName, String newName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void removeUser(String userName) {
        if(!CommonFunctions.getListUsers().containsValue(userName)){
            MyLogger.log(Level.INFO,User.class.getName(),"updateUser(String currentName, String newName) ",
                    "Пользователя " + userName + " не существует, проверьте корректность названия введенного Вами пользователя");
            return;
        }
        String query = "delete from users where user_name = '" + userName + "'";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,User.class.getName(),"updateUser(String currentName, String newName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void updateUser(String currentName, String newName) {
        if(!CommonFunctions.getListUsers().containsValue(currentName)){
            MyLogger.log(Level.INFO,User.class.getName(),"updateUser(String currentName, String newName) ",
                    "Пользователя " + currentName + " не существует, проверьте корректность названия введенного Вами пользователя");
            return;
        }
        String query = "update users set user_name='" + newName + "' where user_name='" + currentName + "'";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,User.class.getName(),"updateUser(String currentName, String newName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void listUsers() {
        String query = "select * from users";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            System.out.println("Пользователь");
            System.out.println("---------------------------------------------");
            while(set.next()){
                System.out.println(set.getString("user_name"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,User.class.getName(),"listUsers()","При выполнении запроса: "+query+" " +
                    "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

}
