import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void register(User user) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.name);
            ps.setString(2, user.email);
            ps.setString(3, user.password);

            ps.executeUpdate();

            System.out.println("User Registered Successfully ✅");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}