package DAL;

import DTO.Course;
import DTO.CourseInfo;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CourseDAL extends ConnectData{
    
    //Lấy danh sách
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "SELECT c.CourseID, c.Title, c.Credits, c.DepartmentID, o.Url, os.Location, os.Days, os.Time "
                        + "FROM Course c "
                        + "LEFT JOIN OnlineCourse o ON c.CourseID = o.CourseID "
                        + "LEFT JOIN OnsiteCourse os ON c.CourseID = os.CourseID";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    int courseID = rs.getInt("CourseID");
                    String title = rs.getString("Title");
                    int credits = rs.getInt("Credits");
                    int departmentID = rs.getInt("DepartmentID");
                    String url = rs.getString("Url");
                    String location = rs.getString("Location");
                    String days = rs.getString("Days");
                    String time = rs.getString("Time");
                    if (url != null) {
                        courses.add(new OnlineCourse(courseID, title, credits, departmentID, url));
                    } else if (location != null) {
                        courses.add(new OnsiteCourse(courseID, title, credits, departmentID, location, days, time));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return courses;
    }
    
    //Thêm {
    public boolean addCourse(Course course){
        try {
            if (course instanceof OnlineCourse && ((OnlineCourse) course).getUrl() != null) {
                return addOnlineCourse((OnlineCourse) course);
            } else if (course instanceof OnsiteCourse && ((OnsiteCourse) course).getLocation() != null) {
                return addOnsiteCourse((OnsiteCourse) course);
            } else {
                return addBasicCourse(course);
            }
        }  catch (Exception  ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean addBasicCourse(Course course){
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "INSERT INTO Course (CourseID, Title, Credits, DepartmentID) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, course.getCourseID());
                stmt.setString(2, course.getTitle());
                stmt.setInt(3, course.getCredits());
                stmt.setInt(4, course.getDepartmentID());
                if (stmt.executeUpdate() >= 1) {
                    check = true;
                } 
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return check;
    }
    
    public boolean addOnlineCourse(OnlineCourse onlineCourse){
        if (!addBasicCourse(onlineCourse)) {
            return false;
        }
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "INSERT INTO OnlineCourse (CourseID, Url) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, onlineCourse.getCourseID());
                stmt.setString(2, onlineCourse.getUrl());
                if(stmt.executeUpdate() >= 1){
                    check =true;
                }
            } catch (Exception e) {
            }
        }
        return  true;
    }
    
    public boolean addOnsiteCourse(OnsiteCourse onsiteCourse) {
        if (!addBasicCourse(onsiteCourse)) {
            return false;
        }
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "INSERT INTO OnsiteCourse (CourseID, Location, Days, Time) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, onsiteCourse.getCourseID());
                stmt.setString(2, onsiteCourse.getLocation());
                stmt.setString(3, onsiteCourse.getDays());
                stmt.setString(4, onsiteCourse.getTime());

                if (stmt.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception e) {
            }
        }
        return true;
    }
    
    // Lấy tên department
    public ArrayList<String> getNameDepartment(){
        ArrayList<String> nameList = new ArrayList<String>();
        if(OpenConnection()){
            try {
                String sql = "SELECT Name FROM department";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    nameList.add(rs.getString("Name"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nameList;
    }
    
    //Lấy DepartmentID by Name
    public int getIDByName(String name){
        int id = -1;
        if(OpenConnection()){
            String sql = "SELECT DepartmentID FROM department WHERE Name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)){ 
                stmt.setString(1, name);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    id = rs.getInt("DepartmentID");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
    
    
    
}
