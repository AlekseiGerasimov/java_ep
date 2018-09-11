package JDBC;

import Common.CommonFunctions;
import Common.MyLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Классы, реализующие соединение с БД
 */
public class ConnectionDB {
    private static String url;
    private static Connection connection;
    private ConnectionDB(){
    }
    /**
     * Получение соединения с БД.
     * В случае если метод вызывается в первый раз, то происходит открытие соединения с БД
     * В случае если метод вызывается повторно, то объект соединения просто возвращается.
     * @return Возвращает объект класса Connection, который
     */
    public static Connection getConnection() {
        if(connection == null){
            try {
                url = CommonFunctions.getAppProperties().getProperty("url");
                connection = DriverManager.getConnection(url);
            }
            catch (SQLException ex){
                MyLogger.log(Level.WARNING, ConnectionDB.class.getName(),"Connection getConnection()",
                        "При текущем url: " + url + " невозможно подключиться к БД");
                System.exit(-1);
            }
        }
        return connection;
    }
    /**
     * Закрытие соединения с БД
     */
    public static void closeConnection(){
        if(connection == null)
            return;
        try {
            connection.close();
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING, ConnectionDB.class.getName()," closeConnection()",
                    "Невозможно закрыть соединение с БД");
            System.exit(-1);
        }
    }
}
