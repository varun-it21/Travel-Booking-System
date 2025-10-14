package travel;

import jakarta.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;
import travel.Bookings;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import com.sun.tools.javac.util.List;

/**
 * Servlet implementation class Mybooking
 */
@WebServlet("/Mybooking")
public class Mybooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mybooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		  HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("email") == null) {
	            response.sendRedirect("login.html"); // user not logged in
	            return;
	        }

	        String email = (String) session.getAttribute("email");
	        System.out.println("Logged-in email: " + email);


	        try (Connection conn = myconnection.getConnection()) {
	            String sql = "SELECT * FROM online_bookings WHERE email = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();

	            List<Bookings> bookings = new ArrayList<>();
	            while (rs.next()) {
	                Bookings b = new Bookings();
	                b.setBookingId(rs.getInt("booking_id"));
	                b.setUserId(rs.getInt("user_id"));
	                b.setPackageName(rs.getString("package_name"));
	                b.setFullName(rs.getString("full_name"));
	                b.setEmail(rs.getString("email"));
	                b.setPhone(rs.getString("phone"));
	                b.setTravelDate(rs.getString("travel_date"));
	                b.setAdults(rs.getInt("adults"));
	                b.setChildren(rs.getInt("children"));
	                b.setSpecialRequests(rs.getString("special_requests"));
	                b.setBookingDate(rs.getString("booking_date"));
	                b.setBookingType(rs.getString("booking_type"));
	                b.setTotalPrice(rs.getDouble("total_price"));
	                bookings.add(b);
	            }

	            request.setAttribute("bookings", bookings);
	            request.getRequestDispatcher("mybooking.jsp").forward(request, response);

	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("error", "⚠️ Unable to fetch bookings: " + e.getMessage());
	            request.getRequestDispatcher("mybooking.jsp").forward(request, response);
	        }
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
