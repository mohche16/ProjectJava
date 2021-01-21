package com.mvc.login;

import java.util.HashMap;
import java.util.Map;

public class User {
	
	private String userName;
	private String userPassword;
	private HashMap<String, String> userMap = new HashMap<String, String>(); 
	private String motd = "Default motd message for " + this.userName;

	public void setUsername(String username) {
		this.userName = username;
	}
	
	public void setPassword(String password) {
		this.userPassword = password;
	}
	
	public void setMotd(String message) {
		this.motd = message;
	}
	
	public String getMotd() {
		return this.motd;
	}
	
	public boolean VerifyUser(User user) {
		
		for (Map.Entry<String, String> entry : userMap.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    
		    if (key.equals(user.userName) && value.equals(user.userPassword))
		    	return true;
		}
		return false;
	}
	
	
	public User(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
		userMap.put("user1", "password1"); 
    	userMap.put("user2", "password2"); 
	}
}
