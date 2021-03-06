package dataAccessLayer;

import entities.UserEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by radu on 06.05.2017.
 */
public interface UserDao {
    List<UserEntity> getAllUsers() throws SQLException;
    int addNewUser(UserEntity user) throws SQLException;
    int updateUser(UserEntity user) throws SQLException;
    int deleteByIdUser(int id) throws SQLException;
    UserEntity getByIdUser(int id) throws SQLException;
    List<UserEntity> getUserByName(String doctorName) throws SQLException;
    List<UserEntity> getUserByRole(String role) throws SQLException;
}
