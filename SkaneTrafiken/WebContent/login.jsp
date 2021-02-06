<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="sv">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="style.css" type="text/css">
    <title>Skånetrafiken Busshållplats</title>
    
    
    <style>
    body {
   		 margin: 0 auto; 
 		padding: 0; 
 		text-align: center; 
     }
    </style>
    
  </head>
  <body>
     <div class="d-flex" id="wrapper">

    <!-- Page Content -->
    <div id="page-content-wrapper">
      

      <div class="container-fluid">
        <h1 class="mt-4">SkåneTrafiken Login (admin, admin)</h1>
        <p>Vi kommer använda din position för att hitta närmaste busshållplats</p>
      </div>
      
      <div id="stopcontainer">
      <form action="<%=request.getContextPath()%>/Login"
						method="post">
						
				
	
	  Username: <input name = "username" value = "admin" /><br>
	  Password: <input name = "password" value = "admin" /><br>
					
       <button class="btn btn-primary" type="submit" id="loginbtn">Logga in!</button>
       </form>
      <ol class="stoplist">
      
      </ol>
      </div>
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