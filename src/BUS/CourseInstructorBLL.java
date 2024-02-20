/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.CourseInstructorDAL;
import DTO.CourseInstructor;
import java.util.ArrayList;


public class CourseInstructorBLL {
    private CourseInstructorDAL ciDAL = new CourseInstructorDAL();
    
    public ArrayList<CourseInstructor> getAllCourseInstructor(){
        return ciDAL.getAllCourseInstructor();
    }
    
    public boolean checkCourseInstructorID(int courseID, int personID){
        return ciDAL.checkCourseInstructorID(courseID, personID);
    }
    
    public ArrayList<Integer> getAllCourseID(){
        return ciDAL.getAllCourseID();
    }
    
    public ArrayList<Integer> getAllPersonID(){
        return ciDAL.getAllPersonID();
    }
    
    public boolean addCourseInstructor(CourseInstructor ci){
        return ciDAL.addCourseInstructor(ci);
    }
    
    public boolean deleteCourseInstructor(int courseID, int personID){
        return ciDAL.deleteCourseInstructor(courseID, personID);
    }
    
    public boolean updateCourseInstructor(CourseInstructor ci){
        return ciDAL.updateCourseInstructor(ci);
    }
    
    public ArrayList<CourseInstructor> searchCourseInstructor(String column, String data){
        return ciDAL.searchCourseInstructor(column, data);
    }
}
