/*package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import model.Customer;
import model.InStoreAppointment;
import model.Pet;
import model.Services;

public class GroomingTester {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

	System.out.print("Enter customer first name: ");
		String firstName = in.nextLine();
		System.out.print("Enter customer last name: ");
		String lastName = in.nextLine();
		System.out.print("Enter customer address: ");
		String streetAdd = in.nextLine();
		System.out.print("Enter customer city: ");
		String city = in.nextLine();
		System.out.print("Enter customer state: ");
		String state = in.nextLine();
		System.out.print("Enter customer zip code: ");
		String zip = in.nextLine();
		System.out.print("Enter customer phone number: ");
		String phoneNumber = in.nextLine();
		
		Customer custA = new Customer(0, firstName, lastName, streetAdd, city, state, zip, phoneNumber);

		System.out.print("Enter pet name: ");
		String petName = in.nextLine();
		System.out.print("Enter " + petName + "'s weight: ");
		double weight = in.nextDouble();
		System.out.print("Is " + petName + " up-to-date on shots? ");
		boolean hasShots = in.nextBoolean();

		Pet petA = new Pet(petName, weight, hasShots);

		Services servicesA = new Services();

		System.out.println("Service plans: ");
		servicesA.getPlanDetails();
		System.out.print("Select plan: ");
		String planName = in.nextLine();

		servicesA.setPlanName(planName);

		InStoreAppointment appt = new InStoreAppointment(custA, petA, servicesA, LocalDate.of(2018, 4, 11),
				LocalTime.of(12, 30));
		System.out.println(appt.printReceipt());

		appt.printReceipt();
	}

	
	

		
		Customer k = new Customer("Kelli", "Kleindorfer", "123 Elm St", "Des Moines", "Iowa", "50392", "555-555-1212");
		Pet d = new Pet("oae123", "Fido", 55, true);
		Services a = new Services("32497d", "basic", 30);
		InStoreAppointment appt = new InStoreAppointment(k, d, a, LocalDate.of(2018, 4, 11), LocalTime.of(12, 30), LocalTime.of(15, 15));
		System.out.println(appt.printReceipt());
		
		appt.printReceipt();
	}
	
} 

}
*/