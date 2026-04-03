import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DashboardUI {

    public DashboardUI(String email) {

        JFrame frame = new JFrame("Dashboard");

        JLabel welcome = new JLabel("Welcome: " + email);
        welcome.setBounds(100, 30, 250, 30);

        JButton createBtn = new JButton("Create Ticket");
        createBtn.setBounds(80, 100, 150, 40);

        JButton viewBtn = new JButton("View Tickets");
        viewBtn.setBounds(80, 160, 150, 40);

        frame.add(welcome);
        frame.add(createBtn);
        frame.add(viewBtn);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TicketDAO ticketDAO = new TicketDAO();

        // 🔹 CREATE TICKET BUTTON
        createBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                CategoryDAO categoryDAO = new CategoryDAO();
                ArrayList<Category> categories = categoryDAO.getAllCategories();

                String[] options = new String[categories.size()];
                for (int i = 0; i < categories.size(); i++) {
                    options[i] = categories.get(i).name;
                }

                String title = (String) JOptionPane.showInputDialog(
                        frame,
                        "Select Issue Type:",
                        "Category",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                String desc = JOptionPane.showInputDialog("Enter Description:");

                String[] priorities = {"High", "Medium", "Low"};
                String priority = (String) JOptionPane.showInputDialog(
                        frame,
                        "Select Priority:",
                        "Priority",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        priorities,
                        priorities[0]
                );

                Ticket ticket = new Ticket(email, title, desc, "Open", priority);
                ticketDAO.createTicket(ticket);

                JOptionPane.showMessageDialog(frame, "Ticket Created Successfully 🎫");
            }
        });

        // 🔹 VIEW TICKETS BUTTON
        viewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String result = "";

                    var con = DBConnection.getConnection();
                    var ps = con.prepareStatement("SELECT * FROM tickets WHERE user_email=?");
                    ps.setString(1, email);

                    var rs = ps.executeQuery();

                    while (rs.next()) {
                        result += "ID: " + rs.getInt("ticket_id") + "\n";
                        result += "Title: " + rs.getString("title") + "\n";
                        result += "Status: " + rs.getString("status") + "\n";
                        result += "Priority: " + rs.getString("priority") + "\n";
                        result += "----------------------\n";
                    }

                    JOptionPane.showMessageDialog(frame, result);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
    }
}