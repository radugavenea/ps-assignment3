package dataAccessLayer;

import dataAccessUtils.GenericDAO;
import entities.UserEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by radu on 05.05.2017.
 */
public class UserDaoImpl extends GenericDAO<UserEntity> implements UserDao {

    public UserDaoImpl(String connectionUrl) {
        super(connectionUrl);
    }

    @Override
    public List<UserEntity> getAllUsers() throws SQLException {
        return super.getAll();
    }

    @Override
    public int addNewUser(UserEntity user) throws SQLException {
        return super.addNew(user);
    }

    @Override
    public int updateUser(UserEntity user) throws SQLException {
        return super.update(user);
    }
    @Override
    public int deleteByIdUser(int id) throws SQLException {
        return super.deleteById(id);
    }

    @Override
    public UserEntity getByIdUser(int id) throws SQLException {
        return super.getById(id);
    }

    @Override
    public List<UserEntity> getUserByName(String doctorName) throws SQLException {
        return super.getAllByStringField(doctorName,2);
    }
}
