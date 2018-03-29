package test;

import controller.CustomerHelper;
import model.Customer;

public class EditACustomerTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerHelper custhelp = new CustomerHelper();
		Customer toEdit = custhelp.searchForCustomerById(4);
		
		toEdit.setLastName("Cooney");
		custhelp.updateCustomer(toEdit);
		
		System.out.println(custhelp.showAllCustomers());
	}

}
