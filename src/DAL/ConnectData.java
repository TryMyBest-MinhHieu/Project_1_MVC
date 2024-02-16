package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MinhHieu
 */

public class ConnectData {
    private Connection conn;
    
    public boolean openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/school";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(dbUrl, username,password);
            return true;
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println("Kết nối thất bại " + ex);
                return false;
            }
    }
    
    public void closeConnection(){
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
