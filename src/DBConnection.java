import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/helpdesk",
                    "root",
                    "FunSQLpass"
            );
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}