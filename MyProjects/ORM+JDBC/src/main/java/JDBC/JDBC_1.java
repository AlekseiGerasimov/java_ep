package JDBC;

import java.sql.*;

public class JDBC_1 {
    public static void main(String []args) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","L19931993")){
            PreparedStatement statement = connection.prepareStatement("select * from users");
            ResultSet set = statement.executeQuery();
            while(set.next()){
                System.out.println(set.getInt("id") + " " + set.getString("values"));
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally {

        }
    }
}
