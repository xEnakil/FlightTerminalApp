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
                    addFlights(flightsList, input);
                    break;
                case 2:
                    System.out.println("Processing the result.");
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

    public static void showFlights(ArrayList<Flight> flightsList) {
        try (FileInputStream fis = new FileInputStream("flights.ser")) {
            ArrayList<Flight> newFlightList = new ArrayList<>();
            boolean endOfFile = false;

            while (!endOfFile) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ArrayList<Flight> tempList = (ArrayList<Flight>) ois.readObject();
                    newFlightList.addAll(tempList);
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }

            fis.close();
            for (Flight flight : newFlightList) {
                System.out.println("Id: " + flight.id + "\nDestination from: " + flight.destinationFrom + "\nDestination to: " + flight.destinationTo + "\nSeat count: " + flight.seatCount);
                System.out.println("-------------------------------");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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

        Flight newFlight = new Flight(id,destTo,destFrom,seatCount);

        flightsList.add(newFlight);

        try (FileOutputStream fos = new FileOutputStream("flights.ser", true)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flightsList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
