/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.OnsiteCourse;
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
public class OnsiteCourseDAL extends ConnectData{
    public ArrayList<OnsiteCourse> getAllOnsiteCourse(){
        ArrayList<OnsiteCourse> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select * from OnsiteCourse";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    OnsiteCourse oc = new OnsiteCourse();
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setLocation(rs.getString("Location"));
                    oc.setDay(rs.getString("Days"));
                    oc.setTime(rs.getString("Time"));
                    list.add(oc);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OnsiteCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        return list;
    }
    
    public boolean checkOnsiteCourseID(int courseID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "select *from OnsiteCourse where CourseID = "+courseID;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    check = true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OnsiteCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        return check;
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
                Logger.getLogger(OnsiteCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        
        return list;
    }
    
    public boolean addOnsiteCourse(OnsiteCourse oc){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "insert into OnsiteCourse values(?,?,?,?)";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, oc.getCourseID());
                stm.setString(2, oc.getLocation());
                stm.setString(3, oc.getDay());
                stm.setString(4, oc.getTime());
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnsiteCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        return check;
    }
    
    public boolean deleteOnsiteCourse(int courseID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "delete from OnsiteCourse where CourseID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, courseID);
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnsiteCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
            
        }
        
        return check;
    }
    
    public boolean updateOnsiteCourse(OnsiteCourse oc){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "update OnsiteCourse set Location = ?, Days = ?, Time= ? where CourseID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, oc.getLocation());
                stm.setString(2, oc.getDay());
                stm.setString(3, oc.getTime());
                stm.setInt(4, oc.getCourseID());
                if(stm.executeUpdate()>=1){
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnsiteCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
            
        }
        
        return check;
    }
    
    public ArrayList<OnsiteCourse> searchOnsiteCourse(String column, String data){
        ArrayList<OnsiteCourse> list = new ArrayList<>();
        if(OpenConnection()){
            try {
                String sql = "select * from OnsiteCourse where "+column+" = "+data;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    OnsiteCourse oc = new OnsiteCourse();
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setLocation(rs.getString("Location"));
                    oc.setDay(rs.getString("Days"));
                    oc.setTime(rs.getString("Time"));
                    list.add(oc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnsiteCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                CloseConnection();
            }
        }
        
        return list;
    }
}
