package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MinhHieu
 */

public class ConnectData {
    public Connection conn;
    
    public boolean OpenConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/school";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(dbUrl, username,password);
            return true;
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println("Kết nối thất bại " + ex);
                return false;
            }
    }
    
    public Connection GetConnection(){
        return conn;
    }
    
    public void CloseConnection(){
        try{
            if(conn != null)
                conn.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
//    
//    public static void main(String[] args) {
//        ConnectData conn = new ConnectData();
//        conn.openConnection();
//    }
}
