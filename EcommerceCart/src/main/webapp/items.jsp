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
	<h1>All Items</h1>
	<%
		HashMap<String, Integer> items = (HashMap<String, Integer>)request.getSession().getAttribute("items");
	%>
	<div class="item-container">
		<%
			for(Entry<String, Integer> item: items.entrySet()){
		%>
			<form action="CartServlet" method="POST">
				<div>
		          <label>Item Name:</label>
		          <input type="text" name="item-name" value=<%= item.getKey() %> readonly/>
		        </div>
		        <div>
		          <label>Item Price:</label>
		          <input type="text" name="item-price" value=<%= item.getValue() %> readonly/>
		        </div>
		         <div>
		          <label>Item Quantity:</label>
		          <input type="number" name="item-quantity" required/>
		        </div>
				<input type="submit" name="request-type" value="Add To Cart" class="button" />
			</form>
		<% } %>
	</div>
</body>
</html>