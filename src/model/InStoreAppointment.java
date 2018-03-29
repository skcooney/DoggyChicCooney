/*package model;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

	
	@Entity
	@Table(name="appointment")

	public class InStoreAppointment extends Appointment{

		@Column(name = "start_time")//moved to appointment
		private LocalTime dropoff;//moved to appointment
		@Column(name = "end_time")//moved to appointment
		private LocalTime pickup;//moved to appointment
		@Column(name = "appt_cd")
		private final char type = 'I';
	
		
	
	public InStoreAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InStoreAppointment(Customer customer, Pet pet, Services services, LocalDate appointmentDate) {
		super(customer, pet, services, appointmentDate);
		// TODO Auto-generated constructor stub
	}

	public InStoreAppointment(Customer customer, Pet pet, Services services, LocalDate appointmentDate,
			LocalTime dropoff) {
		super(customer, pet, services, appointmentDate);
		this.dropoff = dropoff;
		//this.dropoff = dropoff;
		setPickup();
				
			}

	public LocalTime getPickup() {
		return pickup;
	}

	public void setPickup() {
		this.pickup = dropoff.plusMinutes(45);
	}

	public LocalTime getDropoff() {
		return dropoff;
	}

	public void setDropoff(LocalTime dropoff) {
		this.dropoff = dropoff;
	}

	

	@Override
	public String printReceipt() {
		// TODO Auto-generated method stub
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
		DecimalFormat df = new DecimalFormat("$###.00");
		return super.printReceipt() + "\nDropoff Time: " + timeFormat.format(dropoff) + "\nPickup Time: " + timeFormat.format(pickup) + "\nTotal Cost: " + df.format(totalCost);
	}
	
	
}
*/