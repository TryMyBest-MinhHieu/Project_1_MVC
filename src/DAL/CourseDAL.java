package DAL;

import DTO.Course;
import DTO.CourseInfo;
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
    
    //int courseID, String title, int credits, int departmentID
//    public ArrayList<Course> GetAllListCourse(){
//        ArrayList<Course> courseList = new ArrayList<Course>();
//        String sql = "SELECT * FROM course";
//        if (OpenConnection()) {
//            try {
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    Course cs = new Course();
//                    cs.setCourseID(rs.getInt("CourseID"));
//                    cs.setTitle(rs.getString("Title"));
//                    cs.setCredits(rs.getInt("Credits"));
//                    cs.setDepartmentID(rs.getInt("DepartmentID"));
//                    courseList.add(cs);
//                }
//            } catch (SQLException ex) {
//                System.out.println("khong tim thay danh sach" + ex);
//            } finally {
//                CloseConnection();
//            }
//        } else {
//            System.out.println("Kết nối không thành công.");
//        }        
//        return courseList;        
//    }
//    
//    public boolean AddCourse(Course cs){
//        boolean result = false;
//        String sql = "INSERT INTO person VALUES(?,?,?,?)";
//        if (OpenConnection()) {
//            try {
//                PreparedStatement stmt = conn.prepareStatement(sql);
//                stmt.setInt(1, cs.getCourseID());
//                stmt.setString(2, cs.getTitle());
//                stmt.setInt(3, cs.getCredits());
//                stmt.setInt(4, cs.getDepartmentID());
//                if (stmt.executeUpdate() >= 1) {
//                    result = true;
//                }
//            } catch (SQLException ex) {
//                System.out.println("Them that bai" + ex);
//            } finally {
//                CloseConnection();
//            }
//        } else {
//            System.out.println("Kết nối không thành công.");
//        }
//        return result;
//    }
//    
//    public boolean DeleteCourse(int courseID) {
//        boolean result = false;
//        String sql = "DELETE FROM course WHERE CourseID = ?";
//        if (OpenConnection()) {
//            try {
//                PreparedStatement stmt = conn.prepareStatement(sql);
//                stmt.setInt(1, courseID);
//                if (stmt.executeUpdate() >= 1) {
//                    result = true;
//                }
//            } catch (SQLException ex) {
//                System.out.println("Xoa that bai" + ex);
//            } finally {
//                CloseConnection();
//            }
//        } else {
//            System.out.println("Kết nối không thành công.");
//        }
//        return result;
//    }
    
    // lấy danh sách title trong course
    public ArrayList<String> getAllCourseTitle() {
        ArrayList<String> list = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "select Title from Course";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    list.add(rs.getString("Title"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //closeConnection();
            }
        }
        return list;
    }

    public ArrayList<CourseInfo> getAllCourseInfo() {
        ArrayList<CourseInfo> list = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "select CourseID, Title from Course";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    CourseInfo cs = new CourseInfo();
                    cs.setCourseID(rs.getInt("CourseID"));
                    cs.setTitle(rs.getString("Title"));
                    list.add(cs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //closeConnection();
            }
        }
        return list;
    }

    // Lấy CourseID by Title
    public int getCourseIDByTitle(String title) {
        int courseID = -1;
        if (OpenConnection()) {
            try {
                String sql = "SELECT CourseID FROM Course WHERE Title = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, title);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        courseID = rs.getInt("CourseID");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //closeConnection();
            }
        }
        return courseID;
    }

    // Lấy Title by CourseID
    public String getTitleByCourseID(int id) {
        String title = null;
        if (OpenConnection()) {
            try {
                String sql = "SELECT Title FROM Course WHERE CourseID = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        title = rs.getString("Title");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //closeConnection();
            }
        }
        return title;
    }
    
    
    
}
