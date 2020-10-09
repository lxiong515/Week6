package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListItem;
import model.Traveler;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ListDetailsHelper dao = new ListDetailsHelper();
		TripHelper trh = new TripHelper();
		TravelerHelper tvh = new TravelerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String travelerName = request.getParameter("travelerName");
		//find our add the new traveler
		Traveler newTraveler = tvh.findTraveler(travelerName);//getTravelerName from Traveler.java?
		
		LocalDate Id;
		try {
			Id = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex) {
			Id = LocalDate.now();
		}
		try {//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ListItem>selectedItemsInList = new ArrayList<ListItem>();
			for(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListItem c = trh.searchForTripById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfItems(selectedItemsInList);
		}catch(NullPointerException ex) {
			//no items selected in list - set to an empty list
			List<ListItem>selectedItemsInList = new ArrayList<ListItem>();
			listToUpdate.setListOfItems(selectedItemsInList);
		}
		//creating methods for setListName, setTripDate, setTraveler in ListItems.java due to erro
		listToUpdate.setListName(newListName);
		listToUpdate.setTripDate(Id);
		listToUpdate.setTraveler(newTraveler);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
