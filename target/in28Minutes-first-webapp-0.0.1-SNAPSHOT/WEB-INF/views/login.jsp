<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Login from JSP!!</br>
	Paramater1: ${name} </br>
	Paramater1: ${password}
	<form action="/login.do" method="post">
		Enter name: <input type="text" name="name">
		Enter password: <input type="password" name="password">
		<input type="submit" value="login">
	</form>
</body>
</html>