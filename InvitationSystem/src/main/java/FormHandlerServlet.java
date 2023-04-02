

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
				+ "			 <input type=\"text\" name=\"event_name\" value=" + eventName + " id=\"eventDetails\" readonly />\n"	
				+ "        </div>\n"
				+ "        <div>\n"
				+ "          <label>Event Date:</label>"
				+ "			 <input type=\"date\" name=\"event_date\" value=" + eventDate + " id=\"eventDetails\" readonly />\n"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "          <label>Event Time:</label>"
				+ "			 <input type=\"time\" name=\"event_time\" value=" + eventTime + " id=\"eventDetails\" readonly />\n"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "          <label>Event Location:</label>"
				+ "			 <input type=\"text\" name=\"event_location\" value=" + eventLocation + " id=\"eventDetails\" readonly />\n"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "          <label>Event Description:</label>"
				+ "			 <textarea name=\"event_description\" rows=\"4\" cols=\"10\" id=\"eventDetails\" readonly>" + eventDescription + "</textarea>\n"
				+ "        </div>\n"
				+ "\n"
				);
		
		if(eventAttendance == null) {
			out.print(
					"		   <div>\n"
					+ "          <input type=\"submit\" value=\"Attend\" class=\"button\" id=\"attending\" name=\"attending\"/>\n"
					+ "          <input type=\"submit\" value=\"Not Attend\" class=\"button\" id=\"not-attending\" name=\"attending\"/>\n"
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
					+ "<h4 id=\"h4\"> Number of People Attending: <span>" + numberOfPeopleAttending + "</span></h4>"
					+ "<h4> Number of People Not Attending: <span>" + numberOfPeopleNotAttending + "</span></h4>"
					+ "</div>\n"
					+ "\n"
					+ "</body>\n"
					+ "</html>\n"
					+ ""
					);
		}
		
		out.close();
		out.flush();
	}

}
