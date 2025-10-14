package travel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
		doGet(request, response);
		String pack=request.getParameter("package");
		System.out.println(pack);
		String name=request.getParameter("name");
		System.out.println(name);
		String mail=request.getParameter("email");
		System.out.println(mail);
		String phone=request.getParameter("phone");
		System.out.println(phone);
		String date=request.getParameter("date");
		System.out.println(date);
		String adult=request.getParameter("adult");
		System.out.println(adult);
		String child=request.getParameter("child");
		System.out.println(child);
		String req=request.getParameter("req");
		System.out.println(req);
		String price = request.getParameter("price");
		System.out.println(price);
		
		if (price != null) {
		    price = price.replace("₹", "").replace(",", "").trim();
		}
		
		PreparedStatement ps;
		try {
		    String query = "INSERT INTO	online_bookings	(package_name, full_name, email, phone, travel_date, adults, children, total_price, special_requests, booking_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		    ps = myconnection.getConnection().prepareStatement(query);
		    ps.setString(1, pack);    
		    ps.setString(2, name);     
		    ps.setString(3, mail);    
		    ps.setString(4, phone);   
		    ps.setString(5, date);    
		    ps.setString(6, adult);    
		    ps.setString(7, child);   
		    ps.setBigDecimal(8, new java.math.BigDecimal(price));  
		    ps.setString(9, req);     
		    ps.setString(10, "offline"); 

		    int rows = ps.executeUpdate();

		    if (rows > 0) {
		    	 response.sendRedirect("ads.html");
		    } else {
		    	response.getWriter().println("Booking failed. Please try again.");
		    }
		} catch (Exception ex) {
		    System.out.println("Error: " + ex.getMessage());
		}
	}

}
