/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author desai
 */
public class TSAEmployee extends Employee{
    private String securityLevel;
    private String shiftHours;
    public String getShiftHours() {
        return shiftHours;
    }public void setShiftHours(String shiftHours) {
        this.shiftHours = shiftHours;
    }public String getSecurityLevel() {
        return securityLevel;
    }public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }
    //methods
    public void inspectLuggage() {
        // inspect luggage for banned items
    }public void scanPassenger() {
        // scan passengers for security checks
    }
    @Override
    public void clockIn() {
//        clock in for work method
    }
    @Override
    public void clockOut() {
//        clock out from work method
    }
    @Override
    public void showID() {
//        show your id method
    }
    @Override
    public void checkIn() {
//       tsa worker check-in process
    }}
