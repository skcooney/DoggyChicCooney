package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import controller.CustomerHelper;
import controller.AppointmentHelper;
import controller.PetHelper;
import model.Appointment;
import model.Customer;

import model.Pet;
import model.Services;

public class StartAppointment {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");

		// Account for returning customers

		System.out.println("Welcome to Doggy Chic!");
		System.out.println();
		System.out.println("Let's schedule your pet's grooming appointment--");
		LocalDate date = setAppointmentDate();
		LocalTime start = setAppointmentTime();
		System.out.println();
		System.out.println("Please provide more information for your appointment on " + dateFormat.format(date) + " at "
				+ timeFormat.format(start) + "--");
		Customer custA = getCustomerInfo();
		System.out.println();
		Pet petA = getPetInfo(custA);
		int numOfPets = 1;
		System.out.println();
		Services serviceA = getServiceInfo();
		System.out.println();
		System.out.print("Would you like to add another pet? ");
		String input = in.nextLine();
		Pet petB = null;
		Services serviceB = null;
		switch (input.toLowerCase()) {
		case "yes":
		case "y":
			petB = getPetInfo(custA);
			numOfPets++;
			System.out.println();
			serviceB = getServiceInfo();
			break;
		}
		System.out.println();

		// Loop for multiple dogs
		// DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
		// LocalTime time = formatter.parseLocalTime("14:10");
		// time = time.plusMinutes(10);
		// System.out.println(formatter.print(time));

		/**
		 * InStoreAppointment apptA = new InStoreAppointment(custA, petA, servicesA,
		 * date, start); MobileAppointment apptB = new MobileAppointment(custA, petA,
		 * servicesA, date, start);
		 * 
		 * System.out.print("Please enter i for in-store appointment or m for mobile
		 * appointment: "); String input = in.nextLine(); while (!(input.equals("i")) &&
		 * !(input.equals("m"))) { System.out.print("Invalid input. Please enter either
		 * i or m: "); in.nextLine(); } System.out.println(); if (input.equals("i")) {
		 * System.out.println(apptA.printReceipt()); } else if (input.equals("m")) {
		 * System.out.println(apptB.printReceipt()); }
		 */

		AppointmentHelper apphelp = new AppointmentHelper();
		Appointment apptA = new Appointment(custA, petA, serviceA, date, start);
		apphelp.addAppointment(apptA);
		System.out.println(apptA.printReceipt());
		Appointment apptB = null;
		if (numOfPets > 1) {
			apptB = new Appointment(custA, petB, serviceB, date, start);
			apphelp.addAppointment(apptB);
			System.out.println(apptB.printSecondReceipt());
		}
	}

	public static LocalDate setAppointmentDate() {
		int year = LocalDate.now().getYear();
		final int FEBRUARY = 2;
		final int APRIL = 4;
		final int JUNE = 6;
		final int SEPTEMBER = 9;
		final int NOVEMBER = 11;
		int month = 0;
		System.out.print("Please enter month (1-12): ");
		if (in.hasNextInt()) {
			month = in.nextInt();
			in.nextLine();
		} else {
			System.out.print("Invalid input. Please enter month (1-12): ");
			month = in.nextInt();
			in.nextLine();
		}
		while (!(month >= 1 && month <= 12)) {
			System.out.print("Invalid input. Please enter month (1-12): ");
			month = in.nextInt();
			in.nextLine();
		}

		int day = 0;
		System.out.print("Please enter day: ");
		if (in.hasNextInt()) {
			day = in.nextInt();
			in.nextLine();
		} else {
			System.out.print("Invalid input. Please enter day as numeral: ");
			day = in.nextInt();
			in.nextLine();
		}
		if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) {
			final int START = 1;
			final int END = 30;
			if (day < START || day > END) {
				System.out.print("Invalid input. Please enter day (1-30): ");
				day = in.nextInt();
				in.nextLine();
			}
		} else if (month == FEBRUARY) {
			final int START = 1;
			final int END1 = 29;
			final int END2 = 28;
			boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
			if (isLeapYear) {
				if (day < START || day > END1) {
					System.out.print("Invalid input. Please enter day (1-29): ");
					day = in.nextInt();
					in.nextLine();
				}
			} else {
				if (day < 1 || day > END2) {
					System.out.print("Invalid input. Please enter day (1-28): ");
					day = in.nextInt();
					in.nextLine();
				}
			}
		} else {
			final int START = 1;
			final int END = 31;
			if (day < START || day > END) {
				System.out.print("Invalid input. Please enter day (1-31): ");
				day = in.nextInt();
				in.nextLine();
			}
		}

		LocalDate appointmentDate = LocalDate.of(year, month, day);
		return appointmentDate;
	}

	public static LocalTime setAppointmentTime() {
		System.out.print("Would you like an AM or PM appointment? ");
		String input = in.nextLine();
		while (!(input.equalsIgnoreCase("am") || input.equalsIgnoreCase("pm"))) {
			System.out.print("Invalid input. Please enter AM or PM: ");
			input = in.nextLine();
		}
		int hour = 0;
		final int HOUR_START = 1;
		final int HOUR_END = 12;
		System.out.print("Please enter the start time of your appointment--" + "\nHour: ");
		if (in.hasNextInt()) {
			hour = in.nextInt();
			in.nextLine();
		} else {
			System.out.print("Invalid input. Please enter hour (1-12): ");
			hour = in.nextInt();
			in.nextLine();
		}
		while (!(hour >= HOUR_START && hour <= HOUR_END)) {
			System.out.print("Invalid input. Please enter hour (1-12): ");
			hour = in.nextInt();
			in.nextLine();
		}
		if (input.equalsIgnoreCase("pm") && hour != HOUR_END) {
			hour += 12;
		}
		if (input.equalsIgnoreCase("am") && hour == HOUR_END) {
			hour = 0;
		}
		int minute = 0;
		final int MINUTE_START = 0;
		final int MINUTE_END = 59;
		System.out.print("Minute: ");
		if (in.hasNextInt()) {
			minute = in.nextInt();
			in.nextLine();
		} else {
			System.out.print("Invalid input. Please enter minute (00-59): ");
			minute = in.nextInt();
			in.nextLine();
		}
		while (!(minute >= MINUTE_START && minute <= MINUTE_END)) {
			System.out.print("Invalid input. Please enter minute (00-59): ");
			minute = in.nextInt();
			in.nextLine();
		}
		LocalTime startTime = LocalTime.of(hour, minute);
		return startTime;
	}

	public static Customer getCustomerInfo() {
		System.out.print("Enter customer  first name: ");
		String firstName = in.nextLine();
		System.out.print("Enter customer  last name: ");
		String lastName = in.nextLine();
		System.out.print("Enter customer street address: ");
		String streetAddress = in.nextLine();
		System.out.print("Enter customer city: ");
		String city = in.nextLine();
		System.out.print("Enter state (two-letter abbreviation): ");
		String state = in.nextLine();
		System.out.print("Enter customer zip-code: ");
		String zipcode = in.nextLine();
		
		System.out.print("Enter customer phone number: ");
		String phoneNumber = in.nextLine();

		Customer cust = new Customer(firstName, lastName, streetAddress, city, state, zipcode, phoneNumber);
		CustomerHelper custhelp = new CustomerHelper();
		custhelp.addCustomer(cust);
		return cust;
	}

	public static Pet getPetInfo(Customer cust) {
		System.out.print("Enter pet name: ");
		String petName = in.nextLine();
		System.out.print("Enter " + petName + "'s weight: ");
		double weight = in.nextDouble();
		System.out.print("Is " + petName + " up-to-date on shots? ");
		String shots = in.next();
		char hasShots = 0;
		if (shots.contains("y")) {
			hasShots = 'Y';
		} else {
			hasShots = 'N';
		}
		in.nextLine();
		if (hasShots == 'N') {
			System.out.println("**Please ensure " + petName
					+ " is up-to-date on shots before your appointment, or services will not be provided**");
		}

		Pet pet = new Pet(petName, weight, hasShots, cust);
		PetHelper pethelp = new PetHelper();
		pethelp.addPet(pet);
		return pet;
	}

	public static Services getServiceInfo() {
		Services service = new Services();

		System.out.println("***Service plans***");
		System.out.println(service.getPlanDetails());
		System.out.print("Select plan: ");
		String planName = in.nextLine();

		service.setPlanName(planName);
		return service;
	}

}
