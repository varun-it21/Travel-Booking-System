package travel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
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
		String name=request.getParameter("name");
		System.out.println(name);
		String mail=request.getParameter("email");
		System.out.println(mail);
		String phone=request.getParameter("phone");
		System.out.println(phone);
		String msg=request.getParameter("message");
		System.out.println(msg);
		
		PreparedStatement ps;
		try {
			String query="insert into contact_us (full_name,email,phone,message) values (?,?,?,?)";
			ps=myconnection.getConnection().prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,mail);
			ps.setString(3,phone);
			ps.setString(4,msg);
			int rows = ps.executeUpdate();

		    if (rows > 0) {
		    	 response.sendRedirect("home.html");
		    } else {
		    	response.getWriter().println("Booking failed. Please try again.");
		    }
		}catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}
		
	}

}
