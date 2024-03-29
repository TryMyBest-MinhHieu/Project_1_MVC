package DTO;
import java.util.Date;
/**
 *
 * @author MinhHieu
 */
public class Person {
    private int personID;
    private String lastname;
    private String firstname;
    private Date hireDate;
    private Date enrollmentDate;
    
    public Person(int PersonID, String Lastname, String Firstname, Date HireDate, Date EnrollmentDate) {
        this.personID = PersonID;
        this.lastname = Lastname;
        this.firstname = Firstname;
        this.hireDate = HireDate;
        this.enrollmentDate = EnrollmentDate;
    }
    
    public Person(){}

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int PersonID) {
        this.personID = PersonID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String Lastname) {
        this.lastname = Lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String Firstname) {
        this.firstname = Firstname;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date HireDate) {
        this.hireDate = HireDate;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date EnrollmentDate) {
        this.enrollmentDate = EnrollmentDate;
    }  

    @Override
    public String toString() {
        return this.getFirstname()+ " " + this.getLastname();
    }
    
    
}
