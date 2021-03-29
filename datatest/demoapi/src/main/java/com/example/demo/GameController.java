package com.example.demo;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object
	
	@RequestMapping(method= RequestMethod.POST, path="/rps", produces = MediaType.APPLICATION_JSON_VALUE)
	public String CreatePlayers(String ply1Name, String ply2Name) {
		
		
		if (ply1Name.equals("") || ply2Name.equals("") || ply1Name.equals(ply2Name))
		{
			return "Invalid or duplicate names used, please try again with different name combinations";
		}
		
		Player ply = new Player(ply1Name);
		Player ply2 = new Player(ply2Name);
		
		
		Game newgame = new Game();
		
		
		return newgame.Start(ply, ply2);
		
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/rps", produces = MediaType.APPLICATION_JSON_VALUE)
	public String GetRPSArray() {
		
		
		String pattern = "{ \"RPS\":\"Rock Paper Scissors\"}";
		return pattern;
		
	}
	
	@RequestMapping(method= RequestMethod.PUT, path="/rpsPut", produces = MediaType.APPLICATION_JSON_VALUE)
	public String PutCar(String car) {
		cars.add(car);
		String allcars = "";
	      for (int i = 0; i < cars.size();i++) 
	      { 		      
	         allcars += cars.get(i) + "\n";
	      }   
		
		return allcars;
		
	}
	
	@RequestMapping(method= RequestMethod.DELETE, path="/rpsDel", produces = MediaType.APPLICATION_JSON_VALUE)
	public String DelCar() {
		cars.remove(cars.size() - 1);
		return "";
		
	}
	
}
