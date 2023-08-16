package model;

public class Flight {
    int id;
    String destinationFrom;
    String destinationTo;
    int seatCount;

    public Flight(int id, String destinationFrom, String destinationTo, int seatCount) {
        this.id = id;
        this.destinationFrom = destinationFrom;
        this.destinationTo = destinationTo;
        this.seatCount = seatCount;
    }


}
