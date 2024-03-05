package DTO;

/**
 *
 * @author MinhHieu
 */
public class Course {

    private int courseID;
    private String title;
    private int credits;
    private int departmentID;
    
    public Course(int courseID, String title, int credits, int departmentID) {
        this.courseID = courseID;
        this.title = title;
        this.credits = credits;
        this.departmentID = departmentID;
    }

    public Course() {
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
    
}

