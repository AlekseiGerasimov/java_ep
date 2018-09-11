package DAO;

import DAO.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDAO implements DAO {
    private Connection connection;
    private String url;
    private String user;
    private String password;
    public UserDAO() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("./database.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    @Override
    public void addUser(User user) throws SQLException {
        if(connection == null)
            init();
        PreparedStatement statement = connection.prepareStatement("insert into users values((?),(?))");
        statement.setInt(1,user.getId());
        statement.setString(2,user.getValues());
        statement.execute();
    }

    @Override
    public void removeUser(int user) throws SQLException {
        if(connection == null)
            init();
        PreparedStatement statement = connection.prepareStatement("delete from users where id=(?)");
        statement.setInt(1,user);
        statement.execute();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        if(connection == null)
            init();
        PreparedStatement statement = connection.prepareStatement("update users SET values=(?) WHERE id="+user.getId());
        statement.setString(1,user.getValues());
        statement.execute();
    }

    @Override
    public List list() throws SQLException {
        if(connection == null)
            init();
        List<User> user = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from users");
        ResultSet set = statement.executeQuery();
        while(set.next()){
            user.add(new User(set.getInt("id"),set.getString("values")));
        }
        return user;
    }

    private void init() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }
}
