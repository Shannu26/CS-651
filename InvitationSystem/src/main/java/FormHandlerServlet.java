

import java.io.IOException;
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
		response.getWriter().print(eventName);
		response.getWriter().print(eventDate);
		response.getWriter().print(eventTime);
		response.getWriter().print(eventLocation);
		response.getWriter().print(eventDescription);
	}

}
