package test;

import java.time.LocalDate;

import controller.AppointmentHelper;
import model.Appointment;

public class EditAnAppointmentTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppointmentHelper appthelp = new AppointmentHelper();
		Appointment toEdit = appthelp.searchForAppointmentById(5);
		
		toEdit.setAppointmentDate(LocalDate.of(2018, 3, 2));
		appthelp.updateAppointment(toEdit);
		
		System.out.println(appthelp.showAllAppointments());
	}

}


		



