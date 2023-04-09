<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map.Entry"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Commerce Cart</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
	<h1>Cart</h1>
	<%
		HashMap<String, Integer[]> cartItems = (HashMap<String, Integer[]>)request.getSession().getAttribute("cart-items");
	%>
	<a href="PurchaseServlet" class="button">Purchase</a>
	<div class="item-container">
		<%
			for(Entry<String, Integer[]> cartItem: cartItems.entrySet()){
		%>
			<form action="CartServlet" method="POST">
				<div>
		          <label>Item Name:</label>
		          <input type="text" name="item-name" value=<%= cartItem.getKey() %> readonly/>
		        </div>
		        <div>
		          <label>Item Price:</label>
		          <input type="text" name="item-price" value=<%= cartItem.getValue()[0] %> readonly/>
		        </div>
		         <div>
		          <label>Item Quantity:</label>
		          <input type="number" name="item-quantity" value=<%= cartItem.getValue()[1] %> readonly/>
		        </div>
				<input type="submit" name="request-type" value="Delete From Cart" class="button red" />
			</form>
		<% } %>
	</div>
</body>
</html>