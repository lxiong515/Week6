package controller;

import model.Traveler;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

public class ListDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserTripLists");
	
	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		//added two lines below to see if it helps wiht error - still same issue
		//em.getTransaction().begin();
		//em.getTransaction().commit();
		List<ListDetails>allDetails = em.createNamedQuery("SELECT d FROM ListDetails d").getResultList();
		//em.getTransaction().commit();
		return allDetails;
	}

	public void deleteList(ListDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em.createNamedQuery("select detail from ListDetails detail where detail.id = :selectedId", ListDetails.class);
		
		//Sub parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		//getId in Traveler class though? but creating method in ListDetails
		
		//only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		ListDetails result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	

	public ListDetails searchForListDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(ListDetails toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	
}
