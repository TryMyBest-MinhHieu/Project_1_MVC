/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Person;
import DTO.StudentGrade;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// Thêm, sửa, xóa
public class StudentGradeDAL extends ConnectData {
//    ConnectData cd = new ConnectData();
//    Connection conn = cd.GetConnection();

    public ArrayList<StudentGrade> getAllStudentGrade() {
        ArrayList<StudentGrade> list = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "select stu.EnrollmentID, stu.CourseID, stu.StudentID,"
                        + " c.Title, p.FirstName, p.LastName, stu.Grade"
                        + " from StudentGrade stu, Person p, Course c"
                        + " where stu.CourseID = c.CourseID and stu.StudentID = p.PersonId";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    StudentGrade sg = new StudentGrade();
                    sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    sg.setCourseID(rs.getInt("CourseID"));
                    sg.setStudentID(rs.getInt("StudentID"));
                    sg.setFirstName(rs.getString("FirstName"));
                    sg.setLastName(rs.getString("LastName"));
                    sg.setTitle(rs.getString("Title"));
                    sg.setGrade(rs.getDouble("Grade"));
                    if (rs.wasNull()) {
                        sg.setGrade(-1);
                    }
                    list.add(sg);
                }

            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }

        return list;
    }

    public ArrayList<Person> getAllStudent() {
        ArrayList<Person> list = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "select PersonID, Firstname, Lastname, EnrollmentDate"
                        + " from person"
                        + " where EnrollmentDate IS NOT NULL;";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    Person person = new Person();
                    person.setPersonID(rs.getInt("PersonID"));
                    person.setFirstname(rs.getString("Firstname"));
                    person.setLastname(rs.getString("Lastname"));
                    person.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                    list.add(person);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return list;
    }

    public boolean Update(String enrollmentId, float grade) {
        if (OpenConnection()) {
            String insertSql = "UPDATE studentgrade"
                    + " SET Grade = ?"
                    + " WHERE EnrollmentID = ?;";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
                insertStatement.setFloat(1, grade);
                insertStatement.setString(2, enrollmentId);
                if (insertStatement.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return false;
    }

    public boolean Add(String enrollmentId, String courseId, String studentId, float grade) {
        if (OpenConnection()) {
            if (grade == -1) {
                String insertSql = "INSERT INTO "
                        + "studentgrade(EnrollmentID, CourseID, StudentID) "
                        + "VALUES (?, ?, ?)";
                try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
                    insertStatement.setString(1, enrollmentId);
                    insertStatement.setString(2, courseId);
                    insertStatement.setString(3, studentId);
                    if (insertStatement.executeUpdate() > 0) {
                        return true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    CloseConnection();
                }
            } else {
                String insertSql = "INSERT INTO "
                        + "studentgrade(EnrollmentID, CourseID, StudentID, Grade) "
                        + "VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
                    insertStatement.setString(1, enrollmentId);
                    insertStatement.setString(2, courseId);
                    insertStatement.setString(3, studentId);
                    insertStatement.setFloat(4, grade);
                    if (insertStatement.executeUpdate() > 0) {
                        return true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    CloseConnection();
                }
            }
        }
        return false;
    }

    public boolean addNewStudent(String studentId, String firstName, String lastName, String enrollmentDate) {
        if (OpenConnection()) {
                String insertSql = "INSERT INTO"
                        + " person(PersonID , Firstname, Lastname, EnrollmentDate)"
                        + " VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
                    insertStatement.setString(1, studentId);
                    insertStatement.setString(2, firstName);
                    insertStatement.setString(3, lastName);
                    insertStatement.setString(4, enrollmentDate);
                    if (insertStatement.executeUpdate() > 0) {
                        return true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    CloseConnection();
                }
            
        }
        return false;
    }

    public boolean removeStudentFromCourse(String courseId, String studentId) {
        if (OpenConnection()) {
            try {
                String sql = "DELETE FROM studentgrade WHERE"
                        + " CourseID = ?"
                        + " AND StudentID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, courseId);
                stm.setString(2, studentId);
                if (stm.executeUpdate() >= 1) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return false;
    }

    public boolean StudentAlreadyHaveGrade(String courseId, String studentId) {
        if (OpenConnection()) {
            try {
                String sql = "select *"
                        + " from studentgrade"
                        + " where CourseID = " + courseId
                        + " and StudentID = " + studentId
                        + " and Grade is not null;";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return false;
    }

    public boolean StudentAlreadyInCourse(String courseId, String studentId) {
        if (OpenConnection()) {
            try {
                String sql = "select *"
                        + " from studentgrade"
                        + " where CourseID = " + courseId
                        + " and StudentID = " + studentId + ";";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return false;
    }

    public String GetTitleById(int id) {
        if (OpenConnection()) {
            try {
                String sql = "select Title"
                        + " from Course"
                        + " where CourseID = " + id + ";";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    return rs.getString(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return "";
    }

    public String GetFirstNameById(int id) {
        if (OpenConnection()) {
            try {
                String sql = "select p.FirstName"
                        + " from StudentGrade stu, Person p"
                        + " where stu.StudentID = p.PersonId"
                        + " and stu.EnrollmentID = " + id + ";";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    return rs.getString(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return "";
    }

    public String GetLastNameById(int id) {
        if (OpenConnection()) {
            try {
                String sql = "select p.LastName"
                        + " from StudentGrade stu, Person p"
                        + " where stu.StudentID = p.PersonId"
                        + " and stu.EnrollmentID = " + id + ";";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    return rs.getString(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return "";
    }

    public int GetMaxId() {
        if (OpenConnection()) {
            try {
                String sql = "SELECT MAX(EnrollmentID) AS maxId FROM studentgrade;";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    return rs.getInt("maxId");
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return -1;
    }

    public int GetMaxIdPerson() {
        if (OpenConnection()) {
            try {
                String sql = "SELECT MAX(PersonID) AS maxId FROM Person";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    return rs.getInt("maxId");
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return -1;
    }

    public boolean checkStudentGradeID(int enrollmentID) {
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "select * from StudentGrade where EnrollmentID = " + enrollmentID;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }

        }

        return check;
    }

    public ArrayList<Integer> getAllStudentID() {
        ArrayList<Integer> list = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "select PersonID from Person where EnrollmentDate is not NULL";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    list.add(Integer.valueOf(rs.getInt("PersonID")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }

        return list;
    }

    public ArrayList<Integer> getAllCourseID() {
        ArrayList<Integer> list = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "select CourseID from Course";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    list.add(Integer.valueOf(rs.getInt("CourseID")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return list;
    }

    public boolean addStudentGrade(StudentGrade sg) {
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "insert into StudentGrade values(?,?,?)";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, sg.getCourseID());
                stm.setInt(2, sg.getStudentID());
                stm.setDouble(3, sg.getGrade());
                if (stm.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }

        }
        return check;
    }

    public boolean deleteStudentGrade(int enrollmentID) {
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "delete from StudentGrade where EnrollmentID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, enrollmentID);
                if (stm.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }

        }

        return check;
    }

    public boolean updateStudentGrade(StudentGrade sg) {
        boolean check = false;
        if (OpenConnection()) {
            try {
                String sql = "update StudentGrade set CourseID = ?, PersonID = ?, Grade = ? where EnrollmentID = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, sg.getCourseID());
                stm.setInt(2, sg.getStudentID());
                stm.setDouble(3, sg.getGrade());
                stm.setInt(4, sg.getEnrollmentID());
                if (stm.executeUpdate() >= 1) {
                    check = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }

        return check;
    }

    public ArrayList<StudentGrade> searchStudentGrade(String data) {
        data = "%" + data + "%";
        ArrayList<StudentGrade> list = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "select stu.EnrollmentID, stu.CourseID, stu.StudentID,"
                        + " c.Title, p.FirstName, p.LastName, stu.Grade"
                        + " from StudentGrade stu, Person p, Course c"
                        + " where stu.CourseID = c.CourseID and stu.StudentID = p.PersonId"
                        + " and (stu.EnrollmentID like '" + data + "'"
                        + " or stu.CourseID like '" + data + "'"
                        + " or stu.StudentID like '" + data + "'"
                        + " or c.Title like '" + data + "'"
                        + " or p.FirstName like '" + data + "'"
                        + " or p.LastName like '" + data + "'"
                        + " or stu.Grade like '" + data + "');";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    StudentGrade sg = new StudentGrade();
                    sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    sg.setCourseID(rs.getInt("CourseID"));
                    sg.setStudentID(rs.getInt("StudentID"));
                    sg.setFirstName(rs.getString("FirstName"));
                    sg.setLastName(rs.getString("LastName"));
                    sg.setTitle(rs.getString("Title"));
                    sg.setGrade(rs.getDouble("Grade"));
                    if (rs.wasNull()) {
                        sg.setGrade(-1);
                    }
                    list.add(sg);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }

        return list;
    }

    public ArrayList<Person> searchStudent(String data) {
        data = "%" + data + "%";
        ArrayList<Person> list = new ArrayList<>();
        if (OpenConnection()) {
            try {
                String sql = "select PersonID, Firstname, Lastname, EnrollmentDate"
                        + " from person"
                        + " where EnrollmentDate IS NOT NULL"
                        + " and (PersonID like '" + data + "'"
                        + " or Firstname like '" + data + "'"
                        + " or Lastname like '" + data + "'"
                        + " or EnrollmentDate like '" + data + "');";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    Person person = new Person();
                    person.setPersonID(rs.getInt("PersonID"));
                    person.setFirstname(rs.getString("Firstname"));
                    person.setLastname(rs.getString("Lastname"));
                    person.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                    list.add(person);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CloseConnection();
            }
        }
        return list;
    }
}
