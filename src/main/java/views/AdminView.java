package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by radu on 05.05.2017.
 */
public class AdminView extends JFrame {

    private JFrame frame = new JFrame("Administrator View");

    public AdminView() throws HeadlessException {
        initializeFrame();
    }


    private void initializeFrame(){

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(400,200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width-frame.getWidth())/2, (dim.height-frame.getHeight())/2);
        frame.setResizable(false);


        frame.setVisible(true);
    }
}
