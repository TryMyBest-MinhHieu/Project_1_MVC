/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Course;
import DTO.CourseInstructor;
import DTO.CourseInstructorInfo;
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
    
    public ArrayList<CourseInstructorInfo> getAllCourseInstructorInfo(){
        ArrayList<CourseInstructorInfo> list = new ArrayList<>();
        
        if(OpenConnection()){
            try {
                String sql = "SELECT c.Title, "
                        + "CONCAT(p.Firstname, ' ', p.Lastname) AS Fullname,"
                        + "c.Credits,"
                        + "ci.CourseID,"
                        + "ci.PersonID "
                        + "FROM courseinstructor ci "
                        + "JOIN course c ON ci.CourseID = c.CourseID "
                        + "JOIN person p ON ci.PersonID = p.PersonID ";
                
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    CourseInstructorInfo ci = new CourseInstructorInfo(
                            rs.getString("Title"),
                            rs.getInt("CourseID"),
                            rs.getInt("Credits"),
                            rs.getInt("PersonID"),
                            rs.getString("Fullname"));
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
    
    
    public ArrayList<CourseInstructorInfo> getCIInfo(CourseInstructor c) {
        ArrayList<CourseInstructorInfo> ciiList = new ArrayList<>();

        if (OpenConnection()) {
            try {
                String sql = "SELECT c.Title, CONCAT(p.Firstname, ' ', p.Lastname) AS Fullname "
                        + "FROM courseinstructor ci JOIN course c ON ci.CourseID = c.CourseID "
                        + "JOIN person p ON ci.PersonID = p.PersonID "
                        + "WHERE ci.courseid = ? AND ci.personid = ?";

                // Sử dụng PreparedStatement để tránh SQL Injection
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, c.getCourseID());
                preparedStatement.setInt(2, c.getPersonID());

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    CourseInstructorInfo cii = new CourseInstructorInfo();
                    cii.setTitle(rs.getString("Title"));
                    cii.setFullname(rs.getString("Fullname"));
                    ciiList.add(cii);
                }
                rs.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Xử lý lỗi theo nhu cầu của bạn
            } finally {
                CloseConnection();
            }
        }

        return ciiList;
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
    
    public ArrayList<Course> GetAllListCourse(){
        ArrayList<Course> courseList = new ArrayList<Course>();
        String sql = "SELECT * FROM course";
        if (OpenConnection()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Course cs = new Course();
                    cs.setCourseID(rs.getInt("CourseID"));
                    cs.setTitle(rs.getString("Title"));
                    cs.setCredits(rs.getInt("Credits"));
                    cs.setDepartmentID(rs.getInt("DepartmentID"));
                    courseList.add(cs);
                }
            } catch (SQLException ex) {
                System.out.println("khong tim thay danh sach" + ex);
            } finally {
                CloseConnection();
            }
        } else {
            System.out.println("Kết nối không thành công.");
        }        
        return courseList;        
    }
}
