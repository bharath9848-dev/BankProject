import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection connect() {

        try {

            String url = "jdbc:mysql://localhost:3306/bankdb";
            String username = "root";
            String password = "Bharath@2805"; // change if needed

            Connection conn = DriverManager.getConnection(url, username, password);

            return conn;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}