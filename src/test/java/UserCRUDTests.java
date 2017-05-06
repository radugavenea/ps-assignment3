import connection.ConnectionUrl;
import connection.DbSqlScript;
import dataAccessLayer.UserDao;
import dataAccessLayer.UserDaoImpl;
import entities.UserEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by radu on 05.05.2017.
 */
public class UserCRUDTests {


    private UserDao userDao;
    @Before
    public void init(){
        DbSqlScript.runTestDbSqlScript();
        userDao = new UserDaoImpl(ConnectionUrl.testDbUrl);
    }

    @Test
    public void getAllUsersTest() throws SQLException {
        assert userDao.getAllUsers().size() == 5;
    }

    @Test
    public void getUserByIdTest() throws SQLException {
        assert userDao.getByIdUser(1).getName().equals("admin");
        assert userDao.getByIdUser(3).getRole().equals("secretary");
    }

    @Test
    public void insertUserTest() throws SQLException {
        int usersCount = userDao.getAllUsers().size();
        userDao.addNewUser(new UserEntity("doctor","Dorel cel Mare"));
        assert userDao.getAllUsers().size() == usersCount + 1;
    }

    @Test
    public void updateUserTest() throws SQLException {
        assert userDao.getByIdUser(1).getName().equals("admin");

        UserEntity userEntity = userDao.getByIdUser(1);
        userEntity.setName("Gica");
        userDao.updateUser(userEntity);

        assert !userDao.getByIdUser(1).getName().equals("admin");
        assert userDao.getByIdUser(1).getName().equals("Gica");
    }

    @Test
    public void deleteUserTest() throws SQLException {
        int usersCount = userDao.getAllUsers().size();
        userDao.deleteByIdUser(5);
        assert userDao.getAllUsers().size() == usersCount - 1;
    }


    @After
    public void tearDown(){

    }

}
