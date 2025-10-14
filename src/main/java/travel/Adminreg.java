package travel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Adminreg
 */
@WebServlet("/Adminreg")
public class Adminreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminreg() {
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
		String email=request.getParameter("mail");
		System.out.println(email);
		String phone=request.getParameter("phone");
		System.out.println(phone);
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		
		PreparedStatement ps;
		try {
			
			String query="insert into admins (name,email,phone,password) values(?,?,?,?)";
			ps=myconnection.getConnection().prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,phone);
			ps.setString(4,pass);
			
			
			if(!pass.equals(cpass)) {
			    response.sendRedirect("adminreg.html?msg=fail");
			    return; 
			}
		
			if(ps.executeUpdate()>0) {
//				
				response.sendRedirect("adminlogin.html?msg=success");
//				
			}else {
				response.sendRedirect("register.html?msg=fail");
			}
		}
		catch(Exception ex) {
			 System.out.println("Error in Registeration");
	         response.sendRedirect("register.html?msg=error");
		}

	}

}
