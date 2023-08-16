package service;

import model.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightService implements FlightServiceImpl{

    @Override
    public void loadFlightsFromLife(ArrayList<Flight> flights) {
        try {
            FileInputStream fileIn = new FileInputStream("flights.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            flights = (ArrayList<Flight>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveFlightToFile(ArrayList<Flight> flights) {
        try {
            FileOutputStream fileOut = new FileOutputStream("flights.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(flights);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("File not found. Creating a new one");
            flights = new ArrayList<>();
            saveFlightToFile(flights);
        }
    }

    public void addFlight (Scanner input, ArrayList<Flight> flights) {
        System.out.print("Enter destination from: ");
        String destinationFrom = input.nextLine();
        System.out.print("Enter destination to: ");
        String destinationTo = input.nextLine();
        System.out.print("Enter seat count: ");
        int seatCount = input.nextInt();
        int newId = flights.size() + 1;
        Flight newFlight = new Flight(newId, destinationFrom, destinationTo, seatCount);
        flights.add(newFlight);
        System.out.println("Flight added successfully.");
    }
}
