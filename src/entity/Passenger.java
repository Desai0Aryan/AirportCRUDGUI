/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author desai
 */
import java.time.LocalDateTime;

public class Passenger {
    private int passengerID;
    private String firstName;
    private String lastName;
    private int checkInLocationID;
    private LocalDateTime checkInDateTime;

    public Passenger(int passengerID, String firstName, String lastName, int checkInLocationID, LocalDateTime checkInDateTime) {
        this.passengerID = passengerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkInLocationID = checkInLocationID;
        this.checkInDateTime = checkInDateTime;
    }

    // Getters and Setters
    public int getPassengerID() {
        return passengerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCheckInLocationID() {
        return checkInLocationID;
    }

    public LocalDateTime getCheckInDateTime() {
        return checkInDateTime;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerID=" + passengerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", checkInLocationID=" + checkInLocationID +
                ", checkInDateTime=" + checkInDateTime +
                '}';
    }
}
