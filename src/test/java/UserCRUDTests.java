import connection.ConnectionUrl;
import connection.DbSqlScript;
import dataAccessLayer.UserDao;
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
        userDao = new UserDao(ConnectionUrl.testDbUrl);
    }

    @Test
    public void getAllUsersTest() throws SQLException {
        assert userDao.getAll().size() == 5;
    }

    @Test
    public void getUserByIdTest() throws SQLException {
        assert userDao.getById(1).getName().equals("admin");
        assert userDao.getById(3).getRole().equals("secretary");
    }

    @Test
    public void insertUserTest() throws SQLException {
        int usersCount = userDao.getAll().size();
        userDao.addNew(new UserEntity("doctor","Dorel cel Mare"));
        assert userDao.getAll().size() == usersCount + 1;
    }

    @Test
    public void updateUserTest() throws SQLException {
        assert userDao.getById(1).getName().equals("admin");

        UserEntity userEntity = userDao.getById(1);
        userEntity.setName("Gica");
        userDao.update(userEntity);

        assert !userDao.getById(1).getName().equals("admin");
        assert userDao.getById(1).getName().equals("Gica");
    }

    @Test
    public void deleteUserTest() throws SQLException {
        int usersCount = userDao.getAll().size();
        userDao.deleteById(5);
        assert userDao.getAll().size() == usersCount - 1;
    }


    @After
    public void tearDown(){

    }

}
