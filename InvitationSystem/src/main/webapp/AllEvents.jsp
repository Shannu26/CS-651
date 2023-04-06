<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invitation System</title>
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
	<h1>All Events</h1>
	<a href="LoginServlet">Restart</a>
	<a href="FormHandlerServlet">Add Event</a>
	<div class="events-data">
	<%!
		class EventComparator implements Comparator<HashMap<String, Object>>{
			public int compare(HashMap<String, Object> event1, HashMap<String, Object> event2){
				int value1 = Integer.parseInt((String) event1.get("attend-count"));
				int value2 = Integer.parseInt((String) event2.get("attend-count"));
			
				if(value1 > value2) return -1;
				else if(value1 == value2) return 0;
				return 1;
			}
		}
	%>
	<%
		ArrayList<HashMap<String, Object>> eventsData = new ArrayList<>();
		if(request.getSession().getAttribute("events-data") != null) {
			eventsData = (ArrayList<HashMap<String, Object>>) request.getSession().getAttribute("events-data");
		}
		
		Collections.sort(eventsData, new EventComparator());
			
		for(int i = 0;i < eventsData.size();i++){
			HashMap<String, Object> eventData = eventsData.get(i);
			int eventIndex = Integer.parseInt((String) eventData.get("event-index"));
			String eventName = (String) eventData.get("event-name");
			String eventCreator = (String) eventData.get("event-creator");
			String eventDate = (String) eventData.get("event-date");
			String eventTime = (String) eventData.get("event-time");
			String eventLocation = (String) eventData.get("event-location");
			String eventDescription = (String) eventData.get("event-description");
			int numberOfPeopleAttending = Integer.parseInt((String) eventData.get("attend-count"));
			int numberOfPeopleNotAttending = Integer.parseInt((String) eventData.get("not-attend-count"));
			
			if(eventCreator.equals(userName)) eventCreator = "You";
	%>
	<div class="event-data">
		<form action="FormHandlerServlet" method="POST" id="event-form">
			
			<input type="hidden" name="event_index" value=<%= eventIndex %> id="eventDetails" readonly/>
			<div>
				<label>Created By:</label>
				<input type="text" name="event_name" value=<%= eventCreator %> id="eventDetails" readonly />
			</div>
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
			<%
				if(!eventCreator.equals("You")){
			%>
			<div>
				<input type="submit" value="Attend" class="button" id="green" name="button"/>
				<input type="submit" value="Not Attend" class="button" id="red" name="button"/>
			</div>
			<% } else { %>
			<div>
				<input type="submit" value="Delete" class="button" id="green" name="button"/>
			</div>
			<% } %>
			<div>
				<h4>Number of People Attending: <span><%= numberOfPeopleAttending %></span></h4>
				<h4>Number of People Not Attending: <span><%= numberOfPeopleNotAttending %></span></h4>
			</div>	
		</form>
		
	</div>
	<% } %>
	</div>
</body>
</html>