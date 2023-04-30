<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="calculatorBean.Calculator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<h2>Calculator</h2>
<jsp:useBean id = "calculatorBean" class = "calculatorBean.Calculator"> </jsp:useBean>
<jsp:setProperty property = "*" name = "calculatorBean"/>
<% calculatorBean.calculate(); %>
<div class="container">
  <form action = "calculator.jsp" method = "post">
  	<label for="first_num">First number: </label>
    <input type = "text" name = "first_num" />
	<label for="mathOperator">Math Operation: </label>
	<select name = "mathOperator">
		<option value = "subtraction"> Subtraction </option>
	    <option value = "division"> Division </option>
	    <option value = "multiplication"> Multiplication </option>
	    <option value = "addition"> Addition </option>
	</select>
	<label for="second_num">Second number: </label>
	<input type="text" name="second_num"/>
    <button name="calc" type="submit">Calculate</button>
	</form>
	<p>
	Result of:
	<jsp:getProperty property = "first_num" name = "calculatorBean"/>
	<jsp:getProperty property = "mathOperator" name = "calculatorBean"/>
	<jsp:getProperty property = "second_num" name = "calculatorBean"/>
	= <jsp:getProperty property = "result" name = "calculatorBean"/>
	</p>
</div>
</body>
</html>