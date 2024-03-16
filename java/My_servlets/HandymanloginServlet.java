package My_servlets;

import my_java_models.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class Customer_Login
 */
@WebServlet("/HandymanLogin")
public class HandymanloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandymanloginServlet() {
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
		// getparameter is used to take the values from the html pages 
		String Email = request.getParameter("email");
		String Password =  request.getParameter("password");
		String Phone = request.getParameter("phone");		
		// phone 
	    HandyMan handyman= new HandyMan();
	    handyman.SetEmail(Email);
	    handyman.SetPassword(Password);
		
		HandyManLoginDAO HLD = new HandyManLoginDAO();
		PrintWriter out = response.getWriter(); // basically no use 
		
	try {	
		if(HLD.verify(handyman)) {
			 
				// a session is created iske vajaah se har bande ka profile aaalag se dikhega means har web page ko pata chalega ki kisne login kiya hai  
		    	request.getSession().setAttribute("USER", Email);
				
			    // if successful then redirect user to this page
			RequestDispatcher rd = request.getRequestDispatcher("afterHandymanLogin.html");
			rd.forward(request, response);		
		}
		else 
		{
			// again we can write out.println to redirect  to the 
		out.println("<font color =red size = 18> login failed !! <br>");
		
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	
		doGet(request, response);
		}

}}
