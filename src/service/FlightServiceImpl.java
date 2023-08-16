package service;

import model.Flight;

import java.util.ArrayList;

public interface FlightServiceImpl {
    void loadFlightsFromLife(ArrayList<Flight> flights);
    void saveFlightToFile(ArrayList<Flight> flights);
}
