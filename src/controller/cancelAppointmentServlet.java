package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class cancelAppointmentServlet
 */
@WebServlet("/cancelAppointmentServlet")
public class cancelAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    /**
     * @see HttpServlet#HttpServlet()
     */
   public cancelAppointmentServlet() {
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
		String act = request.getParameter("doThisToItem");
		if (act == null) {
			getServletContext().getRequestDispatcher("/cancelAppointmentServlet").forward(request, response);
			
		}else if (act.equals("Back to Menu")) {
					getServletContext().getRequestDispatcher("/index.html").forward(request, response);
					
		} else if (act.equals("New Appointment")) {
			getServletContext().getRequestDispatcher("/startAppointment.html").forward(request, response);
					}

	}



}