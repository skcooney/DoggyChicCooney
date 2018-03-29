package controller;



import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Appointment;

import model.Customer;
import model.Pet;
import model.Services;


/**
 * Servlet implementation class editAppointmentServlet
 */
@WebServlet("/editAppointmentServlet")
public class editAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    /**
     * @see HttpServlet#HttpServlet()
     */
    public editAppointmentServlet() {
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
		CustomerHelper ch = new CustomerHelper();
		PetHelper ph = new PetHelper();
		AppointmentHelper ah = new AppointmentHelper();
		

		String act = request.getParameter("doThisToItem");
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAppointmentServlet").forward(request, response);
		} else if (act.equals("Edit Customer Info")) {
			Integer tempId = Integer.parseInt(request.getParameter("custId"));
			Customer customerToEdit = ch.searchForCustomerById(tempId);
			request.setAttribute("customerToEdit", customerToEdit);
			

			getServletContext().getRequestDispatcher("/editCustomer.jsp").forward(request, response);
		} else if (act.equals("Edit Pet Info")) {
			Integer tempId = Integer.parseInt(request.getParameter("petId"));
			Pet petToEdit = ph.searchForPetById(tempId);
			request.setAttribute("petToEdit", petToEdit);
			

			getServletContext().getRequestDispatcher("/editPet.jsp").forward(request, response);
		} else if (act.equals("Edit Appointment")) {
			Integer tempId = Integer.parseInt(request.getParameter("apptId"));
			Appointment appointmentToEdit = ah.searchForAppointmentById(tempId);
			request.setAttribute("appointmentToEdit", appointmentToEdit);
/*			
			
		}else if (act.equals("Cancel Appointment")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			//System.out.println("This is tempid = " + tempId);
			Appointment appointmentToDelete = ah.searchForAppointmentById(tempId);
			System.out.println(appointmentToDelete.toString());
			ah.deleteAppointment(appointmentToDelete);
			
	*/	

			getServletContext().getRequestDispatcher("/editAppointment.jsp").forward(request, response);
		} else if (act.equals("Save Customer Information")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			String phoneNumber = request.getParameter("phoneNumber");
			Integer tempId = Integer.parseInt(request.getParameter("id"));

					
			//getServletContext().getRequestDispatcher("/viewAllArtworkServlet").forward(request, response);
			

			Customer customerToUpdate = ch.searchForCustomerById(tempId);
			customerToUpdate.setFirstName(firstName);
			customerToUpdate.setLastName(lastName);
			customerToUpdate.setAddress(address);
			customerToUpdate.setCity(city);
			customerToUpdate.setState(state);
			customerToUpdate.setZip(zip);
			customerToUpdate.setPhoneNumber(phoneNumber);
			

			ch.updateCustomer(customerToUpdate);
			

			Appointment custAppointment = (Appointment)getServletContext().getAttribute("selectedAppointment");
			Pet custPet = (Pet)getServletContext().getAttribute("selectedPet");
			Services custService = (Services)getServletContext().getAttribute("selectedService");
			

			request.setAttribute("appointment", custAppointment);
			request.setAttribute("pet", custPet);
			request.setAttribute("service", custService);
			request.setAttribute("customer", customerToUpdate);
			

			request.getRequestDispatcher("/viewAppointment.jsp").forward(request, response);
			
		} else if (act.equals("Save Pet Information")) {
			String petName = request.getParameter("petName");
			Double weight = Double.parseDouble(request.getParameter("weight"));
			String shots = request.getParameter("shots");
			char hasShots = 0;
			if ((shots.contains("y")) || (shots.contains("Y"))) {
				hasShots = 'Y';
			} else {
				hasShots = 'N';
			}
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			

			Pet petToUpdate = ph.searchForPetById(tempId);
			petToUpdate.setPetName(petName);
			petToUpdate.setWeight(weight);
			petToUpdate.setHasShots(hasShots);

			
			ph.updatePet(petToUpdate);
			

			Appointment petAppointment = (Appointment)getServletContext().getAttribute("selectedAppointment");
			Customer petCust = (Customer)getServletContext().getAttribute("selectedCustomer");
			Services petService = (Services)getServletContext().getAttribute("selectedService");
			
			petAppointment.setPet(petToUpdate);

			request.setAttribute("appointment", petAppointment);
			request.setAttribute("pet", petToUpdate);
			request.setAttribute("service", petService);
			request.setAttribute("customer", petCust);
			

			request.getRequestDispatcher("/viewAppointment.jsp").forward(request, response);
		} else if (act.equals("Save Edited Appointment")) {
			LocalDate appointmentDate = LocalDate.parse(request.getParameter("appointmentDate"));
			LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			

			String planName = request.getParameter("planName");
			Services service = new Services(planName);
			

			Appointment appointmentToUpdate = ah.searchForAppointmentById(tempId);
			appointmentToUpdate.setAppointmentDate(appointmentDate);
			appointmentToUpdate.setStartTime(startTime);
			appointmentToUpdate.setServices(service);
			appointmentToUpdate.setTotalCost();
			

			ah.updateAppointment(appointmentToUpdate);
			

			Pet pet = ph.searchForPetByAppointment(appointmentToUpdate);
			Customer customer = ch.searchForCustomerByPet(pet);
			

			request.setAttribute("appointment", appointmentToUpdate);
			request.setAttribute("pet", pet);
			request.setAttribute("service", service);
			request.setAttribute("customer", customer);
			

			request.getRequestDispatcher("/viewAppointment.jsp").forward(request, response);
			
		} else if (act.equals("Cancel Appointment")) {
			Integer id = Integer.parseInt(request.getParameter("apptId"));
			Appointment apptToDelete = ah.searchForAppointmentById(id);
			ah.deleteAppointment(apptToDelete);
			getServletContext().getRequestDispatcher("/cancelNotice.html").forward(request, response);
			
		} else if (act.equals("Back to Menu")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			
		} else if (act.equals("New Appointment")) {
			getServletContext().getRequestDispatcher("/startAppointment.html").forward(request, response);

		}

	}



}