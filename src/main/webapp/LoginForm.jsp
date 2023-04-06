<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invitation System</title>
<link rel="stylesheet" href="./FormHandler.css" />
</head>
<body>
<div class="form-container">
      <form action="LoginServlet" method="POST" id="login-form">
        <div>
          <label>User Name:</label>
          <input type="text" id="name" name="user-name" value="" />
        </div>

        <div class="button-container">
          <input type="submit" value="Login" class="button" />
        </div>
      </form>
    </div>
</body>
</html>