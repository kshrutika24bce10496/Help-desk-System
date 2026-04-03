import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();


        System.out.println("=== HELP DESK SYSTEM ===");
        System.out.println("Press '1' to Register");
        System.out.println("Press '2' to Login");
        System.out.println("Press '3' for Admin panel");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        // 🔹 USER REGISTERATION FOR AUTHENTICATION
        if (choice == 1) {

            System.out.print("Please enter your Name here: ");
            String name = sc.nextLine();

            System.out.print("Please enter your Email: ");
            String email = sc.nextLine();

            System.out.print("Enter a strong Password: ");
            String password = sc.nextLine();

            User user = new User(name, email, password);
            userDAO.register(user);
        }

        // 🔹USER LOGIN
        else if (choice == 2) {

            System.out.print("Enter your registered Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            boolean success = userDAO.login(email, password);

            if (success) {
                System.out.println("Login was Successful ");
                TicketDAO ticketDAO = new TicketDAO();


                System.out.println("\n1. Create a new Ticket");
                System.out.println("2. View ALL the Tickets");

                System.out.print("Enter a choice: ");
                int option = sc.nextInt();
                sc.nextLine();

                // 🔹 CREATE TICKET
                if (option == 1) {

                    CategoryDAO categoryDAO = new CategoryDAO();
                    ArrayList<Category> categories = categoryDAO.getAllCategories();

                    System.out.println("Please select Issue Type:");

                    for (Category c : categories) {
                        System.out.println(c.id + ". " + c.name);
                    }

                    System.out.print("Enter a choice: ");
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
                        System.out.println("Entered choice is INVALID!");
                        return;
                    }

                    System.out.print("Enter Description of the Issue: ");
                    String desc = sc.nextLine();
                    System.out.println("Select Priority:");
                    System.out.println("1. High Priority");
                    System.out.println("2. Medium Priority");
                    System.out.println("3. Low Priority");

                    int pChoice = sc.nextInt();
                    sc.nextLine();

                    String priority = "";

                    if (pChoice == 1) priority = "High Priority";
                    else if (pChoice == 2) priority = "Medium Priority";
                    else if (pChoice == 3) priority = "Low Priority";
                    else {
                        System.out.println("Selected choice is Invalid, Please select one from the provided choices.");
                        return;
                    }

                    Ticket ticket = new Ticket(email, title, desc, "Open", priority);
                    ticketDAO.createTicket(ticket);
                }

                // 🔹 VIEW TICKETS
                else if (option == 2) {
                    ticketDAO.viewTickets(email);
                }
                else if (choice == 3) {

                    TicketDAO ticketDAO1 = new TicketDAO();

                    System.out.println("\n=== ADMIN PANEL ===");

                    ticketDAO1.viewAllTickets();

                    System.out.print("Enter Ticket ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Select Status:");
                    System.out.println("1. Open");
                    System.out.println("2. In Progress");
                    System.out.println("3. Resolved");

                    int statusChoice = sc.nextInt();
                    sc.nextLine();

                    String status = "";

                    if (statusChoice == 1) status = "Open";
                    else if (statusChoice == 2) status = "In Progress";
                    else if (statusChoice == 3) status = "Resolved";
                    else {
                        System.out.println("Invalid choice");
                        return;
                    }

                    ticketDAO1.updateStatus(id, status);
                }

            } else {
                System.out.println("Invalid Credentials ❌");
            }
        }
    }
}