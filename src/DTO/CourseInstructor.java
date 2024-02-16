package DTO;

/**
 *
 * @author MinhHieu
 */
public class CourseInstructor {

    private int courseID;
    private int personID;
    
        public CourseInstructor() {
    }

    public CourseInstructor(int courseID, int personID) {
        this.courseID = courseID;
        this.personID = personID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }
}
