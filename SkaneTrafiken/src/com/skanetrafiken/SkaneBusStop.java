package com.skanetrafiken;

//Our object that we parse the site to
public class SkaneBusStop {
	private int id;
	private String name;
	private int x;
	private int y;
	private int distance;
	
	
	public void setId(int ID) {
		this.id = ID;
	}
	
	public void setName(String NAME) {
		this.name = NAME;
	}
	
	public void setLongitude(int X) {
		this.x = X;
	}
	
	public void setLatitude(int Y) {
		this.y = Y;
	}
	
	public void setDistance(int DISTANCE) {
		this.distance = DISTANCE;
	}
	
	//Getters
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getLongitude() {
		return this.x;
	}
	
	public float getLatitude() {
		return this.y;
	}
	
	public int getDistance() {
		return this.distance;
	}


}