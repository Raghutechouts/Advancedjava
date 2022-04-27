<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Orders Details</title>
<link rel="stylesheet" href="styles.css">
<style type="text/css">
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
<body style="background-color: floralwhite">
	<header>
		<div class="header">
			<a href="#" class="logo"> <img
				src="https://mumbaimirror.indiatimes.com/photo/80601325.cms"
				alt="logo"></a>
			<ul class="header-left">
				<li><button id="buttons">
						<a
							style="color: black; text-align: center; padding: 12px; text-decoration: none;"
							href="productPlp.jsp?cat=men">Men</a>
					</button></li>
				<li><button id="buttons">
						<a
							style="color: black; text-align: center; padding: 12px; text-decoration: none;"
							href="productPlp.jsp?cat=women">Women</a>
					</button></li>
				<li><button id="buttons">
						<a
							style="color: black; text-align: center; padding: 12px; text-decoration: none;"
							href="productPlp.jsp?cat=kids">Kids</a>
					</button></li>
				<li><button id="buttons">
						<a
							style="color: black; text-align: center; padding: 12px; text-decoration: none;"
							href="Home&Living">Home</a>
					</button></li>
				<li><button id="buttons">
						<a
							style="color: black; text-align: center; padding: 12px; text-decoration: none;"
							href="Beauty">Beauty</a>
					</button></li>
				<li><button id="buttons">
						<a
							style="color: black; text-align: center; padding: 12px; text-decoration: none;"
							href="Studio">Studio</a>
					</button></li>
			</ul>
			<div class="header-center">
				<input type="text" id="fname" name="fname"
					placeholder="search for brands">
			</div>
			<ul class="header-right">
				<a
					style="color: black; text-align: center; padding: 12px; text-decoration: none;"
					href="#"> <span>Profile</span></a>
				<a
					style="color: black; text-align: center; padding: 12px; text-decoration: none;"
					href="showCartDetails.jsp"> <span>Cart</span></a>
				<a
					style="color: black; text-align: center; padding: 12px; text-decoration: none;"
					href="logout.jsp"> <span>Logout</span></a>
			</ul>
		</div>

	</header>
	<div style="padding: 250px;background-color: aqua;">
		<h3>Your Orders List is Empty</h3>
		<a href="home.html">Click here for HOME page</a>
	</div>
</body>
</html>