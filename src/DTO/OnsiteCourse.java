package DTO;
import java.util.Date;

/**
 *
 * @author MinhHieu
 */
public class OnsiteCourse {

    private int courseID;
    private String location;
    private String days;
    private Date time;
    
        public OnsiteCourse() {
    }

    public OnsiteCourse(int courseID, String location, String days, Date time) {
        this.courseID = courseID;
        this.location = location;
        this.days = days;
        this.time = time;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
