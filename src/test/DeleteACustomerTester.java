package test;


import controller.CustomerHelper;
import model.Customer;

public class DeleteACustomerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerHelper cushelper = new CustomerHelper();
		Customer toDelete = new Customer(37);
		cushelper.deleteCustomer(toDelete);
		System.out.println(cushelper.showAllCustomers());
	}

}
