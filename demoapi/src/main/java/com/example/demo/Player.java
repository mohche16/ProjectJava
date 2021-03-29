package com.example.demo;
import java.util.Random;

public class Player {
	private String name;
	private String play;
	String[] plays = {"rock", "paper", "scissors"};
	
	Player(String plyid)
	{
		this.name = plyid;
	}
	
	public boolean validatePlay(String playedplay)
	{
		if (playedplay.equals("rock") || playedplay.equals("paper") || playedplay.equals("scissors"))
		{
			return true;
		}
		return false;
	}
	
	public String getId()
	{
		return this.name;
	}
	
	public void setPlay() {
		int randomNum = (int) (Math.random()*3);
		String forcedplay = plays[randomNum];
		this.play = forcedplay;
	}
	
	public String getPlay() {
		return this.play;
	}
}
