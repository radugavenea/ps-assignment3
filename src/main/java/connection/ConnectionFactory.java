package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by radu on 03.05.2017.
 */
public class ConnectionFactory {

    private static final String username = "root";
    private static final String password = "root";

    public static Connection getConnection(String url) throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

}
