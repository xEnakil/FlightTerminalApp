import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        while (true) {

            //writing code from https://stackoverflow.com/questions/1377279/find-a-line-in-a-file-and-remove-it
            //adding a method that checks if temp file exist and if exist it will rename it to the older version name;

            System.out.println("-------------------------------");
            System.out.println("1. Add Flights\n2. Show Flights\n3. Delete Flight.\n4. Exit");
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
                case 4:
                    System.out.println("Thanks for using our software. Leaving the system....");
                    System.exit(0);
                    break;
                case 3:
                    removeFlight(input);
                default:
                    System.out.println("No such choice");
            }
        }
    }

    public static void addFlightsToFile (Scanner input) {
        ArrayList<String> flightDetails = new ArrayList<>();
        System.out.print("Enter the id: ");
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

    public static void removeFlight (Scanner input) throws IOException {
        String fileName = "flights.txt";
        String lineToRemove = input.next();

        try {
            File inputFile = new File(fileName);
            File tempFile = new File("tempFile.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains(lineToRemove)) {
                    continue;
                }
                bw.write(currentLine);
                bw.newLine();
            }

            bw.close();
            br.close();

            if (inputFile.delete()) {
                if (tempFile.renameTo(inputFile)) {
                    System.out.println("Line deleted successfully!");
                } else {
                    System.out.println("Error renaming the temporary file.");
                }
            } else {
                System.out.println("Error deleting the file.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
