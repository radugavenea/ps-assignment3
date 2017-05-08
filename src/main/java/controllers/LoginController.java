package controllers;

import businessLayer.UserService;
import businessLayer.UserServiceImpl;
import connection.ConnectionUrl;
import dataAccessLayer.UserDaoImpl;
import entities.UserEntity;
import views.AdminView;
import views.DoctorView;
import views.LoginView;
import views.SecretaryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by radu on 08.05.2017.
 */
public class LoginController {

    private LoginView loginView;
    private UserService userService;
    private SecretaryController secretaryController;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.userService = new UserServiceImpl(new UserDaoImpl(ConnectionUrl.dbUrl));

        loginView.addLoginListener(new LoginListener());
    }


    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UserEntity userEntity = null;
            try {
                userEntity = userService.getUserByCredentials(loginView.getUsername(),loginView.getRole());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if(userEntity != null){
                switch (loginView.getRole()){
                    case "admin":
                        new AdminController(new AdminView(loginView.getUsername()), loginView.getUsername());
                        break;
                    case "doctor":
                        new DoctorController(new DoctorView(loginView.getUsername()), loginView.getUsername(), secretaryController);
                        break;
                    case "secretary":
                        secretaryController = new SecretaryController(new SecretaryView(loginView.getUsername()), loginView.getUsername());
                        break;
                }
            }
            else {
                loginView.displayErrorMessage();
            }
        }
    }

}
