<%@ include file = "header.jsp" %>

<% 
String first_name = request.getParameter("first_name");
String last_name = request.getParameter("last_name");
%>

<h1><%= first_name %></h1>
<h1><%= last_name %></h1>
<%@ include file = "footer.jsp" %>