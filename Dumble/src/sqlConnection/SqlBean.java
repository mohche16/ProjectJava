package sqlConnection;

import java.sql.*;
import java.util.ArrayList;

public class SqlBean {
	
	public static Connection conn = SqlMain.con;
	
	
	public ArrayList<String> gatherData(String tosearch, String query, int col) throws SQLException
	{
		
		ArrayList<String> table = new ArrayList<String>();
		
		
		 try {
			 PreparedStatement stmt  = conn.prepareStatement(query);
			
			for(int i = 1; i <= col; i++) {
				
				
				stmt.setString(i, "%" + tosearch + "%");
				
			}
			
			ResultSet rs = stmt.executeQuery();
			
			String row = "";
			
			
			while (rs.next()) {
				
				for(int i = 1; i <= col; i++) {
					
					if(!(rs.getString(i) == null)) {
						row += rs.getString(i)+ " || ";

					}
					
					
				}
				
				
				
				
				table.add(row);
				
			    row = "";
			    
			 } rs.close();
			 
			 
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
			
			
			return table;
		
	}
}
