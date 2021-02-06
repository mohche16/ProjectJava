<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.skanetrafiken.SkaneBusStop" %>
<%@ page import="com.skanetrafiken.SkaneApi" %>
<!DOCTYPE html>
<html lang="sv">
  <head>
  
  	<%
  		 Cookie cookie = null;
         Cookie[] cookies = null;
         
         // Get an array of Cookies associated with the this domain
         cookies = request.getCookies();
        
         String respo = "";
         
         if( cookies != null ) {
            
            for (int i = 0; i < cookies.length; i++) {
               cookie = cookies[i];
               if (cookie.getName().equals("Cookieh"))
            	   respo = cookie.getValue();
              
              
            }
           
            if (!respo.equals("beans"))
            {
         	    	out.println("<h2>Please login!</h2>");
         	    	response.sendRedirect(request.getContextPath() + "/login.jsp");
            		return;
            }
            
         }
        
         
         
  	%>
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="style.css" type="text/css">
    <title>Skånetrafiken Busshållplats</title>
  </head>
  <body>
     <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">Skånetrafiken </div>
      <div class="list-group list-group-flush">
        <a href="index.jsp" class="list-group-item list-group-item-action bg-light">SÖK</a>
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="btn btn-primary" id="menu-toggle">Hem</button>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

 			
      </nav>
      

      <div class="container-fluid">
        <h1 class="mt-4">Hitta närmaste busshållplats</h1>
        <p>Vi kommer använda din position för att hitta närmaste busshållplats</p>
      </div>
      
      <div id="stopcontainer">
      <ol class="stoplist">
      <%
      	SkaneApi apiObj = (SkaneApi) request.getAttribute("apiObj");
      	if (apiObj != null)
      	{
			for (int i = 0; i < apiObj.getStops().size(); i++) {
				out.print("<li>");
				out.print("Id: " + apiObj.getStops().get(i).getId() + " ");
				out.print("Adress: " +apiObj.getStops().get(i).getName() + " ");
				out.print("Long: " +apiObj.getStops().get(i).getLongitude() + " ");
				out.print("Lat: " +apiObj.getStops().get(i).getLatitude() + " ");
				out.print("Distans: " +apiObj.getStops().get(i).getDistance() + " meter");
				out.print("</li>");
			}
      	}
      		
    
      %>

      </ol>
      </div>
      
      <form action="<%=request.getContextPath()%>/SkaneApiServlet"
						method="post">
	  <input  id="xlong" name="xlong" value="Söker!" />
	  <input  id="ylat" name="ylat" value="Söker!" />
	  Radius: <input name="r" value = "500" /><br>
					
       <button class="btn btn-primary" type="submit" id="searchbtn" onClick="return fieldsEmpty()">Sök efter busshållsplats!</button>
       </form>
       <br>
       <br>
        <h5 id="geolabel">GEO Location status: </h5>
    </div>
    <!-- /#page-content-wrapper -->

  </div>
  <!-- /#wrapper -->

<footer class="bg-light text-center text-lg-start">
  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
    © 2021 Copyright:
  </div>
  <!-- Copyright -->
</footer>
  
  
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  	<script src="skane.js"></script>
  </body>
</html>