<%@page import="org.product.ProductDetails"%>
<%@page import="org.product.ProductDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page trimDirectiveWhitespaces="true" %>
<jsp:useBean id="p" class="org.product.ProductDetails"></jsp:useBean>
<jsp:setProperty name="p" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if(ProductDao.save(p)>0){
		out.println("<h1>sucessfully added to database</h1>");
	}
	else{
		response.sendRedirect("saveProductError.jsp");
	}
    %>
</body>
</html>