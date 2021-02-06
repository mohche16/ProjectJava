package com.skanetrafiken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


//Api used to grab and parse skanelabs api and append to busList ArrayList of busStop objects
//Credits to markus github

public class SkaneApi {
	
	//Arraylist of SkaneBusStop objects
	private ArrayList<SkaneBusStop> busList = new ArrayList<SkaneBusStop>();
	
	// public method that returns private member object
	public ArrayList<SkaneBusStop> getStops() {
		return busList;
	}
	
	// Function to remove duplicates from an ArrayList 
    public void removeDuplicates(ArrayList<SkaneBusStop> list) 
    { 
    	ArrayList<SkaneBusStop> busList2 = new ArrayList<SkaneBusStop>();
  
        // Traverse through the first list 
        for (SkaneBusStop element : busList) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!busList2.contains(element)) { 
  
            	busList2.add(element); 
            } 
        } 
  
        // return the new list 
       busList = busList2;
    } 
	

    //returns list of bus stops with id,name, x, y, distance, address
	public void getNearestStation(float xlong, float ylat, float r) throws IOException {
		busList.clear();
		String url = String.format("http://www.labs.skanetrafiken.se/v2.2/neareststation.asp?x=%s&y=%s&radius=%s", xlong, ylat, r);
		URL line_api_url = new URL(url);
		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();

		linec.setDoInput(true);

		linec.setDoOutput(true);

		linec.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		String inputLine;

		String ApiResponse = "";

		while ((inputLine = in.readLine()) != null) {

			ApiResponse += inputLine;

		}
		in.close();

		Document doc = convertStringToXMLDocument(ApiResponse);

		doc.getDocumentElement().normalize();

		Node nodeBody = doc.getElementsByTagName("soap:Body").item(0);

		NodeList nodeResult = (NodeList) nodeBody.getFirstChild().getFirstChild();

		Node nodelines = nodeResult.item(2);

		NodeList listOflines = nodelines.getChildNodes();

		for (int i = 0; i < listOflines.getLength(); i++) {


			NodeList allLine = listOflines.item(i).getChildNodes();
			SkaneBusStop busStop = new SkaneBusStop();
			for (int y = 0; y < allLine.getLength(); y++) {
				
				if (allLine.item(y).getNodeName().equals("Id")) {
					busStop.setId(Integer.parseInt(allLine.item(y).getTextContent()));
					
					// add xml result to list
					//names.add(allLine.item(y).getTextContent());
				}
				
				 if (allLine.item(y).getNodeName().equals("Name")) {
					busStop.setName(allLine.item(y).getTextContent());
					
					// add xml result to list
					//names.add(allLine.item(y).getTextContent());
				}
				
				if (allLine.item(y).getNodeName().equals("X")) {
					busStop.setLongitude(Integer.parseInt(allLine.item(y).getTextContent()));
					
					// add xml result to list
					//names.add(allLine.item(y).getTextContent());
				}
				
				if (allLine.item(y).getNodeName().equals("Y")) {
					busStop.setLatitude(Integer.parseInt(allLine.item(y).getTextContent()));
					
					// add xml result to list
					//names.add(allLine.item(y).getTextContent());
				}
				
				if (allLine.item(y).getNodeName().equals("Distance")) {
					busStop.setDistance(Integer.parseInt(allLine.item(y).getTextContent()));
					
					// add xml result to list
					//names.add(allLine.item(y).getTextContent());
				}
				
				busList.add(busStop);
			}
		}

	}

	private Document convertStringToXMLDocument(String xmlString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;

		try {

			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

			return doc;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
