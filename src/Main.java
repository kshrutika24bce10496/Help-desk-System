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

        if (choice == 1) {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            User user = new User(name, email, password);
            userDAO.register(user);

        } else if (choice == 2) {

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            boolean success = userDAO.login(email, password);

            if (success) {
                System.out.println("Login Successful ✅");
            } else {
                System.out.println("Invalid Credentials ❌");
            }
        }
    }
}