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
 * Servlet implementation class addAppointmentServlet
 */
@WebServlet("/addAppointmentServlet")
public class addAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * Default constructor. 
     */
    public addAppointmentServlet() {
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AppointmentHelper ap = new AppointmentHelper();
		
		LocalDate appointmentDate = LocalDate.parse(request.getParameter("appointmentDate"));
		LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
		

		String planName = request.getParameter("planName");
		Services service = new Services(planName);
	

		Customer customer = (Customer)getServletContext().getAttribute("customer");
		Pet pet = (Pet)getServletContext().getAttribute("pet");
		

		Appointment appointment = new Appointment(customer, pet, service, appointmentDate, startTime);
		ap.addAppointment(appointment);

		
		request.setAttribute("customer", customer);
		request.setAttribute("pet", pet);
		request.setAttribute("service", service);
		request.setAttribute("appointment", appointment);

		
		request.getRequestDispatcher("/viewAppointment.jsp").forward(request, response);

	}
}