package sqlConnection;
import java.sql.*;  

public class SqlMain {
	
	public static Connection connectToDB() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieproject",
					"root","");  
			return con;
			
		} catch(Exception ex) {
			System.out.println("Exception Driver " + ex.getMessage());
			return con;
		}
	}
	
	
}