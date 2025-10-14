package travel;

import jakarta.servlet.RequestDispatcher;
import java.util.List;       
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.ArrayList;

//import com.sun.tools.javac.util.List;

/**
 * Servlet implementation class Query
 */
@WebServlet("/Query")
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 List<UserQuery> UserQuery = new ArrayList<>();

	        try (Connection conn = myconnection.getConnection()) {
	            String sql = "SELECT * FROM enquiries";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                UserQuery q = new UserQuery(
	                    rs.getInt("enquiry_id"),
	                    rs.getString("name"),
	                    rs.getString("city"),
	                    rs.getString("email"),
	                    rs.getString("phone"),
	                    rs.getString("travel_destination"),
	                    rs.getDate("travel_date"),
	                    rs.getInt("number_of_people"),
	                    rs.getString("vacation_type"),
	                    rs.getDate("enquiry_date")
	                );
	                UserQuery.add(q);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("error", "Unable to fetch queries: " + e.getMessage());
	        }

	        request.setAttribute("UserQuery",UserQuery);
	        RequestDispatcher rd = request.getRequestDispatcher("quries.jsp");
	        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
