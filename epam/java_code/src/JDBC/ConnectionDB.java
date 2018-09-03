package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
//    private static final String user = "postgres";
//    private static final String url = "jdbc:postgresql://localhost:5432/bug_tracker_system";
//    private static final String password = "L19931993";
    private static final String url = "jdbc:sqlite:sqlite/bug_tracker_system.db";
    private static Connection connection;
    private ConnectionDB(){
    }
    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url);
        }
        return connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось закрыть соединение с БД");
        }
    }
}
