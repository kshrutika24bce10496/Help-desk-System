import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TicketDAO {

    public void createTicket(Ticket ticket) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO tickets (user_email, title, description, status) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, ticket.userEmail);
            ps.setString(2, ticket.title);
            ps.setString(3, ticket.description);
            ps.setString(4, ticket.status);

            ps.executeUpdate();

            System.out.println("Ticket Created Successfully 🎫");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void viewTickets(String email) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM tickets WHERE user_email=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n=== YOUR TICKETS ===");

            while (rs.next()) {
                System.out.println("Ticket ID: " + rs.getInt("ticket_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}