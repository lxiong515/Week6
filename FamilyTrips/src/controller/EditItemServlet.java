package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TripHelper dao = new TripHelper();
		
		String year = request.getParameter("year");//need feedback from prof/see AddLocServlet
		String location = request.getParameter("location");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		ListItem itemToUpdate = dao.searchForTripById(tempId);
		itemToUpdate.setYear(year); //need prof feedback on int or string
		itemToUpdate.setLocation(location);
				
		dao.updateTrip(itemToUpdate);

		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);


	}

}
