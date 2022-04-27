<%@page import="org.product.ProductDao"%>
<%@page import="org.product.ProductDetails"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <jsp:useBean id="p" class="org.product.ProductDetails"></jsp:useBean> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="u" class="org.product.ProductDetails"></jsp:useBean>
<jsp:setProperty name="u" property="productCtg" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">

<meta charset="ISO-8859-1">
<title>Mens collections</title>

<style>
body {
	width: 100%;
	background-color: floralwhite;
}

.a {
	padding-top: 24px;
    padding-left: 15px;
    padding-right: 20px;
  
}

.main {
	
	display: flex;
	flex-wrap: wrap;
	padding:100px;
	
}

#shirtsid {
	width: 200px;
	height: 250px;
	border-radius: 15px;
	border-style: double;
}

.buttons {
	width: 200px;
	color: black;
	text-decoration: none;
	font-size: 15px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 15px;
	border-style: double;
}

#buttons {
	width: 100px;
	text-decoration: none;
	font-size: 15px;
	margin: 4px 2px;
	cursor: pointer;
	letter-spacing: .3px;
	color: #1d202e;
	-webkit-transition: left .2s ease-out, width .2s ease-out;
	transition: left .2s ease-out, width .2s ease-out;
	font-weight: 700;
	text-transform: uppercase
}
</style>
</head>

<body>
<header>
    <div class="header">
        <a href= "#" class="logo"> <img src="https://mumbaimirror.indiatimes.com/photo/80601325.cms" alt="logo" ></a>
        <ul class="header-left">
            <li><button id="buttons"> <a style="color: black;text-align: center; padding: 12px;
                text-decoration: none;" href="productPlp.jsp?cat=men">Men</a></button></li>
            <li><button id="buttons"> <a style="color: black;text-align: center; padding: 12px;
                text-decoration: none;" href="productPlp.jsp?cat=women">Women</a></button></li>
            <li><button id="buttons" > <a style="color: black;text-align: center; padding: 12px;
                text-decoration: none;" href="productPlp.jsp?cat=kids">Kids</a></button></li>
            <li><button id="buttons"><a style="color: black;text-align: center; padding: 12px;
                text-decoration: none;" href="Home&Living">Home</a></button></li>
            <li><button id="buttons"><a style="color: black;text-align: center; padding: 12px;
                text-decoration: none;" href="Beauty">Beauty</a></button></li>
            <li><button id="buttons"><a style="color: black;text-align: center; padding: 12px;
                text-decoration: none;" href="Studio">Studio</a></button></li>
        </ul>
        <div class="header-center">
             <input type="text" id="fname" name="fname" placeholder="search for brands">
        </div>
        <ul class="header-right">
         <a style="color: black;text-align: center; padding: 12px;
            text-decoration: none;" href="home.html"  >
               <span>Home</span></a>
            <a style="color: black;text-align: center; padding: 12px;
            text-decoration: none;" href="#"  >
               <span>Profile</span></a>
            <a style="color: black;text-align: center; padding: 12px;
            text-decoration: none;" href="showCartDetails.jsp"  >
               <span>Cart</span></a>
            <a style="color: black;text-align: center; padding: 12px;
            text-decoration: none;" href="logout.jsp" >
               <span>Logout</span></a>      
            </ul>
    </div>
    
</header><br><br><br><br><br><br>
	<%
	String cat = request.getParameter("cat");
	List<ProductDetails> list = ProductDao.getProductData(cat);
	request.setAttribute("mylist", list);
	%>
	
	<div class="main">
		<c:forEach items="${mylist}" var="data">
				
			<div class="a">
				<a href="productPdp.jsp?name=${data.getProductName()}"><img id="shirtsid" alt="image" src="${data.getUrl()}"></a>
				<div style="text-align: center;font-weight: 700">
					<p>Price: ${data.getPrice()}</p>
					<p>Product Name: ${data.getProductName()}</p>
				</div>
				<div style="display: grid;">
					<button class="buttons" type="button">
						<a  style="color: black; text-align: center; padding: 12px; text-decoration: none" href="addtocart.jsp?name=${data.getProductName()}">BUY NOW</a>
					</button>
					<button class="buttons" type="button">
						<a  style="color: black; text-align: center; padding: 12px; text-decoration: none" href="addtocart.jsp?name=${data.getProductName()}">ADD TO CART</a>
					</button>
				</div>
			</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </c:forEach>
	</div>

</body>
</html>