# Help-desk-System
## Description
This project is a Helpdesk Issue Tracking System developed using Java, JDBC, MySQL, and Swing GUI. It allows users to register, log in, create and manage support tickets, and track their issue status. The system also includes an admin panel to update ticket statuses.

The application provides a complete workflow for handling user issues efficiently in an organized manner.
## Features

### User Features
- User Registration
- User Login Authentication
- Create Support Tickets
- Select Issue Category
- Assign Priority (High / Medium / Low)
- View Submitted Tickets and Status
### Admin Features
- View All Tickets
- Update Ticket Status
### System Features
- Dynamic Categories (stored in database)
- Priority-based ticket handling
- Database integration using JDBC
- GUI interface using Java Swing
## Technologies Used
- Java (Core Java, OOP Concepts)
- JDBC (Java Database Connectivity)
- MySQL (Database)
- Swing (GUI Development)
- Git & GitHub (Version Control)
## Project Structure
HelpdeskSystem

-src
- Main.java
- DBConnection.java
- User.java
- UserDAO.java
- Ticket.java
- TicketDAO.java
- Category.java
- CategoryDAO.java
- LoginUI.java
- DashboardUI.java

-README.md

-.gitignore 

## How to Run the Project
1. Clone the repository
2. Open the project in Intellij IDEA
3. Add MySQL Connector
4. Update database credential in: DBConnection.java
5. Run LoginUI.java
   
## Application Flow
1.User registeration

2.User logs in

3.Dashboard opens

4.User can:

- Create Ticket
- View Ticket

5. Admin can update ticket status

## Learning Outcomes
- Understanding of JDBC and database connectivity
- Application of OOP concepts in Java
- Building GUI applications using Swing
- Managing projects using Git and GitHub
- Designing a real-world issue tracking system
## Conclusion
This project demonstrates how a helpdesk system can be built using Java and MySQL to efficiently manage user issues. It provides a structured approach to ticket handling and improves user support management
## Future Enhancement
- Email notifications
- Search and filter tickets
- Role-based authentication
- Web-based version (Spring Boot)
- Improved UI design
