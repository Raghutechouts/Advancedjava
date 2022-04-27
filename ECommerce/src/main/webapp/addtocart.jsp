<%@page import="org.addtocart.CartDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	String name = request.getParameter("name");
	if (CartDao.saveAddToCart(name, username) > 0) {
		response.sendRedirect("addedToCartSuccess.jsp");
	};
	%>
</body>
</html>