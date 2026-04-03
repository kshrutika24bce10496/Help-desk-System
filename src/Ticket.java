public class Ticket {
    String userEmail;
    String title;
    String description;
    String status;
    String priority;

    public Ticket(String userEmail, String title, String description, String status, String priority) {
        this.userEmail = userEmail;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;

    }
}