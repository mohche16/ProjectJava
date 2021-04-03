package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class jsonParse {
	
	
	public static ArrayList<String> getAllJSONCol(String col)  {
		JsonArray jsonObject = new JsonParser().parse(CsvController.getJsonList()).getAsJsonArray();
		ArrayList<String> matchedCases = new ArrayList<String>();
		String currObj = "";
		for (int i = 0; i < jsonObject.size(); i++)
		{
			currObj = jsonObject.get(i).getAsJsonObject().get(col).getAsString();
			if (!currObj.isEmpty())
			{
				matchedCases.add(currObj);
			}
		}
		return matchedCases;
}
	
	public static ArrayList<String> getAllJSONColSorted(String col)  {
		JsonArray jsonObject = new JsonParser().parse(CsvController.getJsonList()).getAsJsonArray();
		ArrayList<String> matchedCases = new ArrayList<String>();
		String currObj = "";
		for (int i = 0; i < jsonObject.size(); i++)
		{
			currObj = jsonObject.get(i).getAsJsonObject().get(col).getAsString();
			if (!currObj.isEmpty())
			{
				matchedCases.add(currObj);
			}
		}
		Collections.sort(matchedCases);
		return matchedCases;
}
	
	public static ArrayList<String> getWrongTotal()  {
		JsonArray jsonObject = new JsonParser().parse(CsvController.getJsonList()).getAsJsonArray();
		ArrayList<String> wronglyCalculated = new ArrayList<String>();
		int orderId;
		float Units, UnitCost, Total;
		for (int i = 0; i < jsonObject.size(); i++)
		{
			orderId = jsonObject.get(i).getAsJsonObject().get("OrderId").getAsInt();
			Units = jsonObject.get(i).getAsJsonObject().get("Units").getAsInt();
			UnitCost = jsonObject.get(i).getAsJsonObject().get("UnitCost").getAsFloat();
			Total = jsonObject.get(i).getAsJsonObject().get("Total").getAsFloat();
			
			if (Units != 0 && UnitCost != 0 && Total != 0)
			{
				float total = Units * UnitCost;
				if (total != Total)
				{
					wronglyCalculated.add("OrderID: " + Integer.toString(orderId) + " is wrongly calculated, should be: " + Float.toString(total));
				}
			}
			
		}
		return wronglyCalculated;
}
}
