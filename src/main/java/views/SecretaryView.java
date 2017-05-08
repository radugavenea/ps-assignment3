package views;

import entities.ConsultationEntity;
import entities.PatientEntity;
import viewTableUtils.ConsultationTableModel;
import viewTableUtils.GenericTableModel;
import viewTableUtils.PatientTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by radu on 05.05.2017.
 */
public class SecretaryView{

    private JFrame frame = new JFrame("Secretary View");
    private JTabbedPane tabbedPane = new JTabbedPane();

    private JPanel patientButtonPanel = new JPanel();
    private JPanel patientInputPanel = makeTextPanel();
    private GenericTableModel patientTableModel = new PatientTableModel();
    private JTable patientTable = new JTable();
    private JScrollPane patientScrollPane = new JScrollPane(patientTable);
    private JSplitPane patientInsideSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, patientScrollPane, patientInputPanel);
    private JSplitPane patientSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, patientInsideSplitPane, patientButtonPanel);

    private JLabel patientIdLabel = new JLabel("Patient id");
    private JLabel patientNameLabel = new JLabel("Patient name");
    private JLabel patientCardNumberLabel = new JLabel("Patient card number");
    private JLabel patientNumericalCodeLabel = new JLabel("Patient numerical code");
    private JLabel patientBirthdayLabel = new JLabel("Patient birthday");
    private JLabel patientAddressLabel = new JLabel("Patient address");
    private JTextField patientIdInput = new JTextField(30);
    private JTextField patientNameInput = new JTextField(30);
    private JTextField patientCardNumberInput = new JTextField(30);
    private JTextField patientNumericalCodeInput = new JTextField(30);
    private JTextField patientBirthdayInput = new JTextField(30);
    private JTextField patientAddressInput = new JTextField(30);

    private JButton patientReadButton = new JButton("Read");
    private JButton patientAddButton = new JButton("Add");
    private JButton patientEditButton = new JButton("Edit");


    private JPanel consultationButtonPanel = new JPanel();
    private JPanel consultationInputPanel = makeTextPanel();
    private GenericTableModel consultationTableModel = new ConsultationTableModel();
    private JTable consultationTable = new JTable();
    private JScrollPane consultationScrollPane = new JScrollPane(consultationTable);
    private JSplitPane consultationInsideSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, consultationScrollPane, consultationInputPanel);
    private JSplitPane consultationSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, consultationInsideSplitPane, consultationButtonPanel);

    private JLabel consultationIdLabel = new JLabel("Consultation id");
    private JLabel consultationStartsAtTimeLabel = new JLabel("Consultation starts at");
    private JLabel consultationEndsAtTimeLabel = new JLabel("Consultation ends at");
    private JLabel consultationDoctorsNameLabel = new JLabel("Doctor's name");
    private JLabel consultationUserIdLabel = new JLabel("Consultation user id");
    private JLabel consultationPatientIdLabel = new JLabel("Consultation patient id");
    private JTextField consultationIdInput = new JTextField(30);
    private JTextField consultationStartsAtTimeInput = new JTextField(30);
    private JTextField consultationEndsAtTimeInput = new JTextField(30);
    private JTextField consultationDoctorsNameInput = new JTextField(30);
    private JTextField consultationUserIdInput = new JTextField(30);
    private JTextField consultationPatientIdInput = new JTextField(30);

    private JButton consultationReadButton = new JButton("Read");
    private JButton consultationAddButton = new JButton("Add");
    private JButton consultationEditButton = new JButton("Edit");
    private JButton consultationDeleteButton = new JButton("Delete");



    public SecretaryView(String username) throws HeadlessException {
        initializeFrame(username);
    }


    private void initializeFrame(String username){

        frame.setTitle("Secretary View for username " + username);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(800,600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width-frame.getWidth())/2, (dim.height-frame.getHeight())/2);
        frame.setResizable(false);

        setUpPatientTab();
        setUpConsultationTab();

        tabbedPane.add("Patients",patientSplitPane);
        tabbedPane.add("Consultations",consultationSplitPane);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }


    public String getPatientIdInput(){ return patientIdInput.getText(); }
    public String getPatientNameInput(){ return patientNameInput.getText(); }
    public String getPatientCardNumberInput(){ return patientCardNumberInput.getText(); }
    public String getPatientNumericalCodeInput(){ return patientNumericalCodeInput.getText(); }
    public String getPatientBirthdayInput(){ return patientBirthdayInput.getText(); }
    public String getPatientAddressInput(){ return patientAddressInput.getText(); }
    public String getConsultationIdInput(){ return consultationIdInput.getText(); }
    public String getConsultationStartsAtInput(){ return consultationStartsAtTimeInput.getText(); }
    public String getConsultationEndsAtInput(){ return consultationEndsAtTimeInput.getText(); }
    public String getConsultationDoctorsNameInput(){ return consultationDoctorsNameInput.getText(); }
    public String getConsultationUserIdInput(){ return consultationUserIdInput.getText(); }
    public String getConsultationPatientIdInput(){ return consultationPatientIdInput.getText(); }



    public void addPatientButtonsListener(ActionListener listener){
        patientReadButton.addActionListener(listener);
        patientAddButton.addActionListener(listener);
        patientEditButton.addActionListener(listener);
        patientReadButton.setActionCommand("read");
        patientAddButton.setActionCommand("add");
        patientEditButton.setActionCommand("edit");
    }

    public void addConsultationButtonsListener(ActionListener listener){
        consultationReadButton.addActionListener(listener);
        consultationReadButton.setActionCommand("read");
        consultationEditButton.addActionListener(listener);
        consultationEditButton.setActionCommand("edit");
        consultationAddButton.addActionListener(listener);
        consultationAddButton.setActionCommand("add");
        consultationDeleteButton.addActionListener(listener);
        consultationDeleteButton.setActionCommand("delete");
    }

    public void addPatientTableListener(ListSelectionListener listSelectionListener){
        patientTable.getSelectionModel().addListSelectionListener(listSelectionListener);
    }
    public void addConsultationTableListener(ListSelectionListener listSelectionListener){
        consultationTable.getSelectionModel().addListSelectionListener(listSelectionListener);
    }

    public void updatePatientTable(List<PatientEntity> patients){
        patientTableModel.setDataVector(patients);
    }
    public void updateConsultationTable(List<ConsultationEntity> consultations){
        consultationTableModel.setDataVector(consultations);
    }
    
    public void updatePatientInputs(List<String> fields){
        patientIdInput.setText(fields.get(0));
        patientNameInput.setText(fields.get(1));
        patientCardNumberInput.setText(fields.get(2));
        patientNumericalCodeInput.setText(fields.get(3));
        patientBirthdayInput.setText(fields.get(4));
        patientAddressInput.setText(fields.get(5));
    }

    public void updateConsultationInputs(List<String> fields){
        consultationIdInput.setText(fields.get(0));
        consultationStartsAtTimeInput.setText(fields.get(1));
        consultationEndsAtTimeInput.setText(fields.get(2));
        consultationDoctorsNameInput.setText(fields.get(3));
        consultationUserIdInput.setText(fields.get(4));
        consultationPatientIdInput.setText(fields.get(5));
    }

    public String getSelectedPatientId(){
        int row = patientTable.getSelectedRow();
        return row > -1 ? patientTable.getValueAt(row,0).toString() : null;
    }

    public String getSelectedConsultationId(){
        int row = consultationTable.getSelectedRow();
        return row > -1 ? consultationTable.getValueAt(row,0).toString() : null;
    }


    public void displayDoctorNotAvailableMessage() {
        JOptionPane.showMessageDialog(frame, "Doctor not available for this period of time.");
    }

    private void setUpPatientTab(){
        patientTable.setModel(patientTableModel);
        patientInsideSplitPane.setDividerLocation(300);
        patientSplitPane.setDividerLocation(480);
        patientIdInput.setEditable(false);
        patientInputPanel.add(patientIdLabel);
        patientInputPanel.add(patientIdInput);
        patientInputPanel.add(patientNameLabel);
        patientInputPanel.add(patientNameInput);
        patientInputPanel.add(patientCardNumberLabel);
        patientInputPanel.add(patientCardNumberInput);
        patientInputPanel.add(patientNumericalCodeLabel);
        patientInputPanel.add(patientNumericalCodeInput);
        patientInputPanel.add(patientBirthdayLabel);
        patientInputPanel.add(patientBirthdayInput);
        patientInputPanel.add(patientAddressLabel);
        patientInputPanel.add(patientAddressInput);
        patientButtonPanel.add(patientReadButton);
        patientButtonPanel.add(patientAddButton);
        patientButtonPanel.add(patientEditButton);
    }

    private void setUpConsultationTab(){
        consultationTable.setModel(consultationTableModel);
        consultationInsideSplitPane.setDividerLocation(300);
        consultationSplitPane.setDividerLocation(480);
        consultationIdInput.setEditable(false);
        consultationInputPanel.add(consultationIdLabel);
        consultationInputPanel.add(consultationIdInput);
        consultationInputPanel.add(consultationStartsAtTimeLabel);
        consultationInputPanel.add(consultationStartsAtTimeInput);
        consultationInputPanel.add(consultationEndsAtTimeLabel);
        consultationInputPanel.add(consultationEndsAtTimeInput);
        consultationInputPanel.add(consultationDoctorsNameLabel);
        consultationInputPanel.add(consultationDoctorsNameInput);
        consultationInputPanel.add(consultationUserIdLabel);
        consultationInputPanel.add(consultationUserIdInput);
        consultationInputPanel.add(consultationPatientIdLabel);
        consultationInputPanel.add(consultationPatientIdInput);
        consultationButtonPanel.add(consultationReadButton);
        consultationButtonPanel.add(consultationAddButton);
        consultationButtonPanel.add(consultationEditButton);
        consultationButtonPanel.add(consultationDeleteButton);
    }

    protected JPanel makeTextPanel() {
        JPanel panel = new JPanel(false);
        panel.setLayout(new GridLayout(0, 2));
        return panel;
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
