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
public class CheckinLocationDAO implements DAO<CheckinLocation> {   
    public CheckinLocationDAO() {
        
    }
    List<CheckinLocation> checkinLocations;

    /**
     * Get a single check-in location entity as a CheckinLocation object
     * @param id
     * @return 
     */
    @Override
    public Optional<CheckinLocation> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM CheckinLocation WHERE CheckinLocationID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            CheckinLocation checkinLocation = null;
            while (rs.next()) {
                checkinLocation = new CheckinLocation(rs.getInt("CheckinLocationID"), rs.getString("StationName"));
            }
            return Optional.ofNullable(checkinLocation);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all check-in location entities as a List
     * @return 
     */
    @Override
    public List<CheckinLocation> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        checkinLocations = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CheckinLocation";
            rs = db.executeQuery(sql);
            CheckinLocation checkinLocation = null;
            while (rs.next()) {
                checkinLocation = new CheckinLocation(rs.getInt("CheckinLocationID"), rs.getString("StationName"));
                checkinLocations.add(checkinLocation);
            }
            return checkinLocations;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a check-in location object into the check-in location table
     * @param checkinLocation 
     */
    @Override
    public void insert(CheckinLocation checkinLocation) {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO CheckinLocation(CheckinLocationID, StationName) VALUES (?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, checkinLocation.getCheckInLocationID());
            stmt.setString(2, checkinLocation.getStationName());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new check-in location was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a check-in location entity in the database if it exists using a check-in location object
     * @param checkinLocation
     */
    @Override
    public void update(CheckinLocation checkinLocation) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE CheckinLocation SET StationName=? WHERE CheckinLocationID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, checkinLocation.getStationName());
            stmt.setInt(2, checkinLocation.getCheckInLocationID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing check-in location was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a check-in location from the check-in location table if the entity exists
     * @param checkinLocation 
     */
    @Override
    public void delete(CheckinLocation checkinLocation) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM CheckinLocation WHERE CheckinLocationID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, checkinLocation.getCheckInLocationID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A check-in location was deleted successfully!");
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
            String sql = "SELECT * FROM CheckinLocation WHERE CheckinLocationID = -1"; // We just need this SQL query to get the column headers
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

    public List<CheckinLocation> getAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
