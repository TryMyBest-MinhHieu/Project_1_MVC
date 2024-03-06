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
    
    // Check courseID
    public boolean checkCourseID(int courseID){
        boolean check = false;
        if(OpenConnection()){
            try {
                String sql = "SELECT * FROM course WHERE CourseID =" + courseID;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    check = true;                
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CloseConnection();
            }
        }
        return check;
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
    
    // Sửa
    public boolean updateCourse(Course course){
        try {
            if (course instanceof OnlineCourse && ((OnlineCourse) course).getUrl() != null) {
                return updateOnlineCourse((OnlineCourse) course);
            } else if (course instanceof OnsiteCourse && ((OnsiteCourse) course).getLocation() != null) {
                return updateOnsiteCourse((OnsiteCourse) course);
            } else {
                return updateBasicCourse(course);
            }
        }  catch (Exception  ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateBasicCourse(Course course){
        boolean check = false;
        if(OpenConnection()){
            String sql = "UPDATE course SET Title = ?, Credits = ?, DepartmentID = ? WHERE CourseID = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, course.getTitle());
                stmt.setInt(2, course.getCredits());
                stmt.setInt(3, course.getDepartmentID());
                stmt.setInt(4, course.getCourseID());
                if (stmt.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception e) {
            }
        }
        return check;
    }
    
    public boolean updateOnlineCourse(OnlineCourse onlineCourse){
        updateBasicCourse(onlineCourse);
        boolean check = false;
        if(OpenConnection()){
            String sql = "UPDATE OnlineCourse SET Url = ? WHERE CourseID = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, onlineCourse.getUrl());
                stmt.setInt(2, onlineCourse.getCourseID());
                if (stmt.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception e) {
            }
        }
        return check;
    }
    
        public boolean updateOnsiteCourse(OnsiteCourse onsiteCourse){
        updateBasicCourse(onsiteCourse);
        boolean check = false;
        if(OpenConnection()){
            String sql = "UPDATE OnsiteCourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, onsiteCourse.getLocation());
                stmt.setString(2, onsiteCourse.getDays());
                stmt.setString(3, onsiteCourse.getTime());
                stmt.setInt(4, onsiteCourse.getCourseID());
                if (stmt.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception e) {
            }
        }
        return check;
    }
        
    // Xóa
    public Course getCourseByID(int id) {
        if (OpenConnection()) {
            String sql = "SELECT * FROM Course WHERE CourseID = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);                
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();                
                if(rs.next()) {
                    int retrievedCourseID = rs.getInt("courseID");
                    String title = rs.getString("title");
                    int credits = rs.getInt("credits");
                    int departmentID = rs.getInt("departmentID");   
                    return new Course(retrievedCourseID, title, credits, departmentID);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex + "getCourseByID lỗi");
            }
        }
        return null;
    }
         
    public boolean deleteCourse(int courseID) {
        try {
            Course course = getCourseByID(courseID);

            if (course instanceof OnlineCourse) {
                return deleteOnlineCourse(courseID);
            } else if (course instanceof OnsiteCourse) {
                return deleteOnsiteCourse(courseID);
            } else {
                return deleteBasicCourse(courseID);
            }
        } catch (Exception ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex +"deleteCourse lỗi");
            return false;
        }
    }
            
    public boolean deleteBasicCourse(int courseID) {
        boolean check = false;
        if (OpenConnection()) {
            String sql = "DELETE FROM Course where CourseID = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, courseID);
                if (stmt.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception e) {
            }
        }
        return check;
    }
                
    public boolean deleteOnlineCourse(int courseID){
        deleteBasicCourse(courseID);
        boolean check = false;
        if(OpenConnection()){
            String sql = "DELETE FROM OnlineCourse where CourseID = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, courseID);
                if (stmt.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (Exception e) {
            }
        }
        return check;
    }
    
    public boolean deleteOnsiteCourse(int courseID) {
        deleteBasicCourse(courseID);
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "DELETE FROM OnsiteCourse where CourseID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, courseID);
                if (stm.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnsiteCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }

        }

        return check;
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
    
    public String getNameByID(int id){
        String name = null;
        if(OpenConnection()){
            try {
                String sql = "SELECT Name FROM department WHERE DepartmentID = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, id);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        name = rs.getString("Name");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return name;
    }
        
}
