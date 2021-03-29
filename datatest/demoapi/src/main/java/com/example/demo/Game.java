package com.example.demo;


public class Game {
	
	int ply1Score = 0;
	int ply2Score = 0;

	public void getRoundWinner(Player play1, Player play2) {
		 if (play1.getPlay().equals("rock") && play2.getPlay().equals("scissors")) {
	            	ply1Score++;
	        } else if (play1.getPlay().equals("paper") && play2.getPlay().equals("rock")) {
	        	   ply1Score++;
	        } else if (play1.getPlay().equals("scissors") && play2.getPlay().equals("paper")) {
	               ply1Score++;
	        }
	        else {
	               ply2Score++;
	        }
	}
	
	
	public String Start(Player ply1, Player ply2)
	{
		
		String resp = "";
		int counter = 0;
		ply1Score = 0;
		ply2Score = 0;
		
		while (ply1Score < 3 && ply2Score < 3)
		{
			counter++;
			ply1.setPlay();
			ply2.setPlay();
			
			this.getRoundWinner(ply1, ply2);
			
		}
		
		String pattern = "{ \"Score player 1\":\"%s\",\"Score player 2\":\"%s\"}";
		resp += String.format(pattern, ply1Score, ply2Score);
		
		return resp;
		
	}
}
