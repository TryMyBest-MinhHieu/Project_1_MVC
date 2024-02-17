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

// Thêm, sửa, xóa
public class StudentGradeDAL {
    ConnectData cd = new ConnectData();
    Connection conn = cd.GetConnection();
    
    //int EnrollmentID, int CourseID, int StudentID, BigDecimal Grade
    public ArrayList<StudentGrade> GetAllListStudentGrade(){
        ArrayList<StudentGrade> studentGradesList = new ArrayList<StudentGrade>();
        String sql = "SELECT * FROM studentgrade";
        if (cd.OpenConnection()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    StudentGrade sg = new StudentGrade();
                    sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    sg.setCourseID(rs.getInt("CourseID"));
                    sg.setStudentID(rs.getInt("StudentID"));
                    sg.setGrade(rs.getBigDecimal("Grade"));
                    studentGradesList.add(sg);   
                }
            } catch (SQLException ex) {
                System.out.println("khong tim thay danh sach" + ex);
            }finally{ cd.CloseConnection();}
        } else {
            System.out.println("Kết nối không thành công.");
        }
        return studentGradesList;
    }
    

    public boolean AddStudentGrade(StudentGrade sg){
        boolean result = false;
        String sql = "INSERT INTO studentgrade VALUES(?,?,?,?)";
        if(cd.OpenConnection()){
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, sg.getEnrollmentID());
                stmt.setInt(2, sg.getCourseID());
                stmt.setInt(3, sg.getStudentID());
                stmt.setBigDecimal(4, sg.getGrade());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            } catch (SQLException ex) {
                System.out.println("Them that bai" + ex);
            }finally{ cd.CloseConnection();}
        }else {
            System.out.println("Kết nối không thành công.");
        }
        return result;
    }
    
    public boolean UpdateStudentGrade(StudentGrade sg){
        boolean result = false;
        String sql = "UPDATE studentgrade SET CourseID = ?, StudentID = ?, Grade = ? WHERE EnrollmentID = ?";
        if(cd.OpenConnection()){
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1,sg.getEnrollmentID());
                stmt.setInt(2, sg.getCourseID());
                stmt.setInt(3, sg.getStudentID());
                stmt.setBigDecimal(4, sg.getGrade());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            } catch (SQLException ex) {
                System.out.println("Cap nhat that bai" + ex);
            }finally{ cd.CloseConnection();}
        }else {
            System.out.println("Kết nối không thành công.");
        }
        return result;
    }
    
    public boolean DeleteStudentGrade(int sgID){
        boolean result = false;
        String sql = "DELETE FROM studentgrade WHERE EnrollmentID = ?";
        if(cd.OpenConnection()){
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, sgID);
                if(stmt.executeUpdate() >= 1)
                     result = true;
            } catch (SQLException ex) {
                System.out.println("Xoa that bai" + ex);
            }finally{ cd.CloseConnection();}
        }else {
            System.out.println("Kết nối không thành công.");
        }
        return result;
    }
}
