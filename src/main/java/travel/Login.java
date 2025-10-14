package travel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String mail=request.getParameter("email");
		System.out.println(mail);
		String pass=request.getParameter("pass");
		System.out.println(pass);
		
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			
			String query="select * from users where email=? and password=?";
			ps=myconnection.getConnection().prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				 HttpSession session = request.getSession();
	                session.setAttribute("user_id", rs.getInt("user_id"));
	                session.setAttribute("name", rs.getString("name"));
	                session.setAttribute("email", rs.getString("email"));
	                session.setAttribute("phone", rs.getString("phone"));
	                session.setAttribute("city", rs.getString("city"));
	                session.setAttribute("created_at", rs.getString("created_at"));

	                // ✅ Redirect to profile.jsp instead of home.html
	                response.sendRedirect("home.html");
		}else {
			response.sendRedirect("login.html?msg=fail");
		}
		}	
		catch(Exception ex) {
			
		}
	}

}
