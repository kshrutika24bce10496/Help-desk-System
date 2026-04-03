import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TicketDAO {

    public void createTicket(Ticket ticket) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("Priority selected: " + ticket.priority);
            String query = "INSERT INTO tickets (user_email, title, description, status,priority) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, ticket.userEmail);
            ps.setString(2, ticket.title);
            ps.setString(3, ticket.description);
            ps.setString(4, ticket.status);
            ps.setString(5, ticket.priority);

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
                System.out.println("Priority: " + rs.getString("priority"));
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateStatus(int ticketId, String status) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE tickets SET status=? WHERE ticket_id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, ticketId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Status Updated Successfully ✅");
            } else {
                System.out.println("Ticket not found ❌");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void viewAllTickets() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM tickets";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n=== ALL TICKETS ===");

            while (rs.next()) {
                System.out.println("Ticket ID: " + rs.getInt("ticket_id"));
                System.out.println("User: " + rs.getString("user_email"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Priority: " + rs.getString("priority"));
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}