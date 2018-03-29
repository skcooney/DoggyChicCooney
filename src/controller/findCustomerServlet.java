package controller;



import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Customer;


/**
 * Servlet implementation class findCustomerServlet
 */
@WebServlet("/findCustomerServlet")
public class findCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    /**
     * @see HttpServlet#HttpServlet()
     */
    public findCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String lastName = request.getParameter("lastName");
		CustomerHelper ch = new CustomerHelper();
		List<Customer> list = ch.searchForCustomerByName(lastName);
		request.setAttribute("matchingCustomers", list);
		if(list.isEmpty()) {
			request.setAttribute("matchingCustomers", " ");
		}
		getServletContext().getRequestDispatcher("/findCustomer.jsp").forward(request, response);
		
	}

}