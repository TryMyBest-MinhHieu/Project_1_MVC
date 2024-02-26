/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.CourseDAL;
import DAL.OnlineCourseDAL;
import DTO.CourseInfo;
import java.util.ArrayList;

/**
 *
 * @author MinhHieu
 */
public class CourseBLL {
    CourseDAL cDAL = new CourseDAL();
    
    public ArrayList<String> getAllCourseTitle(){
        return cDAL.getAllCourseTitle();
    }
    
    public ArrayList<CourseInfo> getCourseInfo(){
        return cDAL.getAllCourseInfo();
    }
    
    public int getCourseIDByTitle(String title){
        return cDAL.getCourseIDByTitle(title);
    }
    
    public String getTitleByCourseID(int id){
        return cDAL.getTitleByCourseID(id);
    }
}
