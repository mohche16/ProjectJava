package com.skanetrafiken;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class Vector {
	float x, y, r;
}

public class SkaneApiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    	// Set response content type
    	resp.setContentType("text/html");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    	//SkaneApi object
    	SkaneApi api = new SkaneApi();
    	
    	// 3 floats x, y and radius vector
    	Vector coords = new Vector();
    	coords.x = Float.parseFloat(req.getParameter("xlong"));
    	coords.y = Float.parseFloat(req.getParameter("ylat"));
    	coords.r = Float.parseFloat(req.getParameter("r"));
    	
    	//set buslist arraylist
    	api.getNearestStation(coords.x, coords.y, coords.r);
    	//Remove dupes due to parser issues?
    	api.removeDuplicates(api.getStops());
    	
    	// add it into the info to send to the jsp
    	req.setAttribute("apiObj", api);

    			
    	RequestDispatcher rd = req.getRequestDispatcher("index.jsp");

    	rd.forward(req, resp);

    }

}