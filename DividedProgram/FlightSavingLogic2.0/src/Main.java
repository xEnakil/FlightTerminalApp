import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Flight> flightsList = new ArrayList<>();

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

    public static void addFlights(ArrayList<Flight> flightsList, Scanner input) {
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

        saveFligthsToFile(flightsList);
    }

    public static void showFlights (ArrayList<Flight> flightsList) {
        ArrayList<Flight> storedFlights = readFligthsFromFile();
        for (Flight flight : storedFlights) {
            System.out.println("Id: " + flight.id + "\nDestination From: " + flight.destinationFrom + "\nDestination To: " + flight.destinationTo + "\nSeat Count: " + flight.seatCount);
            System.out.println("-------------------------------");
        }
    }

    public static ArrayList<Flight> readFligthsFromFile () {
        try {
            FileInputStream fis = new FileInputStream("flights.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<Flight>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            return new ArrayList<>();
        }
    }
    public static void saveFligthsToFile (ArrayList<Flight> flightsList) {
        try {
            FileOutputStream fos = new FileOutputStream("flights.ser", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flightsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
