//package travel;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class myconnection {
//	public static Connection getConnection(){
//        Connection con = null;
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost/travelgo", "root", "root1234");
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
//        return con;
//    }
//
//}

package travel;

import java.sql.Connection;
import java.sql.DriverManager;

public class myconnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/travelgo", "root", "root1234"
            );
            System.out.println("✅ Database connected successfully!");
        } catch (Exception ex) {
            System.out.println("❌ Database connection failed: " + ex.getMessage());
            ex.printStackTrace();
        }
        return con;
    }
}
