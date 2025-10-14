package travel;

import jakarta.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;
//import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import com.sun.tools.javac.util.List;

/**
 * Servlet implementation class Viewbooking
 */
@WebServlet("/Viewbooking")
public class Viewbooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewbooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Bookings> bookings = new ArrayList<>();
        PreparedStatement ps ;
        ResultSet rs ;
        Connection con = null;

        
        try {
             con = myconnection.getConnection();
            if (con == null) {
                System.out.println("❌ Connection is null. Cannot fetch bookings.");
            }

            String query = "SELECT * FROM online_bookings";
             ps = con.prepareStatement(query);
             rs = ps.executeQuery();

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

            System.out.println("✅ Total bookings fetched: " + bookings.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Forward to JSP after data is fetched
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("viewbooking.jsp").forward(request, response);
    }
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
