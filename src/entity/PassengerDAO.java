/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author desai
 */
public class PassengerDAO implements DAO<Passenger> {
    public PassengerDAO() {
        
    }
    List<Passenger> passengers;

    /**
     * Get a single passenger entity as a Passenger object
     * @param id
     * @return 
     */
    @Override
    public Optional<Passenger> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Passenger WHERE PassengerID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Passenger passenger = null;
            while (rs.next()) {
                passenger = new Passenger(
                    rs.getInt("PassengerID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getInt("CheckInLocationID"),
                    rs.getTimestamp("CheckInDateTime").toLocalDateTime()
                );
            }
            return Optional.ofNullable(passenger);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return Optional.empty();
        }
    }
    
    /**
     * Get all passenger entities as a List
     * @return 
     */
    @Override
    public List<Passenger> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        passengers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Passenger";
            rs = db.executeQuery(sql);
            Passenger passenger = null;
            while (rs.next()) {
                passenger = new Passenger(
                    rs.getInt("PassengerID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getInt("CheckInLocationID"),
                    rs.getTimestamp("CheckInDateTime").toLocalDateTime()
                );
                passengers.add(passenger);
            }
            return passengers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a passenger object into the passenger table
     * @param passenger 
     */
    @Override
    public void insert(Passenger passenger) {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Passenger(PassengerID, FirstName, LastName, CheckInLocationID, CheckInDateTime) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, passenger.getPassengerID());
            stmt.setString(2, passenger.getFirstName());
            stmt.setString(3, passenger.getLastName());
            stmt.setInt(4, passenger.getCheckInLocationID());
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(passenger.getCheckInDateTime()));
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new passenger was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a passenger entity in the database if it exists using a passenger object
     * @param passenger
     */
    @Override
    public void update(Passenger passenger) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Passenger SET FirstName=?, LastName=?, CheckInLocationID=?, CheckInDateTime=? WHERE PassengerID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, passenger.getFirstName());
            stmt.setString(2, passenger.getLastName());
            stmt.setInt(3, passenger.getCheckInLocationID());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(passenger.getCheckInDateTime()));
            stmt.setInt(5, passenger.getPassengerID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing passenger was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a passenger from the passenger table if the entity exists
     * @param passenger 
     */
    @Override
    public void delete(Passenger passenger) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Passenger WHERE PassengerID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, passenger.getPassengerID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A passenger was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Passenger WHERE PassengerID = -1"; // We just need this SQL query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            // Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i)); // Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } 
    }
}
