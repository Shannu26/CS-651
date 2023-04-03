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
		String eventName = (String)request.getAttribute("event_name");
		String eventDate = (String)request.getAttribute("event_date");
		String eventTime = (String)request.getAttribute("event_time");
		String eventLocation = (String)request.getAttribute("event_location");
		String eventDescription = (String)request.getAttribute("event_description");
		Integer numberOfPeopleAttending = (Integer)request.getAttribute("attending");
		Integer numberOfPeopleNotAttending = (Integer)request.getAttribute("not-attending");
	%>
	<h1>Event Details</h1>
	<div class="form-container">
		<form action="FormHandlerServlet" method="POST" id="event-form">
			<div>
				<label>Event Name:</label>
				<input type="text" name="event_name" value=<%= eventName %> id="eventDetails" readonly />
			</div>
			<div>
				<label>Event Date:</label>
				<input type="date" name="event_date" value=<%= eventDate %> id="eventDetails" readonly />
			</div>
			<div>
				<label>Event Time:</label>
				<input type="time" name="event_time" value=<%= eventTime %> id="eventDetails" readonly />
			</div>
			<div>
				<label>Event Location:</label>
				<input type="text" name="event_location" value=<%= eventLocation %> id="eventDetails" readonly />
			</div>
			<div>
				<label>Event Description:</label>
				<textarea name="event_description" rows="4" cols="10" id="eventDetails" readonly><%= eventDescription %></textarea>
			</div>
			<div>
				<input type="submit" value="Attend" class="button" id="attending" name="attending"/>
				<input type="submit" value="Not Attend" class="button" id="not-attending" name="attending"/>
			</div>
		</form>
		<h4>Number of People Attending: <span><%= numberOfPeopleAttending %></span></h4>
		<h4>Number of People Not Attending: <span><%= numberOfPeopleNotAttending %></span></h4>
		<a href="EventForm.jsp">Restart</a>
	</div>
</body>
</html>