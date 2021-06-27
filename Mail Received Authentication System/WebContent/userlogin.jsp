<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% response.setDateHeader("Expires", 0);%>
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
</style>
<script type="text/javascript">
	function validate(){
		var e = document.forms["f1"]["email"].value;
		var p = document.forms["f1"]["password"].value;
		
		if(e.indexOf("@gmail", 0) < 0){
			alter("Please enter valid Email Id. Like @gmail.com");
			document.forms["f1"]["email"].focus();
			return false;
		}
		if(e.indexOf(".", e.indexOf("@gmail")) < 0){
			alter("Please enter valid Email Id. Like @gmail.com")
			document.forms["f1"]["email"].focus();
			return false;
		}
		if(p.length < 6){
			alter("Password must have more than 6 characters");
			document.forms["f1"]["password"].focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="topnav">
		<a class="active" href="index.html">HOME</a>
		<a href="newaccount.jsp">CREATE-ACCOUNT</a>
		<a href="userlogin.jsp">LOGIN</a>
		<a href="adminlogin.jsp">ADMIN</a>
	</div>
	
	<div align="center" style="padding-left:16px">
	
		<% String msg = (String)request.getAttribute("msg"); 
		if(msg != null){%>
		<h3 style="font-family:verdana;"><%= msg %></h3>
		<%}else{ %>
		<h3 style="font-family:verdana;">USER LOGIN</h3>
		<%} %>
		
		<form name="f1" onsubmit="return validate()" action="userlogin" method="post">
			<table style="border-collapse:collapse;border:0">
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" placeholder="enter email id" required value="" ></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" placeholder="enter password" required value=""><br></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" value="Login" />
				</tr>
			</table>
		</form>
		
	</div>
	
</body>
</html>