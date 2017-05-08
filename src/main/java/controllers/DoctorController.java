package controllers;

import businessLayer.ConsultationService;
import businessLayer.ConsultationServiceImpl;
import businessLayer.DoctorProgramService;
import businessLayer.DoctorProgramServiceImpl;
import connection.ConnectionUrl;
import dataAccessLayer.ConsultationDaoImpl;
import dataAccessLayer.DoctorProgramDaoImpl;
import dataAccessLayer.UserDaoImpl;
import entities.ConsultationEntity;
import views.DoctorView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by radu on 05.05.2017.
 */
public class DoctorController implements Observer {

    private DoctorView view;
    private String username;
    private ConsultationService consultationService;
    private DoctorProgramService doctorProgramService;
    private DateFormat timeFormatter = new SimpleDateFormat("HH:mm");

//    public DoctorController(DoctorView view, SecretaryController secretaryController) {
    public DoctorController(DoctorView view, String username, SecretaryController secretaryController) {
        this.view = view;
        this.username = username;
        this.consultationService = new ConsultationServiceImpl(new ConsultationDaoImpl(ConnectionUrl.dbUrl));
        this.doctorProgramService = new DoctorProgramServiceImpl(new DoctorProgramDaoImpl(ConnectionUrl.dbUrl),
                new ConsultationDaoImpl(ConnectionUrl.dbUrl),new UserDaoImpl(ConnectionUrl.dbUrl));

        secretaryController.addObserver(this);
//        consultationService.addObserver(this);

        view.addConsultationTableListener(new DoctorConsultationTableListener());
        view.addButtonsListener(new DoctorButtonsListener());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(((String)arg).equals(this.username)){
            view.displayNewConsultationMessage(this.username);
        }
    }

    private void updateConsultationTable(){
        try {
            view.updateConsultationTable(consultationService.getAllByPatientIdForDoctor(Integer.parseInt(view.getPatientIdInput()),username));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    class DoctorButtonsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "read":
                    updateConsultationTable();
                    break;
                case "add":
                    try {
                        if(doctorProgramService.doctorIsAvailableInInterval(
                                view.getConsultationDoctorsNameInput(),
                                new Time(timeFormatter.parse(view.getConsultationStartsAtInput()).getTime()),
                                new Time(timeFormatter.parse(view.getConsultationEndsAtInput()).getTime()))){
                            try {
                                consultationService.addNewConsultation(new ConsultationEntity(
                                        new Time(timeFormatter.parse(view.getConsultationStartsAtInput()).getTime()),
                                        new Time(timeFormatter.parse(view.getConsultationEndsAtInput()).getTime()),
                                        view.getConsultationDoctorsNameInput(),
                                        Integer.parseInt(view.getConsultationUserIdInput()),
                                        Integer.parseInt(view.getConsultationPatientIdInput())),username);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                        }
                        else{
                            view.displayDoctorNotAvailableMessage();
                        }
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
            }
        }
    }

    class DoctorConsultationTableListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(view.getSelectedPatientId() != null){
                try {
                    view.updateInputFields(consultationService.getMappedConsultationById(Integer.parseInt(view.getSelectedConsultationId())));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
