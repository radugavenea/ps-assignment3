package views;

import entities.UserEntity;
import viewTableUtils.GenericTableModel;
import viewTableUtils.UserTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by radu on 05.05.2017.
 */
public class AdminView extends JFrame {

    private JFrame frame = new JFrame("Administrator View");
    private JPanel buttonPanel = new JPanel();
    private JPanel inputPanel = makeTextPanel();
    private GenericTableModel userTableModel = new UserTableModel();
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    private JSplitPane insideSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,scrollPane, inputPanel);
    private JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,insideSplitPane, buttonPanel);

    private JLabel idLabel = new JLabel("User id");
    private JLabel roleLabel = new JLabel("User role");
    private JLabel nameLabel = new JLabel("User name");
    private JTextField idInput = new JTextField(30);
    private JTextField roleInput = new JTextField(30);
    private JTextField nameInput = new JTextField(30);

    private JButton readButton = new JButton("Read");
    private JButton addButton = new JButton("Add");
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");


    public AdminView() throws HeadlessException {
        initializeFrame();
    }


    private void initializeFrame(){

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(800,600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width-frame.getWidth())/2, (dim.height-frame.getHeight())/2);
        frame.setResizable(false);

        setUpPane();
        frame.add(splitPane);

        frame.setVisible(true);
    }


    public String getIdInput(){
        return idInput.getText();
    }
    public String getRoleInput(){
        return roleInput.getText();
    }
    public String getNameInput(){
        return nameInput.getText();
    }


    public void addButtonsListener(ActionListener listener){
        readButton.addActionListener(listener);
        addButton.addActionListener(listener);
        editButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        readButton.setActionCommand("read");
        addButton.setActionCommand("add");
        editButton.setActionCommand("edit");
        deleteButton.setActionCommand("delete");
    }

    public void addTableSelectionListener(ListSelectionListener listSelectionListener){
        table.getSelectionModel().addListSelectionListener(listSelectionListener);
    }



    public void updateUserTable(List<UserEntity> users){
        userTableModel.setDataVector(users);
//        userTableModel.fireTableDataChanged();
    }

    public void updateViewInputs(List<String> userFields){
        idInput.setText(userFields.get(0));
        roleInput.setText(userFields.get(1));
        nameInput.setText(userFields.get(2));
    }

    public String getSelectedRowUserId(){
        int row = table.getSelectedRow();
        return row > -1 ? table.getValueAt(row,0).toString() : null;
    }

    private void setUpPane(){
        table.setModel(userTableModel);
        insideSplitPane.setDividerLocation(400);
        idInput.setEditable(false);
        inputPanel.add(idLabel);
        inputPanel.add(idInput);
        inputPanel.add(roleLabel);
        inputPanel.add(roleInput);
        inputPanel.add(nameLabel);
        inputPanel.add(nameInput);
        buttonPanel.add(readButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
    }


    protected JPanel makeTextPanel() {
        JPanel panel = new JPanel(false);
        panel.setLayout(new GridLayout(0, 2));
        return panel;
    }
}
