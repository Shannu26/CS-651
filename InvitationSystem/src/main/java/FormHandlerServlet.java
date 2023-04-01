

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
		response.sendRedirect("FormHandler.html");
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
		
		PrintWriter out = response.getWriter();
		if(eventAttendance == null) {
			out.print("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "  <head>\n"
					+ "    <meta charset=\"UTF-8\" />\n"
					+ "    <title>Invitation System Project</title>\n"
					+ "    <link rel=\"stylesheet\" href=\"./FormHandler.css\" />\n"
					+ "  </head>\n"
					+ "  <body>\n"
					+ "    <h1>Event Details</h1>\n"
					+ "    <div class=\"form-container\">\n"
					+ "      <form action=\"FormHandlerServlet\" method=\"POST\" id=\"event-form\">\n"
					+ "        <div>\n"
					+ "          <label>Event Name:</label>"
					+ "          <p id=\"eventDetails\">" + eventName + "</p>"
					+ "        </div>\n"
					+ "        <div>\n"
					+ "          <label>Event Date:</label>"
					+ "          <p id=\"eventDetails\">" + eventDate + "</p>"
					+ "        </div>\n"
					+ "        <div>\n"
					+ "          <label>Event Time:</label>"
					+ "          <p id=\"eventDetails\">" + eventTime + "</p>"
					+ "        </div>\n"
					+ "        <div>\n"
					+ "          <label>Event Location:</label>"
					+ "          <p id=\"eventDetails\">" + eventLocation + "</p>"
					+ "        </div>\n"
					+ "        <div>\n"
					+ "          <label>Event Description:</label>"
					+ "          <p id=\"eventDetails\">" + eventDescription + "</p>"
					+ "        </div>\n"
					+ "\n"
					+ "		   <div>\n"
					+ "          <input type=\"submit\" value=\"Attend\" class=\"button\" name=\"attending\"/>\n"
					+ "          <input type=\"submit\" value=\"Not Attend\" class=\"button\" name=\"attending\"/>\n"
					+ "        </div>"
					+ "      </form>\n"
					+ "    </div>\n"
					+ "\n"
					+ "    <script src=\"./FormHandler.js\"></script>\n"
					+ "  </body>\n"
					+ "</html>\n"
					+ "");
		}
		else {
			if(eventAttendance.equals("Attend")) {
				numberOfPeopleAttending += 1;
			}
			else if(eventAttendance.equals("Not Attend")) {
				numberOfPeopleNotAttending += 1;
			}
			out.println(numberOfPeopleAttending);
			out.println(numberOfPeopleNotAttending);
		}
		
		out.close();
		out.flush();
	}

}
