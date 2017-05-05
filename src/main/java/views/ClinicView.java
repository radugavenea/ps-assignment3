package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by radu on 05.05.2017.
 */
public class ClinicView extends JFrame{

    private JFrame frame = new JFrame("Clinic Application");

    private JButton adminButton = new JButton("Admin");
    private JButton doctorButton = new JButton("Doctor");
    private JButton secretaryButton = new JButton("Secretary");

    private JPanel panel = new JPanel();

    public ClinicView() throws HeadlessException {
        initializeFrame();
    }


    public void addButtonsListener(ActionListener listener){
        adminButton.addActionListener(listener);
        adminButton.setActionCommand("admin");
        doctorButton.addActionListener(listener);
        doctorButton.setActionCommand("doctor");
        secretaryButton.addActionListener(listener);
        secretaryButton.setActionCommand("secretary");
    }



    private void initializeFrame(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width-frame.getWidth())/2, (dim.height-frame.getHeight())/2);
        frame.setResizable(false);

        setUpPanel();
        frame.add(panel);

        frame.setVisible(true);
    }


    private void setUpPanel(){
        panel.add(adminButton);
        panel.add(doctorButton);
        panel.add(secretaryButton);
    }
}
