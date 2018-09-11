package Common;

import JDBC.ConnectionDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.*;

/**
 * В данном классе описываются методы, который используются во многих частях программы
 */
public class CommonFunctions {
    private static Connection connection = ConnectionDB.getConnection();
    private static Map<Integer,String> projects;
    private static Map<Integer,String> users;
    private static List<String> issues;
    private static Properties properties;

    /**
     * Получение текущего списка пользователей
     * @return Возвращает текущий список пользователей с их идентификаторами
     */
    public static Map<Integer,String> getListUsers(){
        users = new HashMap<>();
        String query = "select * from users";
        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet set1 = statement.getResultSet();
            while(set1.next()){
                users.put(set1.getInt("id_user"),set1.getString("user_name"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING, CommonFunctions.class.getName()," Map<Integer,String> getListUsers()",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
        return users;
    }

    /**
     * Получение текущего списка проектов
     * @return Возвращает текущий список проектов с их идентификаторами
     */
    public static Map<Integer,String> getListProjects(){
        projects = new HashMap<>();
        String query = "select * from project";
        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet set = statement.getResultSet();
            while(set.next()){
                projects.put(set.getInt("id_project"),set.getString("project_name"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING, CommonFunctions.class.getName()," Map<Integer,String> getListProjects()",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
        return projects;
    }

    /**
     * Получение текущего списка дефектов
     * @return Возвращает текущий список дефектов
     */
    public static List<String> getListIssues(){
        issues = new ArrayList<>();
        String query = "select * from issues";
        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet set = statement.getResultSet();
            while(set.next()){
                issues.add(set.getString("issue_number"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING, CommonFunctions.class.getName(),"List<String> getListIssues()",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
        return issues;
    }

    /**
     * Получение файла настроек (application.properties) , из которого впоследствии можно получить необходимкю информацию
     * @return Возвращает файл настроек
     */
    public static Properties getAppProperties(){
        if(properties == null){
            try {
                properties = new Properties();
                properties.load(new FileInputStream(new File("./application.properties")));
            } catch (IOException e) {
                MyLogger.log(Level.WARNING, CommonFunctions.class.getName(),"Properties getAppProperties()",
                        "При запросе файла настроек возникла ошибка, проверьте путь до файла, права доступа и всё остальное, что может вызывать ошибку");
                System.exit(-1);
            }
        }
        return properties;
    }
}
