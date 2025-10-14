package travel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Adminlog
 */
@WebServlet("/Adminlog")
public class Adminlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminlog() {
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
		String mail=request.getParameter("mail");
		System.out.println(mail);
		String pass=request.getParameter("pass");
		System.out.println(pass);
		
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			
			String query="select * from admins where email=? and password=?";
			ps=myconnection.getConnection().prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				response.sendRedirect("admin.html?msg=success");
				RequestDispatcher rd=request.getRequestDispatcher("admin.html");
				rd.forward(request, response);
		}else {
			response.sendRedirect("adminlogin.html?msg=fail");
		}
		}	
		catch(Exception ex) {
			
		}
	}

}
