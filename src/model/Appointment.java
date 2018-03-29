package model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "appointment_date")
	private LocalDate appointmentDate;
	@Column(name = "start_time")
	private LocalTime startTime;
	@Column(name = "end_time")
	private LocalTime endTime;
	@Column(name = "total_cost")
	protected double totalCost;
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Services services;
	@Transient
	private Customer customer;
	@Transient
	protected double upcharge;
	@Transient
	private final double LOW_WEIGHT = 25;
	@Transient
	private final double MID_WEIGHT = 50;
	@Transient
	private final double MID_WEIGHT_UPCHARGE = 10;
	@Transient
	private final double HIGH_WEIGHT_UPCHARGE = 20;
	@Transient
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
	@Transient
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
	@Transient
	DecimalFormat df = new DecimalFormat("$#0.00");


	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Appointment(int id) {
		super();
		this.id = id;

	}

	
	public Appointment(Customer customer, Pet pet, Services services, LocalDate appointmentDate) {
		super();
		this.customer = customer;
		this.pet = pet;
		this.services = services;
		this.appointmentDate = appointmentDate;
		setTotalCost();
	}


	public Appointment(Customer customer, Pet pet, Services services,
			LocalDate appointmentDate, LocalTime startTime) {
		super();
		this.appointmentDate = appointmentDate;
		this.startTime = startTime;
		this.pet = pet;
		this.services = services;
		this.customer = customer;

		setTotalCost();
		setEndTime();
	}


	public int getId() {
		return id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Pet getPet() {
		return pet;
	}


	public void setPet(Pet pet) {
		this.pet = pet;
	}


	public Services getServices() {
		return services;
	}


	public void setServices(Services services) {
		this.services = services;
	}


	public String getAppointmentDate() {
		return dateFormat.format(appointmentDate);
	}


	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public String getStartTime() {
		return timeFormat.format(startTime);
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return timeFormat.format(endTime);
	}


	public void setEndTime() {
		this.endTime = startTime.plusMinutes(45);
	}


	public String getTotalCost() {
		return df.format(totalCost);
	}


	public void setTotalCost() {
		upcharge = calculateUpcharge(pet.getWeight());
		this.totalCost = services.getCost() + upcharge;
	}

	

	public String getUpcharge() {
		this.upcharge = calculateUpcharge(pet.getWeight());
		return df.format(upcharge);
	}
	

	public String printReceipt() {
		DecimalFormat df = new DecimalFormat("$##0.00");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		return "----Customer Info----" + customer.printDetails() + "\n\n----Pet Info----" + pet.printDetails(pet.getHasShots()) + "\nUpcharge for Size: " + df.format(upcharge) + "\n\n----Grooming Package----" + services.printDetails() + "\n\nAppointment Date: " + dateFormat.format(appointmentDate) + "\nArrival: " + timeFormat.format(startTime) + "\nDeparture: " + timeFormat.format(endTime);
	}

	
	public String printSecondReceipt() {
		DecimalFormat df = new DecimalFormat("$##0.00");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		return "\n\n----Pet Info----" + pet.printDetails(pet.getHasShots()) + "\nUpcharge for Size: " + df.format(upcharge) + "\n\n----Grooming Package----" + services.printDetails() + "\n\nAppointment Date: " + dateFormat.format(appointmentDate) + "\nArrival: " + timeFormat.format(startTime) + "\nDeparture: " + timeFormat.format(endTime);
	}

	
	public double calculateUpcharge(double weight) {
		double upcharge = 0;
		if(weight > LOW_WEIGHT && weight <= MID_WEIGHT) {
			upcharge = MID_WEIGHT_UPCHARGE;
		} else if(weight > MID_WEIGHT) {
			upcharge = HIGH_WEIGHT_UPCHARGE;
		}
		return upcharge;
	}


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDate=" + appointmentDate + ", totalCost=" + totalCost + ", pet="
				+ pet + ", services=" + services + ", customer=" + customer + ", upcharge=" + upcharge + ", LOW_WEIGHT="
				+ LOW_WEIGHT + ", MID_WEIGHT=" + MID_WEIGHT + ", MID_WEIGHT_UPCHARGE=" + MID_WEIGHT_UPCHARGE
				+ ", HIGH_WEIGHT_UPCHARGE=" + HIGH_WEIGHT_UPCHARGE + "]";
	}
	

}