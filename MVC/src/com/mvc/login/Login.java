package com.mvc.login;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    	// Set response content type
    	resp.setContentType("text/html");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    	// Set response content type
    	resp.setContentType("text/html");
    	// Actual logic goes here.
        PrintWriter out = resp.getWriter();
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	
    	User user = new User(username, password);
    	
    	if (!user.VerifyUser(user))
    	{
    		out.println("<h1>Login failed!</h1>");
    		return;
    	}
       
    	Cookie userName = new Cookie("username", username);
    	Cookie userPassword = new Cookie("password", password);
    	userName.setMaxAge(60*60*1); 
    	userPassword.setMaxAge(60*60*1); 
    	
    	resp.addCookie( userName );
    	resp.addCookie( userPassword );
    	   
    	
        	out.println("<h1>Log in success</h1>");
        	resp.sendRedirect("index.jsp");
    }

}
