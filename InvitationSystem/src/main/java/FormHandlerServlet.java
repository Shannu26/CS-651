

import java.io.IOException;
import java.io.PrintWriter;
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
    int numberOfPeopleAttending = 0;
    int numberOfPeopleNotAttending = 0;

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
		String eventName = request.getParameter("event_name");
		String eventDate = request.getParameter("event_date");
		String eventTime = request.getParameter("event_time");
		String eventLocation = request.getParameter("event_location");
		String eventDescription = request.getParameter("event_description");
		String eventAttendance = request.getParameter("attending");
		
		request.setAttribute("event_name", eventName);
		request.setAttribute("event_date", eventDate);
		request.setAttribute("event_time", eventTime);
		request.setAttribute("event_location", eventLocation);
		request.setAttribute("event_description", eventDescription);
		
		if(eventAttendance == null) {
			request.getRequestDispatcher("EventAttendance.jsp").forward(request, response);
		}
		else {
			if(eventAttendance.equals("Attend")) {
				numberOfPeopleAttending += 1;
			}
			else if(eventAttendance.equals("Not Attend")) {
				numberOfPeopleNotAttending += 1;
			}
			request.setAttribute("attending", numberOfPeopleAttending);
			request.setAttribute("not-attending", numberOfPeopleNotAttending);
			request.getRequestDispatcher("EventConfirmation.jsp").forward(request, response);
		}
	}

}
