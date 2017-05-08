package views;

import entities.ConsultationEntity;
import viewTableUtils.ConsultationTableModel;
import viewTableUtils.GenericTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by radu on 05.05.2017.
 */
public class DoctorView extends JFrame {

    private JFrame frame = new JFrame();

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

    private JLabel patientNameLabel = new JLabel("Patient name: ");
    private JTextField patientIdInput = new JTextField(20);
    private JButton consultationReadButton = new JButton("Read");
    private JButton consultationAddButton = new JButton("Add");

    public DoctorView(String username) throws HeadlessException {
        initializeFrame(username);
    }

    private void initializeFrame(String username) {

        frame.setTitle("Doctor View for doctor username " + username);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width - frame.getWidth()) / 2, (dim.height - frame.getHeight()) / 2);
        frame.setResizable(false);

        setUpDoctorPane();
        frame.add(consultationSplitPane);

        frame.setVisible(true);
    }


    public String getPatientIdInput(){ return patientIdInput.getText(); }
    public String getConsultationIdInput(){ return consultationIdInput.getText(); }
    public String getConsultationStartsAtInput(){ return consultationStartsAtTimeInput.getText(); }
    public String getConsultationEndsAtInput(){ return consultationEndsAtTimeInput.getText(); }
    public String getConsultationDoctorsNameInput(){ return consultationDoctorsNameInput.getText(); }
    public String getConsultationUserIdInput(){ return consultationUserIdInput.getText(); }
    public String getConsultationPatientIdInput(){ return consultationPatientIdInput.getText(); }


    public void addButtonsListener(ActionListener listener){
        consultationReadButton.addActionListener(listener);
        consultationAddButton.addActionListener(listener);
        consultationReadButton.setActionCommand("read");
        consultationAddButton.setActionCommand("add");
    }

    public void addConsultationTableListener(ListSelectionListener listSelectionListener){
        consultationTable.getSelectionModel().addListSelectionListener(listSelectionListener);
    }

    public String getSelectedPatientId(){
        int row = consultationTable.getSelectedRow();
        return row > -1 ? consultationTable.getValueAt(row, 5).toString() : null;
    }

    public String getSelectedConsultationId() {
        int row = consultationTable.getSelectedRow();
        return row > -1 ? consultationTable.getValueAt(row, 0).toString() : null;
    }

    public void updateConsultationTable(List<ConsultationEntity> consultations) {
        if(consultations != null)
        consultationTableModel.setDataVector(consultations);
    }

    public void updateInputFields(List<String> consultationFields) {
        consultationIdInput.setText(consultationFields.get(0));
        consultationStartsAtTimeInput.setText(consultationFields.get(1));
        consultationEndsAtTimeInput.setText(consultationFields.get(2));
        consultationDoctorsNameInput.setText(consultationFields.get(3));
        consultationUserIdInput.setText(consultationFields.get(4));
        consultationPatientIdInput.setText(consultationFields.get(5));
    }

    public void displayDoctorNotAvailableMessage() {
        JOptionPane.showMessageDialog(frame, "Doctor not available for this period of time.");
    }

    public void displayNewConsultationMessage(String doctorName) {
        JOptionPane.showMessageDialog(frame,"A new consultation has been made for doctor: " + doctorName);
    }

    private void setUpDoctorPane() {
        consultationTable.setModel(consultationTableModel);
        consultationInsideSplitPane.setDividerLocation(300);
        consultationSplitPane.setDividerLocation(480);
        consultationIdInput.setEditable(false);
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
        consultationButtonPanel.add(patientNameLabel);
        consultationButtonPanel.add(patientIdInput);
        consultationButtonPanel.add(consultationReadButton);
        consultationButtonPanel.add(consultationAddButton);
    }


    protected JPanel makeTextPanel() {
        JPanel panel = new JPanel(false);
        panel.setLayout(new GridLayout(0, 2));
        return panel;
    }

}