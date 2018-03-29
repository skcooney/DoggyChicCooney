package test;

import java.time.LocalDate;
import java.time.LocalTime;

import controller.AppointmentHelper;
import controller.CustomerHelper;
import controller.PetHelper;
import controller.ServiceHelper;
import model.Appointment;
import model.Customer;
import model.Pet;
import model.Services;

public class AddAnAppointmentTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerHelper custhelp = new CustomerHelper ();
		Customer Cooney = new Customer("Sherri", "Cooney", "1645 Searight Dr", "Pleasant Hill", "IA", "50327", "5152389203");
		custhelp.addCustomer(Cooney);
		
		PetHelper pethelp = new PetHelper();
		Pet pet1 = new Pet("Buddy", 35.0,'Y', Cooney);
		pethelp.addPet(pet1);
		
		ServiceHelper serviceshelp = new ServiceHelper();
		Services services1 = new Services("basic");
		//serviceshelp.insertServices(services1);
		
		AppointmentHelper appointmenthelp = new AppointmentHelper();
		Appointment appointment1 = new Appointment(Cooney, pet1, services1, LocalDate.of(2018, 3, 10), LocalTime.of(3, 15, 0));
		appointmenthelp.addAppointment(appointment1);
			
	}

}



