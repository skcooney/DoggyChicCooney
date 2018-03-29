package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "f_name")
	private String firstName;
	@Column(name = "l_name")
	private String lastName;
	@Column(name = "street_add")
	private String address;
	private String city;
	private String state;
	@Column(name = "zip_code")
	private String zip;
	@Column(name = "phone")
	private String phoneNumber;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Customer(int id) {
		super();
		this.id = id;
	}

	
	public Customer(String firstName, String lastName, String phoneNumber, String address, String city, String state, String zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}




	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String printDetails() {
		return "\nCustomer ID: " + id + "\nName: " + firstName + " " + lastName + "\nPhone Number: " + phoneNumber + "\nAddress: " + address + ", " + city + ", " + state + " " + zip;
	}


	@Override
	public String toString() {
		return "Customer [customerID=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phoneNumber="
				+ phoneNumber + "]";
	}

	}