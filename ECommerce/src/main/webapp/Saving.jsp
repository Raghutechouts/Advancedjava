<%@page import="org.user.UserDao"%>
<%@page import="org.user.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page trimDirectiveWhitespaces="true" %>
<jsp:useBean id="u" class="org.user.User"></jsp:useBean>
<jsp:setProperty name="u" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

	<%
	if(UserDao.save(u)>0){
		response.sendRedirect("saveSuceess.jsp");
	}
	else{
		response.sendRedirect("saveError.jsp");
	}
    %>
</body>
</html>
