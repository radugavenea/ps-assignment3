package mainApp;

import controllers.LoginController;
import views.LoginView;

/**
 * Created by radu on 05.05.2017.
 */
public class Launcher {

    public static void main(String[] args) {

        new LoginController(new LoginView());
    }
}
