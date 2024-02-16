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
    private BigDecimal grade;
    
    public StudentGrade(int EnrollmentID, int CourseID, int StudentID, BigDecimal Grade) {
        this.enrollmentID = EnrollmentID;
        this.courseID = CourseID;
        this.studentID = StudentID;
        this.grade = Grade;
    }
    
    public StudentGrade() {
    }
    
        public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.enrollmentID = EnrollmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int CourseID) {
        this.courseID = CourseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int StudentID) {
        this.studentID = StudentID;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal Grade) {
        this.grade = Grade;
    }
    
    
}
