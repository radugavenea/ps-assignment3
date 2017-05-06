package businessLayer;

import dataAccessLayer.UserDao;
import dataAccessLayer.UserDaoImpl;
import entities.UserEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by radu on 06.05.2017.
 */
public class UserServiceImpl extends Observable implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserEntity> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    @Override
    public int addNewUser(String role, String name) throws SQLException {
        int returnId = userDao.addNewUser(new UserEntity(role,name));
        setChanged();
        notifyObservers();
        return returnId;
    }

    @Override
    public int editUser(int id, String role, String name) throws SQLException {
        int returnId = userDao.updateUser(new UserEntity(id,role,name));
        setChanged();
        notifyObservers();
        return returnId;
    }

    @Override
    public int deleteUserById(int id) throws SQLException {
        int returnId = userDao.deleteByIdUser(id);
        setChanged();
        notifyObservers();
        return returnId;
    }

    @Override
    public List<String> getMappedUserById(int id) throws SQLException {
        List<String> fields = new ArrayList<>();
        UserEntity user = userDao.getByIdUser(id);
        if(user != null){
            fields.add(Integer.toString(user.getId()));
            fields.add(user.getRole());
            fields.add(user.getName());
        }
        return fields.isEmpty() ? null : fields;
    }
}
