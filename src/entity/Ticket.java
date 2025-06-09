/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author desai
 */
public class Ticket {
    private int ticketNumber;
    private String flightNumber; 
    private String seatNumber;
    private String classType;

    public int getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public String getFlightNumber() { 
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) { 
        this.flightNumber = flightNumber;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public String getClassType() {
        return classType;
    }
    public void setClassType(String classType) {
        this.classType = classType;
    }
    // methods
    public void cancelTicket() {
        // cancel the ticket
    }
    public void changeSeat() {
        // change the seat for the ticket
    }
}
