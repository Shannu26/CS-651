

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
				+ "          <p id=\"eventDetails\">" + eventName + "</p>\n"
				+ "			 <input type=\"text\" name=\"event_name\" value=" + eventName + " hidden />\n"	
				+ "        </div>\n"
				+ "        <div>\n"
				+ "          <label>Event Date:</label>"
				+ "          <p id=\"eventDetails\">" + eventDate + "</p>\n"
				+ "			 <input type=\"date\" name=\"event_date\" value=" + eventDate + " hidden />\n"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "          <label>Event Time:</label>"
				+ "          <p id=\"eventDetails\">" + eventTime + "</p>\n"
				+ "			 <input type=\"time\" name=\"event_time\" value=" + eventTime + " hidden />\n"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "          <label>Event Location:</label>"
				+ "          <p id=\"eventDetails\">" + eventLocation + "</p>\n"
				+ "			 <input type=\"text\" name=\"event_location\" value=" + eventLocation + " hidden />\n"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "          <label>Event Description:</label>"
				+ "          <p id=\"eventDetails\">" + eventDescription + "</p>\n"
				+ "			 <textarea name=\"event_description\" hidden>" + eventDescription + "</textarea>\n"
				+ "        </div>\n"
				+ "\n"
				);
		
		if(eventAttendance == null) {
			out.print(
					"		   <div>\n"
					+ "          <input type=\"submit\" value=\"Attend\" class=\"button\" name=\"attending\"/>\n"
					+ "          <input type=\"submit\" value=\"Not Attend\" class=\"button\" name=\"attending\"/>\n"
					+ "        </div>\n"
					+ "      </form>\n"
					+ "    </div>\n"
					+ "\n"
					+ "  </body>\n"
					+ "</html>\n"
					+ ""
					);
		}
		else {
			if(eventAttendance.equals("Attend")) {
				numberOfPeopleAttending += 1;
			}
			else if(eventAttendance.equals("Not Attend")) {
				numberOfPeopleNotAttending += 1;
			}
			out.print("</form>\n"
					+ "</div>\n"
					+ "\n"
					+ "<h4> Number of People Attending: " + numberOfPeopleAttending + "</h4>"
					+ "<h4> Number of People Not Attending: " + numberOfPeopleNotAttending + "</h4>"
					+ "</body>\n"
					+ "</html>\n"
					+ ""
					);
		}
		
		out.close();
		out.flush();
	}

}
