package travel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String phone=request.getParameter("phone");
		System.out.println(phone);
		String email=request.getParameter("mail");
		System.out.println(email);
		String city=request.getParameter("city");
		System.out.println(city);
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		
		PreparedStatement ps;
		try {
			
			String query="insert into users (name,email,phone,city,password) values(?,?,?,?,?)";
			ps=myconnection.getConnection().prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,phone);
			ps.setString(4,city);
			ps.setString(5,pass);
			
			
			if(!pass.equals(cpass)) {
			    response.sendRedirect("register.html?msg=fail");
			    return; 
			}
		
			if(ps.executeUpdate()>0) {
//				
				response.sendRedirect("login.html?msg=success");
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
