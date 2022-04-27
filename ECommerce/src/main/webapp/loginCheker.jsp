<%@page import="org.user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="u" class="org.user.User"></jsp:useBean>
<jsp:setProperty  name="u" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<%
	HttpSession hs= request.getSession();
	hs.setAttribute("username",  u.getUsername());
	if(UserDao.checker(u)){
		response.sendRedirect("home.html");
	}
	else{
		response.sendRedirect("loginError.jsp");
	}
	%>
</body>
</html>