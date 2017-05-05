package controllers;

import views.AdminView;
import views.ClinicView;
import views.DoctorView;
import views.SecretaryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by radu on 05.05.2017.
 */
public class ClinicController {

    private ClinicView view;

    public ClinicController(ClinicView view) {
        this.view = view;

        view.addButtonsListener(new ButtonsListener());
    }


    class ButtonsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "admin":
                    new AdminView();
                    break;
                case "doctor":
                    new DoctorView();
                    break;
                case  "secretary":
                    new SecretaryView();
                    break;
            }
        }
    }
}
