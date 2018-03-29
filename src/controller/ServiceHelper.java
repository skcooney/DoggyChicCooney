package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Appointment;
import model.Services;

public class ServiceHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DoggyChicCooney");
	public void insertServices(Services toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteAppointment(Services toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Services> typedQuery = em.createQuery("select sh from Service sh where sh.planName = :selectedPlanName ",Services.class);
		typedQuery.setParameter("selectedPlanName", toDelete.getPlanName());
		typedQuery.setMaxResults(1);
		Services result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public void updateServices(Services toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
				
	}
	
	public Services getServicesById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Services foundServices = em.find(Services.class, idToEdit);
		em.close();
		return foundServices;
	
}
	public void updateService(Services toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}

		public void cleanUp() {

		emfactory.close();

	}
	
	public void addService(Services toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public void deleteService(Services toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Services> typedQuery = em.createQuery("select serv from Services serv where serv.planName = :selectedPlanName", Services.class);
		typedQuery.setParameter("selectedPlanName", toDelete.getPlanName());
		typedQuery.setMaxResults(1);
		Services result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public List<Services> showAllServices() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Services> allResults = em.createQuery("select serv from Services serv", Services.class);
		List<Services> allServices = allResults.getResultList();
		em.close();
		return allServices;

	}

	public Services searchForServiceById(int idToEdit) {

		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Services found = em.find(Services.class, idToEdit);
		em.close();
		return found;

	}

	public Services searchForServiceByAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Services> result = em.createQuery("select s from Services s INNER JOIN Appointment a where a.services = s and a.id = :selectedAppointmentId", Services.class);
		result.setParameter("selectedAppointmentId", appointment.getId());
		Services service = result.getSingleResult();
		em.close();
		return service;

	}

}