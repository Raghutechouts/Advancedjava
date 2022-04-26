<%@page import="org.registerpage.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="u" class="org.registerpage.User"/>    
<jsp:setProperty property="*" name="u"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDao d = new UserDao();
		/* if(d.SaveRegisterDetails(u)>0){
			out.println("<h1>Done</h1>");
		} */
		
		out.print(d.saveRegisterDetails(u));
	%>
	
</body>
</html>