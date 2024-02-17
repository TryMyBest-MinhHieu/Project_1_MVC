package DAL;

import DTO.Course;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

// Thêm, Xóa
public class CourseDAL {
    ConnectData cd = new ConnectData();
    Connection conn = cd.GetConnection();
    
    //int courseID, String title, int credits, int departmentID
    public ArrayList<Course> GetAllListCourse(){
        ArrayList<Course> courseList = new ArrayList<Course>();
        String sql = "SELECT * FROM course";
        if (cd.OpenConnection()) {
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
                cd.CloseConnection();
            }
        } else {
            System.out.println("Kết nối không thành công.");
        }        
        return courseList;        
    }
    
    public boolean AddCourse(Course cs){
        boolean result = false;
        String sql = "INSERT INTO person VALUES(?,?,?,?)";
        if (cd.OpenConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, cs.getCourseID());
                stmt.setString(2, cs.getTitle());
                stmt.setInt(3, cs.getCredits());
                stmt.setInt(4, cs.getDepartmentID());
                if (stmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException ex) {
                System.out.println("Them that bai" + ex);
            } finally {
                cd.CloseConnection();
            }
        } else {
            System.out.println("Kết nối không thành công.");
        }
        return result;
    }
    
    public boolean DeleteCourse(int courseID) {
        boolean result = false;
        String sql = "DELETE FROM course WHERE CourseID = ?";
        if (cd.OpenConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, courseID);
                if (stmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException ex) {
                System.out.println("Xoa that bai" + ex);
            } finally {
                cd.CloseConnection();
            }
        } else {
            System.out.println("Kết nối không thành công.");
        }
        return result;
    }
    
}
