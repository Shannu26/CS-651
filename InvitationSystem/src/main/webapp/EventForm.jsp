<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Invitation System Project</title>
    <link rel="stylesheet" href="./FormHandler.css" />
  </head>
  <body>
    <%
    	if(request.getSession().getAttribute("user-name") == null) {
			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		}
    	String userName = (String) request.getSession().getAttribute("user-name");
    %>
    <h4>Current Logged User: <span><%= userName %></span></h4>
    <h1>Invitation System</h1>
    <div class="form-container">
      <form action="FormHandlerServlet" method="POST" id="event-form">
        <div>
          <label>Event Name:</label>
          <input type="text" id="name" name="event_name" value="" />
        </div>
        <div>
          <label>Event Date:</label>
          <input type="date" id="date" name="event_date" value="" />
        </div>
        <div>
          <label>Event Time:</label>
          <input type="time" id="time" name="event_time" value="" />
        </div>
        <div>
          <label>Event Location:</label>
          <input type="text" id="location" name="event_location" value="" />
        </div>
        <div>
          <label>Event Description:</label>
          <textarea id="description" name="event_description" rows="4" cols="10"></textarea>
        </div>

        <div class="button-container">
          <input type="submit" value="Submit" class="button" />
        </div>
      </form>
    </div>

    <script src="./FormHandler.js"></script>
  </body>
</html>