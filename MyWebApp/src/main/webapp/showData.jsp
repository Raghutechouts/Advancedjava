<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.registerpage.UserDao"%>
<%@page import="org.registerpage.User"%>

<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDao d = new UserDao();
		List<User> list = d.showRegisterDetails() ;
	%>
</body>
</html>