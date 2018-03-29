package test;

import controller.CustomerHelper;
import model.Customer;

public class AddACustomerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerHelper custhelp = new CustomerHelper();
		Customer Cooney = new Customer("Randy", "Cooney", "1645 Main St", "Pleasant Hill", "IA", "50327", "5152380986");
		custhelp.addCustomer(Cooney);
		
		System.out.println(Cooney);


	}

	}


