package main;

import java.sql.SQLException;

import sqlConnection.SqlBean;
import sqlConnection.SqlMain;
import java.util.ArrayList;
import java.util.Scanner;

public class DumbleMain {

	public static void main(String[] args) throws SQLException {
		
		SqlMain con = new SqlMain(); 
		con.connectToDB();
		SqlBean sqlworker = new SqlBean();
		ArrayList<ArrayList<String>> Table = new ArrayList<ArrayList<String>>();
		
		String Query1 = "SELECT * FROM `bearbase` WHERE `Character` LIKE ? OR `Origin` LIKE ? OR `Creator` LIKE ? OR `Notes` LIKE ?";
		String Query2 = "SELECT * FROM `ikea_names` WHERE `name` LIKE ? OR `description` LIKE ? OR `Column_3` LIKE ? OR `Column_4` LIKE ? OR `Column_5` LIKE ?";
		String Query3 = "SELECT * FROM `masterscplist` WHERE `SCP` LIKE ? OR `Title` LIKE ? OR `rating` LIKE ? OR `Classification` LIKE ? OR `Type` LIKE ? OR `Related_GOI_s` LIKE ? OR `Location_Notes` LIKE ? OR `Author` LIKE ? OR `Leaked_info` LIKE ? OR `Humanoid_or_Structure` LIKE ? OR `Animal_Computer_or_Extradimensional` LIKE ? OR `Autonomous_or_Cognitohazard` LIKE ? OR `Artifact_Location_or_Sentient` LIKE ? OR `Summary` LIKE ? OR `Gender` LIKE ? OR `None` LIKE ? OR `Ethnicity_Origins` LIKE ?";
		
		while (true)
		{
		 Scanner sc = new Scanner(System.in);

		 System.out.println("Word to search for: ");
		 String searchWord = sc.nextLine();
		 if (searchWord.isEmpty()) {
			 System.out.println("Please enter a valid word to search for");
			 continue;
		 }
		
		 Table.add(sqlworker.gatherData(searchWord, Query1, 4));
		 Table.add(sqlworker.gatherData(searchWord, Query2, 5));
		 Table.add(sqlworker.gatherData(searchWord, Query3, 17));
		 
		 if (Table.isEmpty()) {
			 System.out.println("No results found");
			 continue;
		 }
		 System.out.println(Table);
		
		}		

	}

}
