package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "pet_name")
	private String petName;
	private double weight;
	@Column(name = "vaccinations")
	private char hasShots;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pet(int id) {
		super();
		this.id = id;
	}

	
	public Pet(String name, double weight, char hasShots, Customer cust) {
		super();
		this.petName = name;
		this.weight = weight;
		this.hasShots = hasShots;
		this.customer = cust;
	}


	public int getId() {
		return id;
	}


	public String getPetName() {
		return petName;
	}


	public void setPetName(String name) {
		this.petName = name;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public char getHasShots() {
		return hasShots;
	}


	public void setHasShots(char hasShots) {
		this.hasShots = hasShots;
	}

	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String printDetails(char hasShots) {
		String shots;
		if (hasShots == 'Y') {
		shots = "Yes";
		} else {
			shots = "No";
		}
		return "\nPet ID: " + id + "\nName: " + petName + "\nWeight: " + weight + "\nShots Up-to-Date: " + shots;
	}


	@Override
	public String toString() {
		return "Pet [petID=" + id + ", name=" + petName + ", weight=" + weight + ", hasShots=" + hasShots
				+ ", customer=" + customer + "]";
	}

}