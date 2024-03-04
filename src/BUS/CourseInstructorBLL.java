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

    public CourseInstructorBLL() {
        ciDAL = new CourseInstructorDAL();
    }

    public CourseInstructorDAL getCiDAL() {
        return ciDAL;
    }


    public ArrayList<CourseInstructor> getAllCourseInstructor() {
        return getCiDAL().getAllCourseInstructor();
    }

    public boolean checkCourseInstructorID(int courseID, int personID) {
        return getCiDAL().checkCourseInstructorID(courseID, personID);
    }

    public boolean addCourseInstructor(CourseInstructor ci) {
        return getCiDAL().addCourseInstructor(ci);
    }

    public boolean deleteCourseInstructor(CourseInstructor ci) {
        return getCiDAL().deleteCourseInstructor(ci);
    }

    public boolean updateCourseInstructor(CourseInstructor ci) {
        return getCiDAL().updateCourseInstructor(ci);
    }


}
