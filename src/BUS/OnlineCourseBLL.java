/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.OnlineCourseDAL;
import DTO.OnlineCourse;
import java.util.ArrayList;


public class OnlineCourseBLL {
    private OnlineCourseDAL ocDAL = new OnlineCourseDAL();
    
    public ArrayList<OnlineCourse> getAllOnlineCourse(){
        return ocDAL.getAllOnlineCourse();
    }
    
    public ArrayList<Integer> getAllCourseID(){
        return ocDAL.getAllCourseID();
    }
    
    public boolean addOnlineCourse(OnlineCourse oc){
        return ocDAL.addOnlineCourse(oc);
    }
    
    public boolean deleteOnlineCourse(int courseID){
        return ocDAL.deleteOnlineCourse(courseID);
    }
    
    public boolean checkCourseID(int courseID){
        return ocDAL.checkCourseID(courseID);
    }
    
    public boolean updateOnlineCourse(OnlineCourse oc){
        return ocDAL.updateOnlineCourse(oc);
    }
    
    public ArrayList<OnlineCourse> searchOnlineCourse(String column, String data){
        return ocDAL.searchOnlineCourse(column, data);
    }
}
