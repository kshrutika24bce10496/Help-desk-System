import javax.swing.*;
import java.awt.event.*;

public class LoginUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Helpdesk Login");
        frame.setLocationRelativeTo(null); // center screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 30);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 50, 150, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 30);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 30);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 150, 100, 30);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(220, 150, 100, 30);

        JLabel result = new JLabel("");
        result.setBounds(100, 200, 200, 30);

        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginBtn);
        frame.add(registerBtn);
        frame.add(result);


        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        // 🔹 Button Action
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String email = emailField.getText();
                String password = new String(passField.getPassword());

                UserDAO userDAO = new UserDAO();

                if (userDAO.login(email, password)) {
                    result.setText("Login Successful ✅");
                    // Open dashboard
                    new DashboardUI(email);

                    // Close login window
                    frame.dispose();
                } else {
                    result.setText("Invalid Credentials ");
                }
            }
        });
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = JOptionPane.showInputDialog("Enter Name:");
                String email = JOptionPane.showInputDialog("Enter Email:");
                String password = JOptionPane.showInputDialog("Enter Password:");

                User user = new User(name, email, password);
                UserDAO userDAO = new UserDAO();

                userDAO.register(user);

                JOptionPane.showMessageDialog(frame, "User Registered Successfully ✅");
            }
        });
    }
}