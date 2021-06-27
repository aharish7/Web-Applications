<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, com.ah.bean.AccountBean" %>
    <% String email = (String)session.getAttribute("email"); %>
    <% response.setDateHeader("Expires", 0);%>
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% response.setHeader("pragma","no-cache"); %>
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
table,th,td{
	border-collapse: collapse;
	border: 1px solid black;
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
	<div align="center">
		<h1 style="font-family:Alternate Gothic;color:blue">Hi <%=email %></h1>
		<h2 style="font-family:verdena">ALL USERS</h2>
		<table>
			<tr>
				<th><font color="red">First Name</font></th>
				<th><font color="red">Last Name</font></th>
				<th><font color="red">Email</font></th>
				<th><font color="red">Password</font></th>
				<th><font color="red">Birthday</font></th>
				<th><font color="red">Gender</font></th>
				<th><font color="red">Mobile</font></th>
				<th><font color="red">Location</font></th>
				
			</tr>
	<% List<AccountBean> users = (List<AccountBean>)request.getAttribute("users");
			for(AccountBean user: users){%>
			  		<tr>
			  		<td><font color="green"><%=user.getFname() %></font></td>
			  		<td><font color="green"><%=user.getLname() %></font></td>
			  		<td><font color="green"><%=user.getEmail() %></font></td>
			  		<td><font color="green"><%=user.getPassword() %></font></td>
			  		<td><font color="green"><%=user.getBirthday() %></font></td>
			  		<td><font color="green"><%=user.getGender() %></font></td>
			  		<td><font color="green"><%=user.getMobile() %></font></td>
			  		<td><font color="green"><%=user.getLocation() %></font></td>
			  		<td><font color="blue"><a href="delete?email=<%=user.getEmail()%>">Delete</a></font></td>
			  		
			  	</tr>
			  <%}%>
		</table>
	</div>
</body>
</html>