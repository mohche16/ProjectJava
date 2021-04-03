package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class readCSV {

	private static String COMMA_DELIMITER = ",";

	private static ArrayList<ArrayList<String>> wholeSheet = new ArrayList<>();

	public static ArrayList<ArrayList<String>> getWholeSheet() {
		if (wholeSheet.isEmpty()) {
			loadCSV();
		}
		return wholeSheet;
	}

	public static void loadCSV() {
		var csvFile = new ClassPathResource("sample.csv");
	
		try (Scanner scanner = new Scanner(csvFile.getFile());) {
			int i = 0;
			while (scanner.hasNextLine()) {
				wholeSheet.add(getRows(scanner.nextLine(), i));
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static ArrayList<String> getRows(String row, int i) {
		ArrayList<String> rowValues = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(row)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);

			
			rowValues.add(String.valueOf(i));
			while (rowScanner.hasNext()) {
				String currentCell = rowScanner.next();
				

				
					rowValues.add(currentCell);
				

			}
		}

		return rowValues;
	}

	public static void printCSV() {
		for (ArrayList<String> row : wholeSheet) {
			System.out.println(row);

		}
	}
	
	 public static String csvToJson(List<String> csv){

	        //remove empty lines
	        //this will affect permanently the list. 
	        //be careful if you want to use this list after executing this method
	        csv.removeIf(e -> e.trim().isEmpty());

	        //csv is empty or have declared only columns
	        if(csv.size() <= 1){
	            return "[]";
	        }

	        //get first line = columns names
	        String[] columns = csv.get(0).split(",");
	        columns[0] = "OrderId";
	       

	        //get all rows
	        StringBuilder json = new StringBuilder("[\n");
	        csv.subList(1, csv.size()) //substring without first row(columns)
	            .stream()
	            .map(e -> e.split(","))
	            .filter(e -> e.length == columns.length) //values size should match with columns size
	            .forEach(row -> {

	                json.append("\t{\n");

	                    for(int i = 0; i < columns.length; i++){
	                        json.append("\t\t\"")
	                            .append(columns[i])
	                            .append("\" : \"")
	                            .append(row[i])
	                            .append("\",\n"); //comma-1
	                    }

	                    //replace comma-1 with \n
	                    json.replace(json.lastIndexOf(","), json.length(), "\n");

	                json.append("\t},"); //comma-2

	            });

	        //remove comma-2
	        json.replace(json.lastIndexOf(","), json.length(), "");

	        json.append("\n]");

	        return json.toString();

	    }

	
}
