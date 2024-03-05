package DTO;
/**
 *
 * @author MinhHieu
 */
public class OnlineCourse extends Course{
    
    public OnlineCourse(int courseID, String title, int credits, int departmentID, String url) {
        super(courseID, title, credits, departmentID);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    //private int courseID;
    private String url;
    
    

//    public OnlineCourse(int CourseID, String url) {
//        this.courseID = CourseID;
//        this.url = url;
//    }
//
    public OnlineCourse() {
    }
//
//    public int getCourseID() {
//        return courseID;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//    public void setCourseID(int CourseID) {
//        this.courseID = CourseID;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }

}
