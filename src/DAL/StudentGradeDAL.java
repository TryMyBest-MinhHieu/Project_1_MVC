/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.StudentGrade;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// Thêm, sửa, xóa
public class StudentGradeDAL extends ConnectData{
//    ConnectData cd = new ConnectData();
//    Connection conn = cd.GetConnection();
    
    public ArrayList<StudentGrade> getAllStudentGrade(){
        ArrayList<StudentGrade> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select *from StudentGrade";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    StudentGrade sg = new StudentGrade();
                    sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    sg.setCourseID(rs.getInt("CourseID"));
                    sg.setStudentID(rs.getInt("StudentID"));
                    sg.setGrade(rs.getDouble("Grade"));
                    list.add(sg);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        return list;
    }
    
    public boolean checkStudentGradeID(int enrollmentID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "select * from StudentGrade where EnrollmentID = "+enrollmentID;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
            
        }
        
        return check;
    }
    
    public ArrayList<Integer> getAllStudentID(){
        ArrayList<Integer> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select PersonID from Person where PersonID is not NULL";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    list.add(Integer.valueOf(rs.getInt("PersonID")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
        }
        
        return list;
    }
    
    public ArrayList<Integer> getAllCourseID(){
        ArrayList<Integer> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select CourseID from Course";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    list.add(Integer.valueOf(rs.getInt("CourseID")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        return list;
    }
    
    public boolean addStudentGrade(StudentGrade sg){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "insert into StudentGrade values(?,?,?)";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, sg.getCourseID());
                stm.setInt(2, sg.getStudentID());
                stm.setDouble(3, sg.getGrade());
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
            
        }
        return check;
    }
    
    public boolean deleteStudentGrade(int enrollmentID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "delete from StudentGrade where EnrollmentID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, enrollmentID);
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
            
        }
        
        return check;
    }
    
    public boolean updateStudentGrade(StudentGrade sg){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "update StudentGrade set CourseID = ?, PersonID = ?, Grade = ? where EnrollmentID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, sg.getCourseID());
                stm.setInt(2, sg.getStudentID());
                stm.setDouble(3, sg.getGrade());
                stm.setInt(4, sg.getEnrollmentID());
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
        }
        
        return check;
    }
    
    public ArrayList<StudentGrade> searchStudentGrade(String column, String data){
        ArrayList<StudentGrade> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select * from StudentGrade where "+column+" = "+data;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    StudentGrade sg = new StudentGrade();
                    sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    sg.setCourseID(rs.getInt("CourseID"));
                    sg.setStudentID(rs.getInt("StudentID"));
                    sg.setGrade(rs.getDouble("Grade"));
                    list.add(sg);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
        }
        
        return list;
    }
}
