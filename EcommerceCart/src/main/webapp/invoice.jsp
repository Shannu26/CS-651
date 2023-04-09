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
	<h1>Your order has been placed... Thank You.</h1>
	<h2>Here's your order invoice</h2>
	<%
		HashMap<String, Integer[]> orderItems = (HashMap<String, Integer[]>)request.getSession().getAttribute("order-items");
		int totalPrice = 0;
	%>
	<div class="invoice">
		<table>
			<%
				for(Entry<String, Integer[]> orderItem: orderItems.entrySet()){
			%>
			<tr>
				<td><%= orderItem.getKey() %></td>
				<td><%= orderItem.getValue()[1] %>x <%= orderItem.getValue()[0] %>$ =</td>
				<td><%= orderItem.getValue()[0] * orderItem.getValue()[1] %>$</td>
				<% totalPrice += orderItem.getValue()[0] * orderItem.getValue()[1]; %>
			</tr>
			<% } %>
		</table>
		<p>---------------------------------</p>
		<p>Total: <%= totalPrice %>$</p>
		<p>Tax: 15% x <%= totalPrice %>$ = <%= 0.15 * totalPrice %>$</p>
		<p>---------------------------------</p>
		<p>Grand Total: <%= totalPrice + 0.15 * totalPrice %>$</p>
		
		<a href="ItemsServlet" class="button">Shop More</a>
	</div>
</body>
</html>