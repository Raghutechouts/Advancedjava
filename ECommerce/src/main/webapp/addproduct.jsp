<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product here</title>
<style type="text/css">
#reg {
	background-color: white; margin-left : 500px;
	margin-right: 500px;
	margin-top: 200px;
	padding: 30px;
	border: 3px solid black;
	text-align: center;
	border-radius: 10px;
	margin-left: 500px;
}
</style>
</head>
<bodystyle="background-color: floralwhite;">
	<div id="reg">
		<h2>Please Enter Your Product Details</h2>
		<form action="SaveProduct.jsp" method="post">
		
				Enter Product Name:<input type="text"name="productName" required="required"><br> <br> 
				Enter Product Description: <input  type="text" name="productDesc"required="required" ><br> <br> 
				Enter Product Price:<input type="text"name="price" required="required"><br> <br> 
				Enter Product Url:  <input type="text"name="url" required="required"><br> <br> 
				Enter Product category:<input type="radio"  name="productCtg" value="men"> Men</input><input type="radio"  name="productCtg" value="women"> Women</input>
				<input type="radio"  name="productCtg" value="kids">Kids</input><br> <br>
				<input type="submit"value="Add Product" style="border-radius: 10px;color:black;"><br> <br>
				
		</form>
	</div>
</body>
</html>