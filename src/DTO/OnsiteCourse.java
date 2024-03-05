package DTO;
import java.util.Date;

/**
 *
 * @author MinhHieu
 */
public class OnsiteCourse extends Course{

    public OnsiteCourse(int courseID, String title, int credits, int departmentID, String location, String days, String time) {
        super(courseID, title, credits, departmentID);
        this.location = location;
        this.days = days;
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    //private int courseID;
    private String location;
    private String days;
    private String time;
    
    public OnsiteCourse() {
    }

//    public OnsiteCourse(int courseID, String location, String days, String time) {
//        this.courseID = courseID;
//        this.location = location;
//        this.days = days;
//        this.time = time;
//    }

//    public int getCourseID() {
//        return courseID;
//    }
//
//    public void setCourseID(int courseID) {
//        this.courseID = courseID;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getDay() {
//        return days;
//    }
//
//    public void setDay(String days) {
//        this.days = days;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
}
