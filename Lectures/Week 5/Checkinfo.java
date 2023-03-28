import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Checkinfo
 */
@WebServlet("/Checkinfo")
public class Checkinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 // Method to handle POST method request
	   @Override
	   public void doPost(HttpServletRequest req, HttpServletResponse res) 
	               throws ServletException, IOException {

	       // declare variables
	       PrintWriter pw = null;
	       String name = null;
	       String tage = null;
	       int age = 0;

	       // set content type
	       res.setContentType("text/html");

	       // get PrintWriter object
	       pw = res.getWriter();

	       // get form data (from parameter)
	       name = req.getParameter("pname");
	       tage = req.getParameter("page");

	       // convert String value to int
	       age = Integer.parseInt(tage);

	       // check age
	       pw.println("<h1 style='text-align: center; color:blue'>"
	                 + "Hello "+ name + "</h1>");
	       if(age < 18) {
	          pw.println("<h2 style='text-align: center; color:red'>"
	                    +"You are not eligible to vote.</h2>"
	                    +"<h3 style='text-align: center; color:green'>"
	                    +"Please wait for " + (18-age) + " more years.<br>"
	                    +" Thank You.<h3>"
	          );
	       } else  {
	          pw.println("<h2 style='text-align: center; color:green'>"
	                    +"You are eligible to vote.</h2>"
	                    +"<h3 style='text-align: center'>"
	                    +"Thank You.<h3>"
	          );
	       }

	       // close stream
	       pw.close();
	   }

	   // Method to handle GET method request
	   @Override
	   public void doGet(HttpServletRequest req, HttpServletResponse res) 
	               throws ServletException, IOException {
	       // call doPost() method
	       doPost(req, res);
	   }
}


