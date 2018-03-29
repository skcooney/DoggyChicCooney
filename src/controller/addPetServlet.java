package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Pet;


/**
 * Servlet implementation class addPetServlet
 */
@WebServlet("/addPetServlet")
public class addPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPetServlet() {
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
		PetHelper ph = new PetHelper();
		

		String act = request.getParameter("doThisToItem");
		if(act == null) {
			//no button has been selected
		getServletContext().getRequestDispatcher("/addPet.html").forward(request, response);
		} else if (act.equals("Submit")) {
			String petName = request.getParameter("petName");
			Double petWeight = Double.parseDouble(request.getParameter("petWeight"));
			String shots = request.getParameter("shots");
			char hasShots = 0;
			if ((shots.contains("y")) || (shots.contains("Y"))) {
				hasShots = 'Y';
			} else {
				hasShots = 'N';
			}
			

			Customer cust = (Customer)getServletContext().getAttribute("customer");
			

			Pet p = new Pet(petName, petWeight, hasShots, cust);
			ph.addPet(p);
			getServletContext().setAttribute("pet", p);
			

			getServletContext().getRequestDispatcher("/makeAppointment.html").forward(request, response);
}

	}

}