/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Course;
import DTO.CourseInstructor;
import DTO.CourseInstructorInfo;
import DTO.Instructor;
import java.awt.List;
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
public class CourseInstructorDAL extends ConnectData {

    public ArrayList<CourseInstructor> searchCourseInstructor(String query) {
        query = "%" + query + "%";
   
        ArrayList<CourseInstructor> list = new ArrayList<>();

        if (OpenConnection()) {
            try {
                String sql = "SELECT "
                        + "ci.CourseID,"
                        + "ci.PersonID,"
                        + "c.Title, "
                        + "c.Credits,"
                        + "p.Lastname,"
                        + "p.Firstname,"
                        + "p.Hiredate ,"
                        + "dep.Name "
                        + "FROM courseinstructor ci "
                        + "JOIN person p ON ci.PersonID = p.PersonID "
                        + "JOIN course c ON ci.CourseID = c.CourseID "
                        + "JOIN Department dep on c.DepartmentID = dep.DepartmentID "
                        + "where ci.CourseID like '" + query + "' "
                        + "or ci.CourseID like '" + query + "' "
                        + "or ci.PersonID like '" + query + "' "
                        + "or c.Title like '" + query + "' "
                        + "or c.Credits like '" + query + "' "
                        + "or p.Lastname like '" + query + "' "
                        + "or p.Hiredate like '" + query + "' "
                        + "or dep.Name like '" + query + "' ";


                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    CourseInstructor ci = new CourseInstructor();
                    ci.getPerson().setPersonID(rs.getInt("PersonID"));
                    ci.getPerson().setFirstname(rs.getString("Firstname"));
                    ci.getPerson().setLastname(rs.getString("Lastname"));
                    ci.getPerson().setHireDate(rs.getDate("Hiredate"));
                    ci.getCourse().setCourseID(rs.getInt("CourseID"));
                    ci.getCourse().setTitle(rs.getString("Title"));
                    ci.getCourse().setCredits(rs.getInt("Credits"));
                    ci.setDepartmentName(rs.getString("Name"));
                    list.add(ci);

                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                CloseConnection();
            }
        }
        
        return list;
    }
    
    
    public ArrayList<CourseInstructor> getAllCourseInstructor() {
        ArrayList<CourseInstructor> list = new ArrayList<>();

        if (OpenConnection()) {
            try {
                String sql = "SELECT "
                        + "ci.CourseID,"
                        + "ci.PersonID,"
                        + "c.Title, "
                        + "c.Credits,"
                        + "p.Lastname,"
                        + "p.Firstname,"
                        + "p.Hiredate ,"
                        + "dep.Name "
                        + "FROM courseinstructor ci "
                        + "JOIN person p ON ci.PersonID = p.PersonID "
                        + "JOIN course c ON ci.CourseID = c.CourseID "
                        + "JOIN Department dep on c.DepartmentID = dep.DepartmentID";

                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    CourseInstructor ci = new CourseInstructor();
                    ci.getPerson().setPersonID(rs.getInt("PersonID"));
                    ci.getPerson().setFirstname(rs.getString("Firstname"));
                    ci.getPerson().setLastname(rs.getString("Lastname"));
                    ci.getPerson().setHireDate(rs.getDate("Hiredate"));
                    ci.getCourse().setCourseID(rs.getInt("CourseID"));
                    ci.getCourse().setTitle(rs.getString("Title"));
                    ci.getCourse().setCredits(rs.getInt("Credits"));
                    ci.setDepartmentName(rs.getString("Name"));
                    list.add(ci);

                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                CloseConnection();
            }

        }

        return list;
    }

    public ArrayList<Instructor> getAllInstructor() {
        ArrayList<Instructor> list = new ArrayList<>();

        if (OpenConnection()) {
            try {
                String sql = "SELECT InstructorID,"
                        + "Location,"
                        + "p.Firstname,"
                        + "p.Lastname,"
                        + "p.HireDate "
                        + "from OfficeAssignment oat "
                        + "JOIN Person p ON oat.InstructorID = p.PersonID ";

                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    Instructor ci = new Instructor(
                            rs.getInt("InstructorID"),
                            rs.getString("Location")
                    );
                    ci.getPerson().setFirstname(rs.getString("Firstname"));
                    ci.getPerson().setLastname(rs.getString("Lastname"));
                    ci.getPerson().setHireDate(rs.getDate("HireDate"));
                    list.add(ci);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                CloseConnection();
            }

        }

        return list;
    }

    public boolean deleteCourseInstructor(int courseID, int personID) {
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "delete from CourseInstructor where CourseID = ? and PersonID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, courseID);
                stm.setInt(2, personID);
                if (stm.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }

        }

        return check;
    }

    public boolean deleteAllCourseInstructor(int courseID) {
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "delete from CourseInstructor where CourseID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, courseID);
                if (stm.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }

        }

        return check;
    }

    public boolean updateCourseInstructor(int courseID, ArrayList<Integer> instructorIDs) {
        boolean check = false;
        if (OpenConnection()) {
            try {
                conn.setAutoCommit(false);
                String sqlDelete = "DELETE FROM CourseInstructor WHERE CourseID = ?";
                String sqlInsert = "INSERT INTO CourseInstructor (CourseID, PersonID) VALUES (?, ?)";

                PreparedStatement deleteStatement = conn.prepareStatement(sqlDelete);
                deleteStatement.setLong(1, courseID);
                deleteStatement.executeUpdate();

                PreparedStatement insertStatement = conn.prepareStatement(sqlInsert);
                for (Integer instructorID : instructorIDs) {
                    insertStatement.setLong(1, courseID);
                    insertStatement.setLong(2, instructorID);
                    insertStatement.addBatch();
                }
                insertStatement.executeBatch();
                check = true;

                conn.commit();
                conn.setAutoCommit(true);

            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
                if (conn != null) {
                    try {
                        System.err.print("Update CourseInstructor That Bai!!");
                        conn.rollback();
                    } catch (SQLException excep) {
                        Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, excep);
                    }
                }

            } finally {
                CloseConnection();
            }

        }

        return check;
    }

    public ArrayList<Course> GetAllCourse() {
        ArrayList<Course> courseList = new ArrayList<>();
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

    public ArrayList<Integer> getInstructorsForCourse(int courseID) {
        ArrayList<Integer> instructorIDs = new ArrayList<>();
        String query = "SELECT i.PersonID "
                + "FROM Person i "
                + "INNER JOIN CourseInstructor ci ON i.PersonID = ci.PersonID "
                + "WHERE ci.CourseID = ?";

        if (OpenConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, courseID);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Integer id = rs.getInt("PersonID");
                    instructorIDs.add(id);
                }
            } catch (SQLException ex) {
                System.out.println("khong tim thay danh sach" + ex);
            } finally {
                CloseConnection();
            }
        } else {
            System.out.println("Kết nối không thành công.");
        }
        return instructorIDs;
    }

}
