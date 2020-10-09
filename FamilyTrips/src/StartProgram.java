import java.util.List;
import java.util.Scanner;

import controller.TripHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static TripHelper lih = new TripHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a year: ");
			String year = in.nextLine();
			System.out.print("Enter a location: ");
			String location = in.nextLine();

			ListItem toAdd = new ListItem(year, location);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the year to delete: ");
			String year = in.nextLine();
			System.out.print("Enter the location to delete: ");
			String location = in.nextLine();

			ListItem toDelete = new ListItem(year, location);
			lih.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Year");
			System.out.println("2 : Search by Location");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the year of trip: ");
				String tripYear = in.nextLine(); //changed to String and nextLine
				foundItems = lih.searchForTripByYear(tripYear);
			} else {
				System.out.print("Enter the location: ");
				String tripLocation = in.nextLine();
				foundItems = lih.searchForTripByLocation(tripLocation);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForTripById(idToEdit);
				System.out.println("Retrieved " + toEdit.getLocation() + " from " + toEdit.getYear());
				System.out.println("1 : Update Year");
				System.out.println("2 : Update Trip");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				} else if (update == 2) {
					System.out.print("New Location: ");
					String newLocation = in.nextLine();
					toEdit.setLocation(newLocation);
				}

				lih.updateTrip(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Howser Family Trips ---");
			while (goAgain) {
				System.out.println("*  Select an option:");
				System.out.println("*  1 -- Add a Trip");
				System.out.println("*  2 -- Edit a Trip");
				System.out.println("*  3 -- Delete a Trip");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem singleItem : allItems){
				System.out.println(singleItem.returnItemDetails());
			}

		}
}