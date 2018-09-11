package DAO;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String []args) throws SQLException {
        UserDAO dao = new UserDAO();
        User user1 = new User(3,"Xorosh");
        dao.removeUser(101);
        dao.updateUser(user1);
        List<User> list = dao.list();
        for(User user : list){
            System.out.println(user.getId() + " " +user.getValues());
        }
    }
}
