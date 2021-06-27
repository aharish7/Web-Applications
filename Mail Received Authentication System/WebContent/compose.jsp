<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% response.setDateHeader("Expires", 0);%>
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% response.setHeader("pragma","no-cache"); %>
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
		border: 0;
	}
	table.tab1,td.tab1,th.tab1{
		border-collapse: collapse;
		border: 1px solid black;
		padding: 10px;
	}
</style>
<script>
	function validate(){
		String a = document.forms["compose"]["sendto"].value;
		String b = document.forms["compose"]["subject"].value;
		String c = document.forms["compose"]["body"].value;
		
		if(a.indexOf("@gmail", 0) < 0){
			alter("Please enter valid Email Id. like @gmail.com");
			document.forms["compose"]["sendto"].focus();
			return false;
		}
		if(a.indexOf(".", indexOf("@gmail", 0)) < 0){
			alter("Please enter valid Email Id. like @gmail.com");
			document.forms["compose"]["sendto"].focus();
			return false;
		}
		if(b == null){
			alter("Please enter Subject..!");
			document.forms["compose"]["subject"].focus();
			return false;
		}
		if(c == null){
			alter("Please enter Body..!");
			document.forms["compose"]["body"].focus();
			return false;
		}
		return true;
	}
</script>

</head>
<body>
	
	<div class="leftpane">
		<table class="tab1">
			<tr><td class="tab1"><a href="compose.jsp">COMPOSE MAIL</a></td></tr>
			<tr><td class="tab1"><a href="inbox">INBOX</a></td></tr>
			<tr><td class="tab1"><a href="sentmails">SENT MAILS</a></td></tr>
			<tr><td class="tab1"><a href="allmails">ALL MAILS</a></td></tr>
			<tr><td class="tab1"><a href="logout">LOGOUT</a></td></tr>
		</table>
	</div>
	<div align= "center" class="rightpane">
		<h1 style="font-family:verdena;color:blue;">Hi, <%=session.getAttribute("email") %></h1>
		<h3 style="font-family:verdena;">COMPOSE MAIL</h3>
		<form name="compose" onsubmit="return validate()" action="compose" method="post">
			<table class="tab2">
				<tr>
					<td><b>SEND TO:</b></td>
					<td><input type="text" name="sendto" size="30" required /></td>
				</tr>
				<tr>
					<td><b>SUBJECT:</b></td>
					<td><input type="text" name="subject" size="30" required /></td>
				</tr>
				<tr>
					<td><b>BODY</b></td>
					<td><textarea name="body" rows="20" cols="70"></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="SEND"></td>
					<td><input type="reset" value="RESET"></td>
				</tr>
			</table>
		</form>
		
	</div>

</body>
</html>