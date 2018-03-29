package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Appointment;
import model.Customer;
import model.Pet;

public class PetHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DoggyChicCooney");
	public void addPet(Pet toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

public List<Pet> showAllPets() {
	// TODO Auto-generated method stub
	EntityManager em = emfactory.createEntityManager();
	TypedQuery<Pet> allResults = em.createQuery("select ph from Pet ph", Pet.class);
	List<Pet> allItems = allResults.getResultList();
	em.close();
	return allItems;
	
	
}
	public void deletePet(Pet toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pet find = em.find(Pet.class, toDelete.getId());
		em.remove(find);
		em.getTransaction().commit();
		em.close();
}

	
	public void updatePet(Pet toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	public Pet searchForPetById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pet foundPet = em.find(Pet.class, idToEdit);
		em.close();
		return foundPet;
	}
	public List<Pet> searchForPetByCustomer(Customer c) {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Pet> allResults = em.createQuery("select p from Pet p INNER JOIN Customer c where p.customer = c and c.id = :selectedCustomerId", Pet.class);
		allResults.setParameter("selectedCustomerId", c.getId());
		List<Pet> allPets = allResults.getResultList();
		em.close();
		return allPets;

	}

	public void cleanUp() {

		emfactory.close();

	}

	public Pet searchForPetByAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Pet> result = em.createQuery("select p from Pet p INNER JOIN Appointment a where a.pet = p and a.id = :selectedAppointmentId", Pet.class);
		result.setParameter("selectedAppointmentId", appointment.getId());
		Pet pet = result.getSingleResult();
		em.close();
		return pet;
	}
}



