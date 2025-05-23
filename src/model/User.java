package model;

import structures.CancellationBookingStack;
import structures.UsersList;
import java.util.Scanner;
import java.util.List;
import java.util.Stack;

public class User
{
    public String name;
    private String email;
    private String ID;
    public CancellationBookingStack cancellationStack;
    public UsersList Users;

    public User(String name, String email, String ID)
    {
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.cancellationStack = new CancellationBookingStack();
    }

    public User()
    {
        this.cancellationStack = new CancellationBookingStack();
    }

    public void setName(String name)
    {
        if (name != null && name.matches("[a-zA-Z ]+"))
        {
            this.name = name;
        } else
        {
            System.out.println("Invalid name. Only letters and spaces are allowed.");
        }
    }

    public String getName()
    {
        return name;
    }

    public void setEmail(String email)
    {
        if (email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$"))
        {
            this.email = email;
        } else
        {
            System.out.println("Invalid email format.");
        }
    }

    public String getEmail()
    {
        return email;
    }

    public void setID(String ID)
    {
        if (ID != null && ID.matches("\\d{9}"))
        {
            this.ID = ID;
        } else
        {
            System.out.println("Invalid ID. please enter a numeric ID, 9 digits only.");
        }
    }

    public String getID()
    {
        return ID;
    }


    public void viewUpcomingBookings()
    {
        // Logic to view upcoming bookings
        System.out.println("Upcoming bookings for user: " + name);
        // Display booking details
    }

    public void viewLastCancellation()
    {
        // Logic to view last cancellation
        System.out.println("Last cancellation for user: " + name);
        // Display cancellation details
    }

    //Method for registering a new user or logging in an existing one
    public static User loginOrRegister(Scanner scanner, UsersList users) {
        System.out.print("Enter your ID (9 digits): ");
        String id = scanner.nextLine();

        UsersList.UserNode current = users.getHead();
        while (current != null) {
            if (current.user.getID().equals(id)) {
                System.out.println("Welcome back, " + current.user.getName() + "!");
                return current.user;
            }
            current = current.next;
        }

        System.out.println("User not found. Please register:");
        User newUser = new User();

        newUser.setID(id);
        while (newUser.getID() == null) {
            System.out.print("Invalid ID. Please re-enter a valid 9-digit ID: ");
            id = scanner.nextLine();
            newUser.setID(id);
        }

        while (true) {
            System.out.print("Enter your full name: ");
            String name = scanner.nextLine();
            newUser.setName(name);
            if (newUser.getName() != null) break;
        }

        while (true) {
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            newUser.setEmail(email);
            if (newUser.getEmail() != null) break;
        }

        users.addUser(newUser);
        System.out.println("Registration successful. Welcome, " + newUser.getName() + "!");
        return newUser;
    }

    public void PrintUserDetails()
    {
        System.out.println("User ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}