package com.skanetrafiken;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SkaneLoginServlet extends HttpServlet {
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
    	
    	//Remove cookies in case you need to login again, index.jsp saves cookies
    	Cookie killMyCookie = new Cookie("Cookieh", "beans");
    	 killMyCookie.setMaxAge(0);
         resp.addCookie(killMyCookie);
         
         
         
        
    	
    	if (username.equals("admin") && password.equals("admin"))
    	{
    		
       
    	Cookie beanCookie = new Cookie("Cookieh", "beans");
    	beanCookie.setMaxAge(60*60*1); 
    	
    	resp.addCookie( beanCookie );
    	   
    	
        	out.println("<h1>Log in success</h1>");
        	resp.sendRedirect("index.jsp");
    	}
    	else {
    		out.println("<h2>Login failed</h2>");
    		resp.sendRedirect("login.jsp");
    	}
    }
}
