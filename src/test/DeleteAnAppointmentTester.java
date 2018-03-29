package test;

import controller.AppointmentHelper;
import model.Appointment;

public class DeleteAnAppointmentTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppointmentHelper apphelper = new AppointmentHelper();
		Appointment toDelete = new Appointment(12);
		apphelper.deleteAppointment(toDelete);
	System.out.println(apphelper.showAllAppointments());
			
	}

}
