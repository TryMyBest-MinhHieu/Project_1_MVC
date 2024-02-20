/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.OnlineCourse;
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
public class OnlineCourseDAL extends ConnectData{
    public ArrayList<OnlineCourse> getAllOnlineCourse(){
        ArrayList<OnlineCourse> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select * from OnlineCourse";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    OnlineCourse oc = new OnlineCourse();
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setUrl(rs.getString("Url"));
                    list.add(oc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                //closeConnection();
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
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                //closeConnection();
            }
        }
        
        
        return list;
    }
    
    public boolean checkCourseID(int courseID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "select * from OnlineCourse where CourseID = "+courseID;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
                
            }
        }
        
        return check;
    }
    
    public boolean addOnlineCourse(OnlineCourse oc){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "insert into OnlineCourse values(?,?)";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, oc.getCourseID());
                stm.setString(2, oc.getUrl());
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                //closeConnection();
            }
        }
        
        return check;
    }
    
    public boolean deleteOnlineCourse(int courseID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "Delete from OnlineCourse where CourseID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, courseID);
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        return check;
    }
    
    public boolean updateOnlineCourse(OnlineCourse oc){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "Update OnlineCourse set OcUrl = ? where CourseID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(2, oc.getCourseID());
                stm.setString(1, oc.getUrl());
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
            
        }
        
        return check;
    }
    
    public ArrayList<OnlineCourse> searchOnlineCourse(String column, String data){
        ArrayList<OnlineCourse> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select * from OnlineCourse where "+column+"= "+data;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    OnlineCourse oc = new OnlineCourse();
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setUrl(rs.getString("Url"));
                    list.add(oc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
                
            }
        }
        
        return list;
    }
}
