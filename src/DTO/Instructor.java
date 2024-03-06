/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.text.SimpleDateFormat;

/**
 *
 * @author syl
 */
public class Instructor {
    
    private Integer instructorID;
    private String location;
    private Person person;

    public Instructor(Integer instructorID, String location, Person person) {
        this.instructorID = instructorID;
        this.location = location;
        this.person = person;
    }
    
     public Instructor(Integer instructorID, String location) {
        this.instructorID = instructorID;
        this.location = location;
        this.person = new Person();
        this.person.setPersonID(instructorID);
    }

    public Instructor() {
        this.person = new Person();
    }

    public Integer getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Integer instructorID) {
        this.instructorID = instructorID;
        this.getPerson().setPersonID(instructorID);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        final String OLD_FORMAT = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        String date= sdf.format(this.person.getHireDate());
        
        return this.instructorID + " - " + this.person.getFirstname() + " " + this.person.getLastname() + " - " + date;
    }
    
    
    
    
}
