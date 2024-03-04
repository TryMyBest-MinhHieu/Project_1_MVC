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
    private int courseID;
    private int credits;
    private int personID;
    private String fullname;

    public CourseInstructorInfo(){}
    
    public CourseInstructorInfo(String title, int courseID, int credits, int personID, String fullname) {
        this.title = title;
        this.courseID = courseID;
        this.credits = credits;
        this.personID = personID;
        this.fullname = fullname;
    }

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


}