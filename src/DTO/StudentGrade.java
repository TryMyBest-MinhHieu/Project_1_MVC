package DTO;

import java.math.BigDecimal;

/**
 *
 * @author MinhHieu
 */
public class StudentGrade {

    private int enrollmentID;
    private int courseID;
    private int studentID;
    private double grade;
    private String firstName;
    private String lastName;
    private String title;

    public StudentGrade() {
    }

    public StudentGrade(int enrollmentID, int courseID, int studentID, double grade) {
        this.enrollmentID = enrollmentID;
        this.courseID = courseID;
        this.studentID = studentID;
        this.grade = grade;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
