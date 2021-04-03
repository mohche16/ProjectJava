package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@RestController
public class CsvController {
	
	private static String jsonList = "";

	
	public static String getJsonList() {
		if (!jsonList.isEmpty())
		{
			return jsonList;
		}
		else {
			ArrayList<String> SimpleCsv= new ArrayList<String>();
			String filteredstr;
			for (ArrayList<String> row : readCSV.getWholeSheet()) {
				filteredstr = row.toString().replaceAll("\\[", " ").replaceAll("\\]", "").replaceAll(" ", "");
				SimpleCsv.add(filteredstr);	
			}
			String json = readCSV.csvToJson(SimpleCsv);
			jsonList = json;
			return jsonList;
		}
	}

	@RequestMapping(value = "/showCSV", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public void showCSV(HttpServletResponse response) throws IOException {

		var csvFile = new ClassPathResource("sample.csv");

		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());

	}

	@RequestMapping(value = "/showCSVList", method = RequestMethod.GET)
	public ArrayList<String> showCSVList() {

		

		ArrayList<String> SimpleCsv= new ArrayList<String>();
		
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
			
			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}
	@RequestMapping(value = "/showCSVListJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showCSVListJSON() {
		return getJsonList();

	}
	
	@RequestMapping(value = "/getAllJSONCol", method = RequestMethod.GET)
	public ArrayList<String> getAllJSONCol(String col)  {
			return jsonParse.getAllJSONCol(col);
	}
	
	@RequestMapping(value = "/getAllJSONColSorted", method = RequestMethod.GET)
	public ArrayList<String> getAllJSONColSorted(String col)  {
			return jsonParse.getAllJSONColSorted(col);
	}
	
	@RequestMapping(value = "/getWrongTotal", method = RequestMethod.GET)
	public ArrayList<String> getWrongTotal()  {
			return jsonParse.getWrongTotal();
	}
	

}
