package JDBC;
import java.sql.*;

public class JDBC {
    public static void main(String []args){
        final String user = "postgres";
        final String url = "jdbc:postgresql://localhost:5432/test";
        final String password = "L19931993";
        try(final Connection connection = DriverManager.getConnection(url,user,password)){
            PreparedStatement statement = connection.prepareStatement("select * from users");
            statement.execute();
            Statement statement1 = connection.createStatement();
//            statement.setInt(1,2);
//            statement.setInt(2,3);
//            Integer a = statement1.executeUpdate("update users set id=10012 where id=1001");
            ResultSet set = statement1.executeQuery("select * from users");
            while(set.next()){
                Integer id = set.getInt("id");
                String values = set.getString("values");
                System.out.println(id + " "+ values);
            }
            System.out.println(statement.executeBatch().length);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally {
        }

    }

}
