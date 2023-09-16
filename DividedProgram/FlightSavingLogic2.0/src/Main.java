import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Flight> flightsList = new ArrayList<>();

        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1. Add Flights\n2. Show Flights\n3. Exit");
            System.out.println("-------------------------------");
            System.out.print("Your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding new flights>");
                    addFlights(flightsList, input);
                    break;
                case 2:
                    System.out.println("Processing the result>");
                    showFlights(flightsList);
                    break;
                case 3:
                    System.out.println("Thanks for using our software. Leaving the system....");
                    System.exit(0);
                default:
                    System.out.println("No such choice");
            }
        }
    }

    public static void addFlights(List<Flight> flightsList, Scanner input) {
        System.out.print("ID: ");
        int id = input.nextInt();
        System.out.print("Destination From: ");
        String destFrom = input.next();
        System.out.print("Destination To: ");
        String destTo = input.next();
        System.out.print("Seat Count: ");
        int seatCount = input.nextInt();

        Flight newFlight = new Flight(id, destTo, destFrom, seatCount);

        flightsList.add(newFlight);

        saveFlightsToFile(flightsList);
    }

    public static void showFlights (List<Flight> flightsList) {
        List<Flight> storedFlights = readFligthsFromFile();
        for (Flight flight : storedFlights) {
            System.out.println("Id: " + flight.id + "\nDestination From: " + flight.destinationFrom + "\nDestination To: " + flight.destinationTo + "\nSeat Count: " + flight.seatCount);
            System.out.println("-------------------------------");
        }
    }

    public static List<Flight> readFligthsFromFile () {
        List<Flight> flightsList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("flights");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object flight;


        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return flightsList;
    }

    public static void saveFlightsToFile (List<Flight> flightsList) {
        try {
            FileOutputStream fos = new FileOutputStream("flights", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Flight flight : flightsList) {
                oos.writeObject(flight);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
