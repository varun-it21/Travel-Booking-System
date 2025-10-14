package travel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
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
	     String action = request.getParameter("action");
		
		 try (Connection conn = myconnection.getConnection()) {
	            if ("search".equals(action)) {
	                String phone = request.getParameter("search_phone");

	                String sql = "SELECT * FROM online_bookings WHERE phone = ?";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setString(1, phone);
	                ResultSet rs = ps.executeQuery();

	                if (rs.next()) {
	                    request.setAttribute("package_name", rs.getString("package_name"));
	                    request.setAttribute("full_name", rs.getString("full_name"));
	                    request.setAttribute("email", rs.getString("email"));
	                    request.setAttribute("phone", rs.getString("phone"));
	                    request.setAttribute("travel_date", rs.getString("travel_date"));
	                    request.setAttribute("adults", rs.getInt("adults"));
	                    request.setAttribute("children", rs.getInt("children"));
	                    request.setAttribute("total_price", rs.getDouble("total_price"));
	                    request.setAttribute("special_requests", rs.getString("special_requests"));
	                } else {
	                    request.setAttribute("error", "❌ No booking found for phone: " + phone);
	                }

	                RequestDispatcher rd = request.getRequestDispatcher("editbooking.jsp");
	                rd.forward(request, response);

	            } else if ("update".equals(action)) {
	                // update booking
	                String packageName = request.getParameter("package_name");
	                String fullName = request.getParameter("full_name");
	                String email = request.getParameter("email");
	                String phone = request.getParameter("phone");
	                String travelDate = request.getParameter("travel_date");
	                int adults = Integer.parseInt(request.getParameter("adults"));
	                int children = Integer.parseInt(request.getParameter("children"));
	                double totalPrice = Double.parseDouble(request.getParameter("total_price"));
	                String specialRequests = request.getParameter("special_requests");

	                String sql = "UPDATE online_bookings SET package_name=?, full_name=?, email=?, travel_date=?, adults=?, children=?, total_price=?, special_requests=? WHERE phone=?";
	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setString(1, packageName);
	                ps.setString(2, fullName);
	                ps.setString(3, email);
	                ps.setString(4, travelDate);
	                ps.setInt(5, adults);
	                ps.setInt(6, children);
	                ps.setDouble(7, totalPrice);
	                ps.setString(8, specialRequests);
	                ps.setString(9, phone);

	                int rows = ps.executeUpdate();

	                if (rows > 0) {
	                    request.setAttribute("success", "✅ Booking updated successfully!");
	                } else {
	                    request.setAttribute("error", "❌ Failed to update booking");
	                }

	                RequestDispatcher rd = request.getRequestDispatcher("editbooking.jsp");
	                rd.forward(request, response);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("error", "⚠️ Server error: " + e.getMessage());
	            RequestDispatcher rd = request.getRequestDispatcher("editbooking.jsp");
	            rd.forward(request, response);
	        }
	    }
	}

