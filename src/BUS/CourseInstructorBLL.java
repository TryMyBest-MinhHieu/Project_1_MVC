/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.Course;
import DTO.Person;
import DAL.CourseInstructorDAL;
import DAL.PersonDAL;
import DTO.CourseInstructor;
import DTO.CourseInstructorInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CourseInstructorBLL {

    private CourseInstructorDAL ciDAL;
    private PersonDAL perDAL;
    private ArrayList<Course> coursesCache;
    private ArrayList<Person> personsCache;
    private Map<Course, Person> coursePersonMapCache;

    public CourseInstructorBLL() {
        perDAL = new PersonDAL();
        ciDAL = new CourseInstructorDAL();
        coursesCache = new ArrayList<>();
        personsCache = new ArrayList<>();
        coursePersonMapCache = new HashMap<>();
        loadCache();
    }

    private void loadCache() {
        personsCache = perDAL.GetAllListPerson();
        coursesCache = ciDAL.GetAllListCourse();
    }

    public Course getCourseById(int id) {
        Optional<Course> courseOpt = coursesCache.stream()
                .filter(course -> course.getCourseID() == id)
                .findFirst();

        if (courseOpt.isPresent()) {
            return courseOpt.get();
            
        }
        return null;
    }
    
    public Person getPersonById(int id) {
        Optional<Person> personOpt = personsCache.stream()
                .filter(Person -> Person.getPersionID() == id)
                .findFirst();

        if (personOpt.isPresent()) {
            return personOpt.get();
        }
        return null;
    }

    public CourseInstructorDAL getCiDAL() {
        return ciDAL;
    }

    public ArrayList<Course> getCoursesCache() {
        return coursesCache;
    }

    public ArrayList<Person> getPersonsCache() {
        return personsCache;
    }

    public Map<Course, Person> getCoursePersonMapCache() {
        return coursePersonMapCache;
    }

    public ArrayList<CourseInstructorInfo> getAllCourseInstructorInfo() {
        return getCiDAL().getAllCourseInstructorInfo();
    }

    public boolean checkCourseInstructorID(int courseID, int personID) {
        return getCiDAL().checkCourseInstructorID(courseID, personID);
    }

    public boolean addCourseInstructor(CourseInstructor ci) {
        return getCiDAL().addCourseInstructor(ci);
    }

    public boolean deleteCourseInstructor(int courseID, int personID) {
        return getCiDAL().deleteCourseInstructor(courseID, personID);
    }

    public boolean updateCourseInstructor(CourseInstructor ci) {
        return getCiDAL().updateCourseInstructor(ci);
    }

    public ArrayList<CourseInstructor> searchCourseInstructor(String column, String data) {
        return getCiDAL().searchCourseInstructor(column, data);
    }

    public ArrayList<CourseInstructorInfo> getCIInfo(CourseInstructor ci) {
        return getCiDAL().getCIInfo(ci);
    }

}
