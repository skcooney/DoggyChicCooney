package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class customerInfoServlet
 */
@WebServlet("/customerInfoServlet")
public class customerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerInfoServlet() {
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
		String act = request.getParameter("doThisToCustomer");
		if(act == null) {
				//no button has been selected
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}else if (act.equals("Returning Customer")) {
			getServletContext().getRequestDispatcher("/findCustomer.html").forward(request, response);
		}else if (act.equals("New Customer")) {
			getServletContext().getRequestDispatcher("/addCustomer.html").forward(request, response);
		}
	}

}