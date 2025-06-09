/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author desai
 */
public abstract class Person {
    protected String name;
    protected int age;
    public int getAge(){
        return age;
}
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return name; 
    }
    public void setName(String n){
        this.name = n;
    }
    public abstract void checkIn();
    public abstract void showID();
}
