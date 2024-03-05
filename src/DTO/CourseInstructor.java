package DTO;

/**
 *
 * @author MinhHieu
 */
public class CourseInstructor {
    private Person person;
    private Course course;
    private String departmentName;

   
    
    public CourseInstructor() {
        person = new Person();
        course = new Course();
    }

    public CourseInstructor(Person person, Course course) {
        this.person = person;
        this.course = course;
    }
    
     public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    
}
