package test;

import controller.PetHelper;
import model.Pet;

public class EditAPetTester {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PetHelper pethelp = new PetHelper();
		Pet toEdit = pethelp.searchForPetById(6);
		
		toEdit.setWeight(70);
		pethelp.updatePet(toEdit);
		
		System.out.println(pethelp.showAllPets());
		
	}

}
