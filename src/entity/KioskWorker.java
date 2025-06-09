/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author desai
 */
public class KioskWorker extends Employee {
private String shiftHours;
    public String getShiftHours() {
        return shiftHours;
    }
    public void setShiftHours(String shiftHours) {
        this.shiftHours = shiftHours;
    }
    public void printBoardingPass() {
//        print borading pass for passenger
    } 
    @Override
    public void clockIn() {
        // clock in for work method
    }
    @Override
    public void clockOut() {
        // clock out for work method
    }
    @Override
    public void checkIn() {
        // check in at Kiosk 
    }
    @Override 
    public void showID(){
//        show your id method
    }
}
