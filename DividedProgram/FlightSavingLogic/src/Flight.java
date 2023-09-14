public class Flight {
    int id;
    String destinationTo;
    String destinationFrom;
    int seatCount;

    public Flight(int id, String destinationTo, String destinationFrom, int seatCount) {
        this.id = id;
        this.destinationTo = destinationTo;
        this.destinationFrom = destinationFrom;
        this.seatCount = seatCount;
    }
}
