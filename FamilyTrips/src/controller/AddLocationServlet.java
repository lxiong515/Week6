package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class AddLocationServlet
 */
@WebServlet("/addLocationServlet")//lower case the servlet
public class AddLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String year = request.getParameter("year"); //need to get prof feedback
		String location = request.getParameter("location");
		
		if (year.isEmpty() || location.isEmpty() || year == null || location == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			ListItem li = new ListItem(year, location);
			TripHelper dao = new TripHelper();
			dao.insertItem(li);
		/*
		ListItem li = new ListItem(year, location); //year error page 4 -see edit-item.jsp line 11
		TripHelper dao = new TripHelper();
		dao.insertItem(li);
		*/
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
	}

}
