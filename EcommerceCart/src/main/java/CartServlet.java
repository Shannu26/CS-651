

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HashMap<String, Integer[]> cartItems = new HashMap<String, Integer[]>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemName = request.getParameter("item-name");
		int itemPrice = Integer.parseInt(request.getParameter("item-price"));
		int itemQuantity = Integer.parseInt(request.getParameter("item-quantity"));
		String requestType = request.getParameter("request-type");
		
		if(requestType.equals("Add To Cart")) {
			if(itemQuantity != 0) {
				if(this.cartItems.containsKey(itemName)){
					Integer[] value = this.cartItems.get(itemName);
					value[1] += itemQuantity;
					this.cartItems.put(itemName, value);
				}
				else {
					Integer[] value = new Integer[2];
					value[0] = itemPrice;
					value[1] = itemQuantity;
					this.cartItems.put(itemName, value);
				}
			}
		}
		else if(requestType.equals("Delete From Cart")) {
			if(this.cartItems.containsKey(itemName)) {
				this.cartItems.remove(itemName);
			}
		}
		
		request.getSession().setAttribute("cart-items", this.cartItems);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}
