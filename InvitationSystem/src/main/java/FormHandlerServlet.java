

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
		if(request.getSession().getAttribute("user-name") == null) {
			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		}
		
		XMLManipulator xml = new XMLManipulator();
		xml.readFromXMLFile();
		
		
		String eventIndex = request.getParameter("event_index");
		String eventCreator = (String) request.getSession().getAttribute("user-name");
		String eventName = request.getParameter("event_name");
		String eventDate = request.getParameter("event_date");
		String eventTime = request.getParameter("event_time");
		String eventLocation = request.getParameter("event_location");
		String eventDescription = request.getParameter("event_description");
		String buttonValue = request.getParameter("button");
		
		ArrayList<HashMap<String, Object>> eventsData = new ArrayList<>();
		if(XMLManipulator.readFromXMLFile() != null) {
			eventsData = XMLManipulator.readFromXMLFile();
		}
		
		if(buttonValue == null) {
			HashMap<String, Object> eventData = new HashMap<String, Object>();
			eventData.put("event-index", Integer.toString(eventsData.size()));
			eventData.put("event-creator", eventCreator);
			eventData.put("event-name", eventName);
			eventData.put("event-date", eventDate);
			eventData.put("event-time", eventTime);
			eventData.put("event-location", eventLocation);
			eventData.put("event-description", eventDescription);
			eventData.put("attend-count", "0");
			eventData.put("not-attend-count", "0");
			
			eventsData.add(eventData);
		}
		else if(buttonValue.equals("Delete")) {
			int index = Integer.parseInt(eventIndex);
			eventsData.remove(index);
		}
		else {
			int index = Integer.parseInt(eventIndex);
			HashMap<String, Object> eventData = eventsData.get(index);
			if(buttonValue.equals("Attend")) eventData.put("attend-count", Integer.toString(Integer.parseInt((String) eventData.get("attend-count")) + 1));
			else eventData.put("not-attend-count", Integer.toString(Integer.parseInt((String) eventData.get("not-attend-count")) + 1));
		}
		
		xml.writeToXMLFile(eventsData);
		
		request.getSession().setAttribute("events-data", eventsData);
		request.getRequestDispatcher("AllEvents").forward(request, response);
	}

}
