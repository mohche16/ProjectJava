<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.mvc.login.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%
         Cookie cookie = null;
         Cookie[] cookies = null;
         
         // Get an array of Cookies associated with the this domain
         cookies = request.getCookies();
         String username = "";
         String password = "";
         String motdParam = "";
         User user = new User("", "");
         
         
         if( cookies != null ) {
            
            for (int i = 0; i < cookies.length; i++) {
               cookie = cookies[i];
               if (cookie.getName().equals("username"))
            	   username = cookie.getValue();
               
               if (cookie.getName().equals("password"))
            	   password = cookie.getValue();
              
            }
            user = new User(username, password);
            if (!user.VerifyUser(user))
            {
         	    out.println("<h2>Please login!</h2>");
            		return;
            }
            
         }
        
       	
         motdParam = request.getParameter("motd");
         if (motdParam != null )
         {
        	 user.setMotd(motdParam);
         }
         
         
         
         out.println("You are logged in as: " + username + "<br>");
         
      	 //Valid user
         out.println(user.getMotd());
         
      %>
      
       <form action = "index.jsp" method = "POST">
        New Message of the day: <input type = "text" name = "motd">
         <input type = "submit" value = "Submit" />
      </form>
</head>
<body>

</body>
</html>