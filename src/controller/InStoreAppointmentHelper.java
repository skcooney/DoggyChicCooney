/*package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.InStoreAppointment;

public class InStoreAppointmentHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DoggyChicCooney");
	public void insertInStoreAppointment(InStoreAppointment toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
}
	/*
	public void deleteAppointment(Appointment toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Appointment> typedQuery = em.createQuery("select ih from Instructor ih where ih.firstName = :selectedFirstName and ih.lastName = :selectedLastName ",Instructor.class);
		typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
		typedQuery.setParameter("selectedLastName", toDelete.getLastName());
		typedQuery.setMaxResults(1);
		Instructor result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public void updateInstructor(Instructor toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
				
	}
	public List<Instructor> showAllInstructors() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Instructor> allResults = em.createQuery("select ih from Instructor ih", Instructor.class);
		List<Instructor> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	public Instructor getInstructorById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Instructor foundInstructor = em.find(Instructor.class, idToEdit);
		em.close();
		return foundInstructor;
	}
}
}
*/

