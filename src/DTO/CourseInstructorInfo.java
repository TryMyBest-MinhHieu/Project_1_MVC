/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MinhHieu
 */
public class CourseInstructorInfo {

    private String title;
    private String firstname;
    private String lastname;
    private String fullname;

    // Constructor
    public CourseInstructorInfo(String title, String firstname, String lastname, String fullname) {
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = firstname + lastname;  
    }

    public CourseInstructorInfo() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


}