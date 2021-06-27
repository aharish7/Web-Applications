<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% response.setDateHeader("Expires", 0);%>
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% response.setHeader("pragma","no-cache"); %>
	<% String email = (String)session.getAttribute("email"); %>
<!DOCTYPE html>
<html>
<head>
<style>
	body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
   background-color:#D3D3D3;
 }
.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
	<div class="topnav">
  <a class="active" href="index.html">HOME</a>
  <a href="viewusers">VIEW-USERS</a>
  <a href="deleteview">DELETE-USERS</a>
  <a href="logout">LOGOUT</a>
</div>
	<h1 align="center" style="font-family:Alternate Gothic;color:blue">Hi <%=email %></h1>

</body>
</html>