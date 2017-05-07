package controllers;

import businessLayer.ConsultationService;
import businessLayer.ConsultationServiceImpl;
import connection.ConnectionUrl;
import dataAccessLayer.ConsultationDaoImpl;
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
import java.util.Observable;
import java.util.Observer;

/**
 * Created by radu on 05.05.2017.
 */
public class DoctorController implements Observer {

    private DoctorView view;
    private ConsultationService consultationService;
    private DateFormat timeFormatter = new SimpleDateFormat("HH:mm");

    public DoctorController(DoctorView view) {
        this.view = view;
        this.consultationService = new ConsultationServiceImpl(new ConsultationDaoImpl(ConnectionUrl.dbUrl));

        view.addConsultationTableListener(new DoctorConsultationTableListener());
        view.addButtonsListener(new DoctorButtonsListener());
    }

    @Override
    public void update(Observable o, Object arg) {
        updateConsultationTable();
    }

    private void updateConsultationTable(){
        try {
            view.updateConsultationTable(consultationService.getAllByPatientId(Integer.parseInt(view.getPatientIdInput())));
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
                        consultationService.addNewConsultation(new ConsultationEntity(
                                new Time(timeFormatter.parse(view.getConsultationStartsAtInput()).getTime()),
                                new Time(timeFormatter.parse(view.getConsultationEndsAtInput()).getTime()),
                                view.getConsultationDoctorsNameInput(),
                                Integer.parseInt(view.getConsultationUserIdInput()),
                                Integer.parseInt(view.getConsultationPatientIdInput())));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
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
