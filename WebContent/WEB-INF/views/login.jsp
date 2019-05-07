<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Login Page</h1>
<form:form action="loginchk" method="get" modelAttribute="register">
Roll_No:<input type="text" name="rollno"><br><br>
Password:<input type="password" name="pwd"><br><br>
<input type="submit" value="LOGIN">
</form:form>
</center>
</body>
</html>