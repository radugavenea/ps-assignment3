package mainApp;

import controllers.ClinicController;
import views.ClinicView;

/**
 * Created by radu on 05.05.2017.
 */
public class Launcher {

    public static void main(String[] args) {

        new ClinicController(new ClinicView());
    }
}
