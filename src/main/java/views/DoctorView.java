package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by radu on 05.05.2017.
 */
public class DoctorView extends JFrame {

    private JFrame frame = new JFrame("Doctor View");

    public DoctorView() throws HeadlessException {
        initializeFrame();
    }

    private void initializeFrame(){

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(300,200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width-frame.getWidth())/2, (dim.height-frame.getHeight())/2);
        frame.setResizable(false);


        frame.setVisible(true);
    }
}
