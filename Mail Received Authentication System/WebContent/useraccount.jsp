<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% response.setDateHeader("Expires", 0);%>
	<% response.setHeader("pragma","no-cache"); %>
<!DOCTYPE html >
<html>
<head>
<style>
body{
		background-color:#D3D3D3;
	}
	
.leftpane{
		width:200px;
		height: 1000px;
		float: left;	
		position: fixed;
	}
	.rightpane{
		width: 800px;
		height: 1000px;
		margin-left: 150px;
		position: fixed;
	}
	table.tab1{
	width: 150px;
	height: 200px;
	margin-top: 140px;
	margin-left: 30px;
}
	table.tab2{
		width: 800px;
		margin-left:100px;
		margin-top: 15px;
		position: fixed;
	}
	table,td,th{
		border-collapse: collapse;
		border: 1px solid black;
	}
	th,td{
		padding: 10px;
	}
	
table.tab1 {
	overflow: hidden;
	background-color: #1C3F60;
}

table.tab1 a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	font-size: 14px;
}

table.tab1 a:hover {
	background-color: #ddd;
	color: black;
}

table.tab1 a:active {
	background-color: #04AA6D;
	color: white;
}

</style>
</head>
<body>

	<div class="leftpane">
		<table class="tab1">
			<tr><td><a  href="compose.jsp">COMPOSE MAIL</a></td></tr>
			<tr><td><a  href="inbox">INBOX</a></td></tr>
			<tr><td><a  href="sentmails">SENT MAILS</a></td></tr>
			<tr><td><a  href="allmails">ALL MAILS</a></td></tr>
			<tr><td><a  href="logout">LOGOUT</a></td></tr>
		</table>
		<%String msg = (String)request.getAttribute("msg");
		  if(msg != null){%>
		  	<h3 style="font-family:verdena margin-left:20px color:green"><%=msg %></h3>
		  <%} %>
	</div>
	<div align="center" class="rightpane">
		<h1 style="font-family:verdena;color:blue">Hi, <%=session.getAttribute("email")%></h1>
			
	</div>
	
	</body>
</html>