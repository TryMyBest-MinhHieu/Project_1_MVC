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
    
    public boolean checkCourseID(int courseID){
        return cDAL.checkCourseID(courseID);
    }
    
    //Thêm
    public boolean addCourse(Course course) {
        return cDAL.addCourse(course);
    }
    
    // Sửa
    public boolean updateCourse(Course course){
        return cDAL.updateCourse(course);
    }
    
    //Xóa 
    public boolean deleteCourse(int courseID){
        return cDAL.deleteCourse(courseID);
    }
    
    // Lấy tên department
    public ArrayList<String> getNameDepartment(){
        return  cDAL.getNameDepartment();
    }
    
    //Lấy DepartmentID by Name
    public int getIDByName(String name){
        return cDAL.getIDByName(name);
    }
    
    //Lấy Name by DeparmentID
    public String getNameByID(int id){
        return cDAL.getNameByID(id);
    }

}
