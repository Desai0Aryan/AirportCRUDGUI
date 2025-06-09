/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author desai
 */

public class CheckinLocation {
    private int checkInLocationID;
    private String stationName;

    public CheckinLocation(int checkInLocationID, String stationName) {
        this.checkInLocationID = checkInLocationID;
        this.stationName = stationName;
    }

    // Getters and Setters
    public int getCheckInLocationID() {
        return checkInLocationID;
    }

    public String getStationName() {
        return stationName;
    }

    @Override
    public String toString() {
        return "CheckinLocation{" +
                "checkInLocationID=" + checkInLocationID +
                ", stationName='" + stationName + '\'' +
                '}';
    }

    public Object getLocationId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

