package controllers;

import businessLayer.UserService;
import businessLayer.UserServiceImpl;
import connection.ConnectionUrl;
import dataAccessLayer.UserDaoImpl;
import views.AdminView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by radu on 05.05.2017.
 */
public class AdminController implements Observer{

    private AdminView view;
    private UserService userService;
    private String username;


    public AdminController(AdminView view, String username) {
        this.view = view;
        this.username = username;
        this.userService = new UserServiceImpl(new UserDaoImpl(ConnectionUrl.dbUrl));

        updateTable();
        userService.addObserver(this);

        view.addTableSelectionListener(new TableListSelectionListener());
        view.addButtonsListener(new ButtonListener());
    }


    @Override
    public void update(Observable o, Object arg) {
        updateTable();
    }

    private void updateTable(){
        try {
            view.updateUserTable(userService.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "read":
                    try {
                        view.updateUserTable(userService.getAllUsers());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "add":
                    try {
                        userService.addNewUser(view.getRoleInput(),view.getNameInput());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "edit":
                    try {
                        userService.editUser(Integer.parseInt(view.getIdInput()),view.getRoleInput(),view.getNameInput());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "delete":
                    try {
                        userService.deleteUserById(Integer.parseInt(view.getIdInput()));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
            }
        }
    }

    class TableListSelectionListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                if(view.getSelectedRowUserId() != null){
                    view.updateViewInputs(userService.getMappedUserById(Integer.parseInt(view.getSelectedRowUserId())));
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

}
