package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
    void addUser(User user) throws SQLException;
    void removeUser(int user) throws SQLException;
    void updateUser(User user) throws SQLException;
    List list() throws SQLException;
}
