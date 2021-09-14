package sqlConnection;
import java.sql.*;  

public class SqlMain {
	
	public static Connection con = null;
	
	public static Connection connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dumblesql",
					"root","");  
			System.out.println("Connected");
			
			return con;
			
		} catch(Exception ex) {
			System.out.println("Exception Driver " + ex.getMessage());
			return con;
		}
	}
	
	
}