package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	@RequestMapping(method= RequestMethod.GET, path="/rps", produces = MediaType.APPLICATION_JSON_VALUE)
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
	
}
