package DTO;
/**
 *
 * @author MinhHieu
 */
public class OnlineCourse {
    
    private int courseID;
    private String url;

    public OnlineCourse(int CourseID, String url) {
        this.courseID = CourseID;
        this.url = url;
    }

    public OnlineCourse() {
    }

    public void setCourseID(int CourseID) {
        this.courseID = CourseID;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
