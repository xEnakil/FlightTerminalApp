import java.io.Serializable;

public class Flight implements Serializable {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinationTo() {
        return destinationTo;
    }

    public void setDestinationTo(String destinationTo) {
        this.destinationTo = destinationTo;
    }

    public String getDestinationFrom() {
        return destinationFrom;
    }

    public void setDestinationFrom(String destinationFrom) {
        this.destinationFrom = destinationFrom;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", destinationTo='" + destinationTo + '\'' +
                ", destinationFrom='" + destinationFrom + '\'' +
                ", seatCount=" + seatCount +
                '}';
    }

    public Flight() {
        super();
    }
}
