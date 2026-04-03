public class Ticket {
    String userEmail;
    String title;
    String description;
    String status;

    public Ticket(String userEmail, String title, String description, String status) {
        this.userEmail = userEmail;
        this.title = title;
        this.description = description;
        this.status = status;
    }
}