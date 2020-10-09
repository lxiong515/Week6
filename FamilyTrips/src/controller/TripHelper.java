package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;
import model.Traveler;

public class TripHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FamilyTrips");

	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public	List<ListItem>	showAllItems(){
		EntityManager em	=	emfactory.createEntityManager();
		//list all items
		List<ListItem>allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return	allItems;

		}

	
	public	void	deleteItem(ListItem	toDelete)	{
		EntityManager em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery	= em.createQuery("select li from ListItem li where li.year = :selectedYear and li.location = :selectedLocation", ListItem.class);
		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		typedQuery.setParameter("selectedYear",	toDelete.getYear());
		typedQuery.setParameter("selectedLocation",	toDelete.getLocation());
		//we	only	want	one	result
		typedQuery.setMaxResults(1);
		//get	the	result	and	save	it	into	a	new	list	item
		ListItem result	=	typedQuery.getSingleResult();
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public	List<ListItem>	searchForTripByLocation(String	tripLocation) {
//		TODO	Auto-generated	method	stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListItem> typedQuery	= em.createQuery("select li from ListItem li where li.location = :selectedLocation", ListItem.class);
	typedQuery.setParameter("selectedItem",	tripLocation);
	List<ListItem> foundItems =	typedQuery.getResultList();
	em.close();
	return	foundItems;
	}
	
	public List<ListItem> searchForTripByYear(String tripYear){
//		TODO	Auto-generated	method	stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListItem> typedQuery	= em.createQuery("select li from ListItem li where li.year = :selectedYear", ListItem.class);
	typedQuery.setParameter("selectedYear",	tripYear);
	List<ListItem> foundItems =	typedQuery.getResultList();
	em.close();
	return	foundItems;
	}
	
	public ListItem	searchForTripById(int idToEdit)	{
//		TODO	Auto-generated	method	stub
	EntityManager	em	=	emfactory.createEntityManager();
	em.getTransaction().begin();
	ListItem	found	=	em.find(ListItem.class,	idToEdit);
	em.close();
	return	found;
	}
	
	public void updateTrip(ListItem	toEdit)	{
//		TODO	Auto-generated	method	stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
	}
	

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}


}
