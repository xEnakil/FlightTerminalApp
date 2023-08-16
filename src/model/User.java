package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    int id;
    String username;
    String password;
    ArrayList<Flight> savedFlights;
    ArrayList<Flight> boughtFlights;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Flight> getSavedFlights() {
        return savedFlights;
    }

    public ArrayList<Flight> getBoughtFlights() {
        return boughtFlights;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getCardId() {
        return CardId;
    }

    //    Several more info
    String name;
    String surname;
    String fatherName;
    long phoneNumber;
    long cardNumber;
    int CardId;


    public User(int id, String username, String password, ArrayList<Flight> savedFlights, ArrayList<Flight> boughtFlights) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.savedFlights = savedFlights;
        this.boughtFlights = boughtFlights;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
