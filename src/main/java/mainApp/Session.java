package mainApp;


import java.util.List;

/**
 * Created by radu on 08.04.2017.
 */
public class Session {

    public static List<String> doctorUsers = null;
    public static List<String> secretaryUsers = null;
    public static List<String> adminUsers = null;

    public static String username = null;

    public static void add(String newUser) {
        username = newUser;
    }

    public static void close() {
        username = null;
    }

    public static String getUsername() {
        return username;
    }
}
