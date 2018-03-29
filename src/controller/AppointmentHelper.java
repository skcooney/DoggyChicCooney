package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Appointment;

public class AppointmentHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DoggyChicCooney");


	public void addAppointment(Appointment toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteAppointment(Appointment toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Appointment find = em.find(Appointment.class, toDelete.getId());
		em.remove(find);
		em.getTransaction().commit();
		em.close();
	}

	public List<Appointment> showAllAppointments() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Appointment> allResults = em.createQuery("select app from Appointment app", Appointment.class);
		List<Appointment> allAppointments = allResults.getResultList();
		em.close();
		return allAppointments;
	}

	public Appointment searchForAppointmentById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Appointment found = em.find(Appointment.class, idToEdit);
		em.close();
		return found;
	}

	public void updateAppointment(Appointment toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}

	public List<Appointment> searchForAppointmentByCustomerAndPet(String lastName, String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Appointment> allResults = em.createQuery("select a from Appointment a INNER JOIN Pet p, Customer c where a.pet = p and p.petName = :selectedPet and p.customer = c and c.lastName = :selectedCustomerName", Appointment.class);
		allResults.setParameter("selectedPet", petName);
		allResults.setParameter("selectedCustomerName", lastName);
		List<Appointment> allAppointments = allResults.getResultList();
		em.close();
		return allAppointments;

	}
}