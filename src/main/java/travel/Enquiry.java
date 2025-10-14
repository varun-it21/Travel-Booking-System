package travel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Enquiry
 */
@WebServlet("/Enquiry")
public class Enquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enquiry() {
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
//		doGet(request, response);
		 String name = request.getParameter("name");
	        String city = request.getParameter("city");
	        String mail = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String dest = request.getParameter("destination");
	        String date = request.getParameter("date");
	        String peopleStr = request.getParameter("people");
	        String vacation = request.getParameter("vacation");
		
		PreparedStatement ps;
		
		try {
            int people = Integer.parseInt(peopleStr); // convert number of people to int

            String query = "INSERT INTO enquiries (name, city, email, phone, travel_destination, travel_date, number_of_people, vacation_type) VALUES(?,?,?,?,?,?,?,?)";
            ps = myconnection.getConnection().prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, city);
            ps.setString(3, mail);
            ps.setString(4, phone);
            ps.setString(5, dest);
            ps.setString(6, date);
            ps.setInt(7, people); // set as integer
            ps.setString(8, vacation);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("home.html"); // redirect after successful insert
            } else {
                response.getWriter().println("Booking failed. Please try again.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().println("Error: " + ex.getMessage());
        }
		
	}

}
