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
		var email = document.forms["reg"]["email"].value;
		var pass = document.forms["reg"]["password"].value;
		var cpass = document.forms["reg"]["cpassword"].value;
		var gender = document.forms["reg"]["gender"].value;
		var mobile = document.forms["reg"]["mobile"].value;
		var loc = document.forms["reg"]["location"].value;
		
		if(email.indexOf("@gmail",0) < 0){
			alert("Please enter valid email. like @gmail");
			document.forms["reg"]["email"].focus();
			return false;
		}
		if(email.indexOf(".",email.indexOf("@gmail")) < 0){
			alert("Please enter valid email address. like @gmail.com");
			documnet.forms["reg"]["email"].focus();
			return false;
		}
		if(pass.length < 6){
			alert("Password must be between 6 to 20 characters");
			document.forms["reg"]["password"].focus();
			return false;
		}
		if(pass != cpass){
			alert("password and conform password must match");
			document.forms["reg"]["password"].focus();
			return false;
		}
		if(gender == 0){
			alert("Please select gender");
			document.forms["reg"]["gender"].focus();
			return false;
		}
		if(mobile.length != 10){
			alert("Mobile number must be 10 digits")
			document.forms["reg"]["mobile"].focus();
			return false;
		}
		if(isNaN(mobile)){
			alert("Mobile number must be a number");
			document.forms["reg"]["mobile"].focus();
			return false;
		}
		if(loc == null){
			alert("Please enter Location.")
			document.forms["reg"]["location"].focus();
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

	<div align="center" style="padding-left: 16px">
	
	<% String msg = (String)request.getAttribute("msg");
		if(msg != null){%>
			<h2 style="font-family:verdana;"> <%=msg%> </h2> 
		<%}else{%>
			<h2 style="font-family:verdana;">Create new Account</h2>
		<%}%>
		<form name="reg" onsubmit="return validate()" action="create" method="post">
			<table style="border-collapse:collapse;border:0" >
				<tr>
					<td>
						<p>First Name</p>
					</td>
					<td><input type="text" name="fname" size="30" required
						placeholder="enter your first name" /></td>
				</tr>
				<tr>
					<td>
						<p>Last Name</p>
					</td>
					<td><input type="text" name="lname" size="30" required
						placeholder="enter your last name" /></td>
				</tr>
				<tr>
					<td>
						<p>Email Id</p>
					</td>
					<td><input type="text" name="email" size="30" required
						placeholder="enter email id" /></td>
				</tr>
				<tr>
					<td>
						<p>Choose Password</p>
					</td>
					<td><input type="Password" name="password" size="30" required
						placeholder="enter password" /></td>
				</tr>
				<tr>
					<td>
						<p>Conform Password</p>
					</td>
					<td><input type="password" name="cpassword" size="30" required
						placeholder="enter password" /></td>
				</tr>
				<tr>
					<td>
						<p>Birthday</p>
					</td>
					<td><input type="date" name="birthday" size="30" required
						placeholder="enter your date of birth" /></td>
				</tr>
				<tr>
					<td>
						<p>Gender</p>
					</td>
					<td><select name="gender">
							<option value="0">------select-----</option>
							<option value="male">male</option>
							<option value="female">female</option>
							<option value="other">other</option>
					</select></td>
				</tr>
				<tr>
					<td>
						<p>Mobile Number</p>
					</td>
					<td><input type="text" name="mobile" size="30" required
						placeholder="enter your mobile number" /></td>
				</tr>
				<tr>
					<td>
						<p>Location</p>
					</td>
					<td><input type="text" name="location" size="30" required
						placeholder="enter your location" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="create" /></td>
					<td><input type="reset" value="reset" /></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>
