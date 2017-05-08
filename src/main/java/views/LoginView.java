package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by radu on 08.05.2017.
 */
public class LoginView extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JTextField usernameTextField = new JTextField(30);
    private JPasswordField passwordTextField = new JPasswordField(30);
    private JLabel usernameLabel = new JLabel("Name");
    private JLabel passwordLabel = new JLabel("Role");
    private JButton loginBtn = new JButton("Login");
    private JLabel tryAgainMessage = new JLabel("Please try again!");

    public LoginView() throws HeadlessException {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400,200));
        frame.setLocationRelativeTo(null);
        frame.setTitle("Login");
        frame.setResizable(false);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel.add(usernameLabel);
        panel.add(usernameTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        panel.add(loginBtn);
        tryAgainMessage.setVisible(false);
        panel.add(tryAgainMessage);

        frame.add(panel);
        frame.setVisible(true);
    }


    /**
     * getters for the credentials
     * @return
     */
    public String getUsername(){
        return usernameTextField.getText();
    }
    public String getRole(){
        return passwordTextField.getText();
    }

    /**
     * Displays error message in case of wrong credentials. It also clears out the input fields.
     */
    public void errorMessage(){
        tryAgainMessage.setVisible(true);
        usernameTextField.setText("");
        passwordTextField.setText("");
    }
    /**
     * Resets the error message so it no longer be displayed
     */
    public void resetErrorMessage(){
        tryAgainMessage.setVisible(false);
    }

    /**
     * Adds listener to the login button
     * @param loginListener
     */
    public void addLoginListener(ActionListener loginListener){
        loginBtn.addActionListener(loginListener);
    }

    public void displayErrorMessage() {
        JOptionPane.showMessageDialog(frame,"Login failed");
    }
}
