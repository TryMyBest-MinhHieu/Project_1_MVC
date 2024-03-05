package DAL;

import DTO.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

// Thêm, sửa, xóa
public class PersonDAL extends ConnectData{
    
    //int PersionID, String Lastname, String Firstname, Date HireDate, Date EnrollmentDate
    public ArrayList<Person> GetAllListPerson(){
        ArrayList<Person> personList = new ArrayList<Person>();
        String sql = "SELECT * FROM person";
        if (OpenConnection()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    Person ps = new Person();
                    ps.setPersonID(rs.getInt("PersonID"));
                    ps.setLastname(rs.getString("Lastname"));
                    ps.setFirstname(rs.getString("Firstname"));
                    ps.setHireDate(rs.getDate("HireDate"));
                    ps.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                    personList.add(ps);   
                }
            } catch (SQLException ex) {
                System.out.println("khong tim thay danh sach" + ex);
            }finally{CloseConnection();}
        } else {
            System.out.println("Kết nối không thành công.");
        }
        return personList;
    }
    

    public boolean AddPerson(Person ps){
        boolean result = false;
        String sql = "INSERT INTO person VALUES(?,?,?,?,?)";
        if(OpenConnection()){
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ps.getPersonID());
                stmt.setString(2, ps.getLastname());
                stmt.setString(3, ps.getFirstname());
                stmt.setDate(4, new java.sql.Date(ps.getHireDate().getTime()));
                stmt.setDate(5, new java.sql.Date(ps.getEnrollmentDate().getTime()));
                if(stmt.executeUpdate() >= 1)
                    result = true;
            } catch (SQLException ex) {
                System.out.println("Them that bai" + ex);
            }finally{CloseConnection();}
        }else {
            System.out.println("Kết nối không thành công.");
        }
        return result;
    }
    
    public boolean UpdatePerson(Person ps){
        boolean result = false;
        String sql = "UPDATE person SET Lastname = ?, Firstname = ?, HireDate = ?, EnrollmentDate = ? WHERE PersionID = ?";
        if(OpenConnection()){
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ps.getPersonID());
                stmt.setString(2, ps.getLastname());
                stmt.setString(3, ps.getFirstname());
                stmt.setDate(4, new java.sql.Date(ps.getHireDate().getTime()));
                stmt.setDate(5, new java.sql.Date(ps.getEnrollmentDate().getTime()));
                if(stmt.executeUpdate() >= 1)
                    result = true;
            } catch (SQLException ex) {
                System.out.println("Cap nhat that bai" + ex);
            }finally{CloseConnection();}
        }else {
            System.out.println("Kết nối không thành công.");
        }
        return result;
    }
    
    public boolean DeletePerson(int psID){
        boolean result = false;
        String sql = "DELETE FROM person WHERE PersonID = ?";
        if(OpenConnection()){
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, psID);
                if(stmt.executeUpdate() >= 1)
                     result = true;
            } catch (SQLException ex) {
                System.out.println("Xoa that bai" + ex);
            }finally{CloseConnection();}
        }else {
            System.out.println("Kết nối không thành công.");
        }
        return result;
    }
    
}
