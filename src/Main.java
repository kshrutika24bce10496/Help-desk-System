import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();

        System.out.println("=== HELP DESK SYSTEM ===");
        System.out.println("1. Register");
        System.out.println("2. Login");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        // 🔹 REGISTER
        if (choice == 1) {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            User user = new User(name, email, password);
            userDAO.register(user);
        }

        // 🔹 LOGIN
        else if (choice == 2) {

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            boolean success = userDAO.login(email, password);

            if (success) {
                System.out.println("Login Successful ✅");

                TicketDAO ticketDAO = new TicketDAO();

                System.out.println("\n1. Create Ticket");
                System.out.println("2. View My Tickets");

                System.out.print("Enter choice: ");
                int option = sc.nextInt();
                sc.nextLine();

                // 🔹 CREATE TICKET
                if (option == 1) {

                    CategoryDAO categoryDAO = new CategoryDAO();
                    ArrayList<Category> categories = categoryDAO.getAllCategories();

                    System.out.println("Select Issue Type:");

                    for (Category c : categories) {
                        System.out.println(c.id + ". " + c.name);
                    }

                    System.out.print("Enter choice: ");
                    int issueChoice = sc.nextInt();
                    sc.nextLine();

                    String title = "";

                    for (Category c : categories) {
                        if (c.id == issueChoice) {
                            title = c.name;
                            break;
                        }
                    }

                    if (title.equals("")) {
                        System.out.println("Invalid choice");
                        return;
                    }

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    Ticket ticket = new Ticket(email, title, desc, "Open");
                    ticketDAO.createTicket(ticket);
                }

                // 🔹 VIEW TICKETS
                else if (option == 2) {
                    ticketDAO.viewTickets(email);
                }

            } else {
                System.out.println("Invalid Credentials ❌");
            }
        }
    }
}