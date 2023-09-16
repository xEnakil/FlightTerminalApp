import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1. Add Flights\n2. Show Flights\n3. Exit");
            System.out.println("-------------------------------");
            System.out.print("Your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding new flights>");
                    addFlightsToFile(input);
                    break;
                case 2:
                    System.out.println("Processing the result>");
                    ArrayList<Flight> listFlight = readFlightFromFile();
                    showFlights(listFlight);
                    break;
                case 3:
                    System.out.println("Thanks for using our software. Leaving the system....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("No such choice");
            }
        }
    }

    public static void addFlightsToFile (Scanner input) {
        ArrayList<String> flightDetails = new ArrayList<>();
        System.out.print("Enter the id:");
        String id = input.next();
        System.out.print("Enter destination from: ");
        String destinationFrom = input.next();
        System.out.print("Enter destination to: ");
        String destinationTo = input.next();
        System.out.print("Enter seat count: ");
        String seatCount = input.next();

        flightDetails.add(id);
        flightDetails.add(destinationFrom);
        flightDetails.add(destinationTo);
        flightDetails.add(seatCount);

        String joinedWords = String.join(",", flightDetails);

        try {
            FileWriter writer = new FileWriter("flights.txt", true);
            writer.write(joinedWords);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Flight detail successfully added.");
    }

    public static ArrayList<Flight> readFlightFromFile () {
        ArrayList<Flight> flightList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("flights.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String destFrom = parts[1];
                String destTo = parts[2];
                int seatCount = Integer.parseInt(parts[3]);

                Flight newFlight = new Flight(id,destFrom,destTo,seatCount);

                flightList.add(newFlight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public static void showFlights (ArrayList<Flight> flightList) {
        for (Flight flight : flightList) {
            System.out.println("Id: " + flight.id + "\nDestination From: " + flight.destinationFrom + "\nDestination To: " + flight.destinationTo + "\nSeat Count: " + flight.seatCount);
            System.out.println("-------------------------------");
        }
    }
}
