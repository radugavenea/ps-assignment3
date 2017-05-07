package controllers;

import businessLayer.PatientService;
import businessLayer.PatientServiceImpl;
import businessLayer.ConsultationService;
import businessLayer.ConsultationServiceImpl;
import connection.ConnectionUrl;
import dataAccessLayer.ConsultationDaoImpl;
import dataAccessLayer.PatientDaoImpl;
import entities.ConsultationEntity;
import entities.PatientEntity;
import views.SecretaryView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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
public class SecretaryController implements Observer {

    private SecretaryView view;
    private PatientService patientService;
    private ConsultationService consultationService;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat timeFormatter = new SimpleDateFormat("HH:mm");

    public SecretaryController(SecretaryView view) {
        this.view = view;
        this.patientService = new PatientServiceImpl(new PatientDaoImpl(ConnectionUrl.dbUrl));
        this.consultationService = new ConsultationServiceImpl(new ConsultationDaoImpl(ConnectionUrl.dbUrl));

        updatePatientTable();
        updateConsultationTable();

        patientService.addObserver(this);
        consultationService.addObserver(this);

        view.addPatientButtonsListener(new PatientButtonsListener());
        view.addConsultationButtonsListener(new ConsultationButtonsListener());
        view.addPatientTableListener(new PatientTableListener());
        view.addConsultationTableListener(new ConsultationTableListener());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof PatientServiceImpl){
            updatePatientTable();
        }
        if (arg instanceof ConsultationServiceImpl) {
            updateConsultationTable();
        }
    }

    private void updatePatientTable(){
        try {
            view.updatePatientTable(patientService.getAllPatients());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateConsultationTable(){
        try {
            view.updateConsultationTable(consultationService.getAllConsultations());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    class PatientButtonsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "read":
                    try {
                        view.updatePatientTable(patientService.getAllPatients());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "add":
                    try {
                        patientService.addNewPatient(new PatientEntity(
                                view.getPatientNameInput(),
                                view.getPatientCardNumberInput(),
                                view.getPatientNumericalCodeInput(),
                                new Date(dateFormat.parse(view.getPatientBirthdayInput()).getTime()),
                                view.getPatientAddressInput()));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "edit":
                    try {
                        patientService.editPatient(new PatientEntity(
                                Integer.parseInt(view.getPatientIdInput()) ,
                                view.getPatientNameInput(),
                                view.getPatientCardNumberInput(),
                                view.getPatientNumericalCodeInput(),
                                new Date(dateFormat.parse(view.getPatientBirthdayInput()).getTime()),
                                view.getPatientAddressInput()));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    break;
            }
        }
    }

    class ConsultationButtonsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "read":
                    try {
                        view.updateConsultationTable(consultationService.getAllConsultations());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
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
                case "edit":
                    try {
                        consultationService.editConsultation(new ConsultationEntity(
                                Integer.parseInt(view.getConsultationIdInput()),
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
                case "delete":
                    try {
                        consultationService.deleteByIdConsultation(Integer.parseInt(view.getConsultationIdInput()));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
            }
        }
    }

    class PatientTableListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(view.getSelectedPatientId() != null){
                try {
                    view.updatePatientInputs(patientService.getMappedPatientById(Integer.parseInt(view.getSelectedPatientId())));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    class ConsultationTableListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(view.getSelectedConsultationId() != null){
                try {
                    view.updateConsultationInputs(consultationService.getMappedConsultationById(Integer.parseInt(view.getSelectedConsultationId())));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
