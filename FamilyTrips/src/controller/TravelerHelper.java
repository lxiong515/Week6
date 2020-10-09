package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Traveler;

//package and import statements
public class TravelerHelper { //no persistence provider for entitymanager named UserTripLists
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserTripLists");
	
	public void insertTraveler(Traveler t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Traveler>showAllTravelers(){
		EntityManager em = emfactory.createEntityManager();
		List<Traveler> allTravelers = em.createNamedQuery("SELECT s FROM Traveler t").getResultList();
		return allTravelers;
	}

	public Traveler findTraveler(String nameToLookUp) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Traveler>typedQuery = em.createNamedQuery("select tvh from Traveler tvh where tvh.travelerName = :selectedName", Traveler.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Traveler foundTraveler;
		try {
			foundTraveler = typedQuery.getSingleResult();
		}catch (NoResultException ex) {
			foundTraveler = new Traveler(nameToLookUp);
		}
		em.close();
		return foundTraveler;
	}
	

}
