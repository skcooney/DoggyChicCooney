package test;

import java.time.LocalTime;

import controller.CustomerHelper;
import controller.PetHelper;
import model.Customer;
import model.Pet;

public class AddAPetTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
		CustomerHelper custhelp = new CustomerHelper();
		PetHelper pethelp = new PetHelper();
		

		Customer Cooney = new Customer("Sherri", "Cooney", "1645 Searight Dr", "Pleasant Hill", "IA", "50327", "5152389203");
		custhelp.addCustomer(Cooney);

		Pet Buddy = new Pet("Buddy", 26, 'Y', Cooney);
		pethelp.addPet(Buddy);
		
		//ClassrCustomeroom ClassroomToDelete = customerhelp.getClassroomById(1);
		//Customerhelp.deleteClassroom(CustomerToDelete);
		
	}

}
