/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.CourseDAL;
import DAL.OnlineCourseDAL;
import DTO.Course;
import DTO.CourseInfo;
import java.util.ArrayList;

/**
 *
 * @author MinhHieu
 */
public class CourseBLL {
    CourseDAL cDAL = new CourseDAL();
    
    //Lấy danh sách
    public ArrayList<Course> getAllCourses() {
        return cDAL.getAllCourses();
    } 
    
    //Thêm
    public void addCourse(Course course) {
        cDAL.addCourse(course);
    }
    
    // Lấy tên department
    public ArrayList<String> getNameDepartment(){
        return  cDAL.getNameDepartment();
    }
    
    //Lấy DepartmentID by Name
    public int getIDByName(String name){
        return cDAL.getIDByName(name);
    }

}
