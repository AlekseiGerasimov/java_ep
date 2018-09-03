package Objects;

import Interfaces.IUsers;
import JDBC.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements IUsers{
    private Connection connection;
    public User(){
    }

    @Override
    public void addUser(String userName) {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into users(user_name) values(?)");
            statement.setString(1,userName);
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void removeUser(String userName) {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from users where user_name=?");
            statement.setString(1,userName);
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void updateUser(String currentName, String newName) {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("update users set user_name=? where user_name=?");
            statement.setString(1,newName);
            statement.setString(2,currentName);
            statement.execute();
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные");
            System.exit(-1);
        }
    }

    @Override
    public void listUsers() {
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from users");
            ResultSet set = statement.executeQuery();
            System.out.println("Имя пользователя");
            while(set.next()){
                System.out.println(set.getString("user_name"));
            }
        }
        catch (SQLException ex){
            System.out.println("Введены некорректные данные для подключения к БД");
            System.exit(-1);
        }
    }

}
