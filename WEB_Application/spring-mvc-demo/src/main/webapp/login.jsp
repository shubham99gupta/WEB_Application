<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${msg }</h2>
	<form action="login" method="post">
		<input  type="tel" name="phone" placeholder="enter your phone number"><br>
		<input  type="password" name="password" placeholder="enter your password"><br> 
		<input	type="submit" value="login">
	</form>
	<h2>
	<a href="register.jsp">click here to register</a>
	</h2>
</body>
</html>