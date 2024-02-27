/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAL.StudentGradeDAL;
import DTO.StudentGrade;
import java.util.ArrayList;


public class StudentGradeBLL {
    private StudentGradeDAL sgDAL = new StudentGradeDAL();
    
    public ArrayList<StudentGrade> getAllStudentGrade(){
        return sgDAL.getAllStudentGrade();
    }
    
    public boolean checkStudentGradeID(int enrollmentID){
        return sgDAL.checkStudentGradeID(enrollmentID);
    }
    
    public ArrayList<Integer> getAllStudentID(){
        return sgDAL.getAllStudentID();
    }
    
    public ArrayList<Integer> getAllCourseID(){
        return sgDAL.getAllCourseID();
    }
    
    public boolean addStudentGrade(StudentGrade sg){
        return sgDAL.addStudentGrade(sg);
    }
    
    public boolean deleteStudentGrade(int enrollmentID){
        return sgDAL.deleteStudentGrade(enrollmentID);
    }
    
    public boolean updateStudentGrade(StudentGrade sg){
        return sgDAL.updateStudentGrade(sg);
    }
    
    public ArrayList<StudentGrade> searchStudentGrade(String data){
        return sgDAL.searchStudentGrade(data);
    }
}
