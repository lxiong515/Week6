package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="TRIP_DATE")
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="TRAVELER_ID")
	private Traveler traveler;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable (
			name="ITEMS_ON_LIST",
			joinColumns= {@JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID")},
			inverseJoinColumns= {@JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique=true)}
			)
	private List<ListItem>listOfItems;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate tripDate, Traveler traveler, 
			List<ListItem> listOfItems) {
		//omitted for space
	}
	
	public ListDetails(String listName, LocalDate tripDate, Traveler traveler, List<ListItem> listOfItems) {
		//omitted for space
	}
	
	public ListDetails(String listName, LocalDate tripDate, Traveler traveler) {
		//omitted for space
	}

	public void setListOfItems(List<ListItem> mikesItems) {
		// TODO Auto-generated method stub
		
	}

	public Object getId() {
		// TODO Auto-generated method stub
		//created from the ListDetailsHelper
		return null;
	}

	public void setListName(String newListName) {
		// TODO Auto-generated method stub
		//created from EditListDetailsServlet
	}

	public void setTripDate(LocalDate id2) {
		// TODO Auto-generated method stub
		//created from EditListDetailsServlet
	}

	public void setTraveler(Traveler newTraveler) {
		// TODO Auto-generated method stub
		//created from EditListDetailsServlet
	}




}
