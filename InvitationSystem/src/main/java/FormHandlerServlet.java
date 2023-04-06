

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormHandlerServlet
 */
@WebServlet("/FormHandlerServlet")
public class FormHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    ArrayList<HashMap<String, Object>> eventData = new ArrayList<HashMap<String, Object>>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("EventForm.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eventIndex = request.getParameter("event_index");
		String eventCreator = (String) request.getSession().getAttribute("user-name");
		String eventName = request.getParameter("event_name");
		String eventDate = request.getParameter("event_date");
		String eventTime = request.getParameter("event_time");
		String eventLocation = request.getParameter("event_location");
		String eventDescription = request.getParameter("event_description");
		String eventAttendance = request.getParameter("attending");
		
		int numberOfPeopleAttending = 0;
	    int numberOfPeopleNotAttending = 0;
		
		ArrayList<HashMap<String, Object>> eventsData = new ArrayList<>();
		if(request.getSession().getAttribute("events-data") != null) {
			eventsData = (ArrayList<HashMap<String, Object>>) request.getSession().getAttribute("events-data");
		}
		
		if(eventAttendance == null) {
			HashMap<String, Object> eventData = new HashMap<String, Object>();
			eventData.put("event-index", eventsData.size());
			eventData.put("event-creator", eventCreator);
			eventData.put("event-name", eventName);
			eventData.put("event-date", eventDate);
			eventData.put("event-time", eventTime);
			eventData.put("event-location", eventLocation);
			eventData.put("event-description", eventDescription);
			eventData.put("attend-count", 0);
			eventData.put("not-attend-count", 0);
			
			eventsData.add(eventData);
		}
		else {
			int index = Integer.parseInt(eventIndex);
			HashMap<String, Object> eventData = eventsData.get(index);
			if(eventAttendance.equals("Attend")) eventData.put("attend-count", (int) eventData.get("attend-count") + 1);
			else eventData.put("not-attend-count", (int) eventData.get("not-attend-count") + 1);
		}
		
		request.getSession().setAttribute("events-data", eventsData);
		
		request.getRequestDispatcher("AllEvents.jsp").forward(request, response);
	}

}
