package travel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String email = (String) request.getSession().getAttribute("userEmail");

		if (email == null || email.isEmpty()) {
		    request.setAttribute("error", "No active session. Please login again.");
		    request.getRequestDispatcher("login.html").forward(request, response);
		    return;
		}

	        try {
	            Connection con = myconnection.getConnection();
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=?");
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                request.setAttribute("user_id", rs.getInt("user_id"));
	                request.setAttribute("name", rs.getString("name"));
	                request.setAttribute("email", rs.getString("email"));
	                request.setAttribute("phone", rs.getString("phone"));
	                request.setAttribute("city", rs.getString("city"));
	                request.setAttribute("created_at", rs.getString("created_at"));
	            }

	            rs.close();
	            ps.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("error", "Database error!");
	        }

	        request.getRequestDispatcher("profile.jsp").forward(request, response);
	        
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		 String userId = request.getParameter("userId");
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String city = request.getParameter("city");

	        try {
	            Connection con = myconnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "UPDATE users SET name=?, email=?, phone=?, city=? WHERE user_id=?"
	            );
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, phone);
	            ps.setString(4, city);
	            ps.setString(5, userId);

	            int rows = ps.executeUpdate();
	            ps.close();
	            con.close();

	            if (rows > 0) {
	            	 HttpSession session = request.getSession();
	                 session.setAttribute("name", name);
	                 session.setAttribute("email", email);
	                 session.setAttribute("phone", phone);
	                 session.setAttribute("city", city);
	                request.setAttribute("message", "Profile updated successfully!");
	            } else {
	                request.setAttribute("message", "Update failed!");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("message", "Error updating profile!");
	        }

	        doGet(request, response); 
	    }
	}


