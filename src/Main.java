import model.Flight;
import model.User;
import service.FlightService;
import service.UserService;


import java.util.ArrayList;
import java.util.Scanner;

import static service.UserService.adminMenu;
import static service.UserService.mainMenu;

public class Main {
    static ArrayList<User> users = new ArrayList<>();
    static User currentUser = null;
    static User admin = new User(0, "admin", "admin");
    static User user = new User(1, "Elmin", "windows8");
    static ArrayList<Flight> flights = new ArrayList<>();

    public static void main(String[] args) {
        users.add(admin);
        users.add(user);
        FlightService service = new FlightService();
        service.loadFlightsFromLife(flights);
        Scanner input = new Scanner(System.in);
        UserService serviceUser = new UserService();

        while (true) {
            System.out.println("1. Register\n2. Log in\n3. Exit.");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    serviceUser.registerUser(input,users);
                    break;
                case 2:
                    serviceUser.loginUser(input, users, currentUser);
                    if (currentUser != null) {
                        if (currentUser == admin) {
                            adminMenu(input,service,currentUser,flights);
                        } else {
                            mainMenu(input,service,flights,currentUser);
                        }
                    }
                    break;
                case 3:
                    service.saveFlightToFile(flights);
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("No such choice....");
            }
        }
    }
}
