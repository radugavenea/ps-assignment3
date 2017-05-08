package mainApp;

import businessLayer.UserService;
import businessLayer.UserServiceImpl;
import connection.ConnectionUrl;
import dataAccessLayer.UserDaoImpl;
import entities.UserEntity;

import java.sql.SQLException;

/**
 * Created by radu on 08.04.2017.
 */
public class LoginSession {

    private UserService userService;

    public LoginSession() {
        this.userService = new UserServiceImpl(new UserDaoImpl(ConnectionUrl.dbUrl));
    }

    public boolean login(String role){
        boolean logged;
        try {
            UserEntity user = userService.getUserByRole(role);
            logged = user != null;
            if(logged){
                Session.add(role);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean logout(){
        Session.getUsername();
        Session.close();
        return true;
    }

    public String getUsername(){
        return Session.getUsername();
    }
}
