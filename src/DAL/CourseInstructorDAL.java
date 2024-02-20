/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseInstructor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhHieu
 */
public class CourseInstructorDAL extends ConnectData{
    public boolean checkCourseInstructorID(int courseID, int personID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "select *from CourseInstructor where CourseID = "+courseID+" and PersonID = "+personID;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return check;
    }
    
    public ArrayList<CourseInstructor> getAllCourseInstructor(){
        ArrayList<CourseInstructor> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select * from CourseInstructor";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    CourseInstructor ci = new CourseInstructor(rs.getInt("CourseID"),rs.getInt("PersonID"));
                    list.add(ci);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
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
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        
        return list;
    }
    
    public ArrayList<Integer> getAllPersonID(){
        ArrayList<Integer> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select PersonID from Person where HireDate is not NULL";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    list.add(Integer.valueOf(rs.getInt("PersonID")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        
        return list;
    }
    
    public boolean addCourseInstructor(CourseInstructor ci){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "insert into CourseInstructor values(?,?)";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, ci.getCourseID());
                stm.setInt(2, ci.getPersonID());
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
        }
        
        return check;
    }
    
    public boolean deleteCourseInstructor(int courseID, int personID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "delete from CourseInstructor where CourseID = ? and PersonID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1,courseID);
                stm.setInt(2, personID);
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
            
        }
        
        return check;
    }
    
    public boolean updateCourseInstructor(CourseInstructor ci){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "update CourseInstructor set CourseID = ?, PersonID = ? where CourseID = ? or PersonID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, ci.getCourseID());
                stm.setInt(2, ci.getPersonID());
                stm.setInt(3, ci.getCourseID());
                stm.setInt(4, ci.getPersonID());
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
        }
        
        return check;
    }
    
    public ArrayList<CourseInstructor> searchCourseInstructor(String column, String data){
        ArrayList<CourseInstructor> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select *from CourseInstructor where "+column+"= "+data;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                
                while(rs.next()){
                    CourseInstructor ci = new CourseInstructor(rs.getInt("CourseID"),rs.getInt("PersonID"));
                    list.add(ci);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        return list;
    }
}
