import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.TravelerHelper;
import model.ListDetails;
import model.ListItem;
import model.Traveler;

public class TripTester {

	public static void main(String[] args) {
		Traveler mike = new Traveler("Mike");
		TravelerHelper th = new TravelerHelper();
		
		th.insertTraveler(mike);
		
		//test ListDetails
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		//test cascade
		ListItem hawaii = new ListItem("2021", "Hawaii");
		ListItem california = new ListItem("2022", "California");
		
		//test cascade
		List<ListItem>mikesItems = new ArrayList<ListItem>();
		mikesItems.add(hawaii);
		mikesItems.add(california);
		
		//test cascade
		ListDetails mikeList = new ListDetails("Mike's TripList", LocalDate.now(), mike);
		mikeList.setListOfItems(mikesItems); //wants to create method in ListDetails.java
		
		//test ListDetails
		//ListDetails mikeList = new ListDetails("Mike's List", LocalDate.now(), mike);
		
		//test ListDetails
		ldh.insertNewListDetails(mikeList);
		
		//test cascade
		List<ListDetails>allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
		
		List<Traveler>allTravelers = th.showAllTravelers();
		for(Traveler a: allTravelers) {
			System.out.println(a.toString());
		}
	}
}
