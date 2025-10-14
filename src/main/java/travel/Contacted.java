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

/**
 * Servlet implementation class Contacted
 */
@WebServlet("/Contacted")
public class Contacted extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacted() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 List<Contacts> contacts = new ArrayList<>();

	        try (Connection conn = myconnection.getConnection()) {
	            String sql = "SELECT * FROM contact_us";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Contacts c = new Contacts();
	                c.setContactId(rs.getInt("contact_id"));
	                c.setUserId(rs.getInt("user_id"));
	                c.setFullName(rs.getString("full_name"));
	                c.setEmail(rs.getString("email"));
	                c.setPhone(rs.getString("phone"));
	                c.setMessage(rs.getString("message"));
	                c.setCreatedAt(rs.getString("created_at"));
	                contacts.add(c);
	            }

	            request.setAttribute("contacts", contacts);
	            RequestDispatcher rd = request.getRequestDispatcher("contacted.jsp");
	            rd.forward(request, response);

	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("error", "Unable to fetch contacted records: " + e.getMessage());
	            request.getRequestDispatcher("contacted.jsp").forward(request, response);
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
