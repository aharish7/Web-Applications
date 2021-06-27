<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ah.bean.MailBean" %>
    <% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% response.setDateHeader("Expires", 0);%>
	<% response.setHeader("pragma","no-cache"); %>
<!DOCTYPE html>
<html>
<head>
<style>
	body{
		background-color:#D3D3D3;
	}	
	.content{
		width: 550px;
		height: 400px;
		margin-left: 150px;
		margin-top : 10px;
		background-color: white;
	}
	.backbutton{
		margin-left: 150px;
		margin-top: 40px;
		background-color: blue;
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
			<tr><td><a href="compose.jsp">COMPOSE MAIL</a></td></tr>
			<tr><td><a href="inbox">INBOX</a></td></tr>
			<tr><td><a href="sentmails">SENT MAILS</a></td></tr>
			<tr><td><a href="allmails">ALL MAILS</a></td></tr>
			<tr><td><a href="logout">LOGOUT</a></td></tr>
		</table>
	</div>
	<div class="rightpane">
		<h2 align="center" style="font-family:verdena">MAIL CONTENT</h2>
			<% MailBean bean = (MailBean)request.getAttribute("mailBean");%>
			<button class="backbutton" type="button" value="back" onclick="history.back()">back</button>
		<div class="content">
			<p align="left"><%=bean.getSubject()%></p>
			<p align="right"><%=bean.getTime() %></p>
			<p align="left">From: <%=bean.getSendFrom() %></p><br>
			<p align="left"><%=bean.getBody() %></p>
		</div>
	</div>
</body>
</html>
		