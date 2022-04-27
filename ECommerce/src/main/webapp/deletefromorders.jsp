<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.addtocart.CartDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession hs = request.getSession();
	String username = (String) hs.getAttribute("username");
	System.out.println(username);
	String productName = request.getParameter("name");
	if (CartDao.deleteFromOrders(productName, username) > 0) {
		response.sendRedirect("deletesuccess.jsp");
	}
	%>
</body>
</html>