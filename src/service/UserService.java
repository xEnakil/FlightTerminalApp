package service;

import model.Flight;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;


public class UserService implements UserServiceImpl{

    @Override
    public void registerUser(Scanner input, ArrayList<User> users) {
        System.out.print("Enter a username: ");
        String username = input.next();
        System.out.print("Enter a password: ");
        String password = input.next();
        int newId = users.size() + 1;
        User newUser = new User(newId, username, password);
        users.add(newUser);
        System.out.println("Registration successful. You can now log in.");
    }

    @Override
    public void loginUser(Scanner input, ArrayList<User> users, User currentUser) {
        System.out.print("Enter username: ");
        String username = input.next();
        System.out.print("Enter password: ");
        String password = input.next();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful. Welcome " + currentUser.getUsername() + "!");
                return;
            }
        }
        System.out.println("Invalid username or password. Please try again!");
    }

    public static void adminMenu (Scanner input, FlightService service, User currentUser, ArrayList<Flight> flights) {
        while (true) {
            System.out.print("Admin Menu:\n1. Add flight\n2. Log of\nEnter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    service.addFlight(input,flights);
                    break;
                case 2:
                    service.saveFlightToFile(flights);
                    System.out.println("Logging off....");
                    currentUser = null;
                    break;
                default:
                    System.out.println("No such Choice..");
            }
        }
    }

    public static void mainMenu (Scanner input, FlightService service, ArrayList<Flight> flights, User currentUser) {
        while (true) {
            System.out.println("1. Search for flights\n2. Buy ticket\n3. My wishlist flights\n4. Look for flights by date/time or destination\n5. Log off");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    service.saveFlightToFile(flights);
                    currentUser = null;
                    return;
                default:
                    System.out.println("No such choice....");
            }
        }
    }
}
