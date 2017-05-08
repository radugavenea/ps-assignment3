package businessLayer;

import entities.UserEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Observer;

/**
 * Created by radu on 06.05.2017.
 */
public interface UserService {

    List<UserEntity> getAllUsers() throws SQLException;
    List<String> getMappedUserById(int id) throws SQLException;
    int addNewUser(String role, String name) throws SQLException;
    int editUser(int id, String role, String name) throws SQLException;
    int deleteUserById(int id) throws SQLException;
    void addObserver(Observer o);
    UserEntity getUserByRole(String role) throws SQLException;
    UserEntity getUserByCredentials(String username, String role) throws SQLException;
}
