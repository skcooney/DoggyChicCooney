package test;

import controller.PetHelper;
import model.Pet;

public class DeleteAPetTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PetHelper pethelper = new PetHelper();
		Pet toDelete = new Pet(23);
		pethelper.deletePet(toDelete);
	System.out.println(pethelper.showAllPets());

	}

}
