<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, com.ah.bean.MailBean" %>
    <% response.setDateHeader("Expires", 0);%>
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% response.setHeader("pragma","no-cache"); %>
	<% String email = (String)session.getAttribute("email"); %>
<!DOCTYPE html>
<html>
<head>
<style>
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
	<div align="center" class="rightpane">
		
		<h1 style="font-family:verdena;color:blue">Hi, <%=email %></h1>
		<h2 style="font-family:verdena">ALL MAILS</h2>
		<table class="tab2">
			<tr>
				<th><font color="red">FROM</font></th>
				<th><font color="red">TO</font></th>
				<th><font color="red">SUBJECT</font></th>
				<th><font color="red">BODY</font></th>
				<th><font color="red">TIME</font></th>
				<th><font color="red">VIEWED-TIME</font></th>
			</tr>
			<% Set<MailBean> mailList = (Set<MailBean>)request.getAttribute("mailList");
			Iterator<MailBean> iter = mailList.iterator();
			while(iter.hasNext()){ 
			  	MailBean bean = (MailBean)iter.next(); %>
			  		<tr>
			  		<%if(bean.getSendFrom().equals(email)){%>
			  		<td><font color="green">me</font></td>
			  		<%}else{%>
			  		<td><font color="green"><%=bean.getSendFrom() %></font></td>
			  		<%}%>
			  		<%if(bean.getSendTo().equals(email)){%>
			  		<td><font color="green">me</font></td>
			  		<%}else{%>
			  		<td><font color="green"><%=bean.getSendTo() %></font></td>
			  		<%}%>
			  		<td><font color="green"><%if(bean.getSubject().length()>10){%><%= bean.getSubject().substring(0,10)+"..." %><%}else{%> <%= bean.getSubject() %><%} %></font></td>
			  		<td><font color="green"><%if(bean.getBody().length()>10){%><%= bean.getBody().substring(0,10)+"..." %><%}else{%> <%= bean.getBody() %><%} %></font></td>
			  		<td><font color="green"><%=bean.getTime() %></font></td>
			  		<td><font color="blue"><%=bean.getStatus()%></font></td>
			  		<td><a href="viewmail?sendfrom=<%=bean.getSendFrom()%>&
						sendto=<%= bean.getSendTo()%>&time=<%=bean.getTime()%>&
						subject=<%=bean.getSubject()%>&body=<%=bean.getBody()%>&status=<%=bean.getStatus()%>">view</a></td>
						<td><a href="deletemail?sendto=<%=bean.getSendTo()%>&
													time=<%=bean.getTime()%>">Delete</a></td>
			  	</tr>
			  <%}%>
		</table>
	</div>
</body>
</html>