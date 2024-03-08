/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.Course;
import DAL.CourseInstructorDAL;
import DTO.CourseInstructor;
import DTO.Instructor;
import java.util.ArrayList;
import java.util.Optional;

public class CourseInstructorBLL {

    private CourseInstructorDAL ciDAL;
    private ArrayList<Instructor> instructorsCache;
    private ArrayList<Course> coursesCache;

    public CourseInstructorBLL() {
        ciDAL = new CourseInstructorDAL();
        instructorsCache = new ArrayList<>();
        coursesCache = new ArrayList<>();
    }

    public CourseInstructorDAL getCiDAL() {
        return ciDAL;
    }

    public ArrayList<Instructor> getInstructorsCache() {
        return instructorsCache;
    }

    public void setInstructorsCache(ArrayList<Instructor> instructorsCache) {
        this.instructorsCache = instructorsCache;
    }

    public ArrayList<Course> getCoursesCache() {
        return coursesCache;
    }

    public void setCoursesCache(ArrayList<Course> coursesCache) {
        this.coursesCache = coursesCache;
    }

    public ArrayList<CourseInstructor> getAllCourseInstructor() {
        return getCiDAL().getAllCourseInstructor();
    }

    public ArrayList<Instructor> getAllInstructor() {
        instructorsCache.clear();
        instructorsCache = ciDAL.getAllInstructor();

        return instructorsCache;

    }

    public ArrayList<Course> getAllCourse() {
        coursesCache = ciDAL.GetAllCourse();

        return coursesCache;
    }

    public Course getCourseCacheById(int id) {
        Optional<Course> courseOpt = coursesCache.stream()
                .filter(course -> course.getCourseID() == id)
                .findFirst();

        return courseOpt.get();
    }

    public Instructor getInstructorCacheById(int id) {
        Optional<Instructor> instructorOpt = instructorsCache.stream()
                .filter(i -> i.getInstructorID() == id)
                .findFirst();

        return instructorOpt.get();
    }

    public boolean deleteCourseInstructor(int courseID, int personID) {
        return getCiDAL().deleteCourseInstructor(courseID, personID);
    }

    public boolean updateCourseInstructor(int courseID, ArrayList<Integer> instructorIDs) {
        if (!instructorIDs.isEmpty()) {
            return getCiDAL().updateCourseInstructor(courseID, instructorIDs);
        } else {
            return getCiDAL().deleteAllCourseInstructor(courseID);
        }
    }

    public ArrayList<Integer> getInstructorsForCourse(int courseID) {
        ArrayList<Integer> instructorIDs = ciDAL.getInstructorsForCourse(courseID);

        return instructorIDs;
    }
    
    
    public ArrayList<CourseInstructor> searchCourseInstructor(String query) {
        return ciDAL.searchCourseInstructor(query.trim());
    }
}
