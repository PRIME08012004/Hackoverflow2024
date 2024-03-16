package My_servlets;
import my_java_models.* ;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Customer_SignUp
 */
@WebServlet("/HandymanSignUp")
public class HandymanSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandymanSignInServlet() {
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
		    HandyManDAO HD = new HandyManDAO();  // two classes ke objects create kiye 
		    HandyMan handyman = new HandyMan();
		    System.out.println("servlet connected successfully ");  
			int i = 0 ;
			// used to take values from html textfield signup page 
			String Username = request.getParameter("name");
			String Address = request.getParameter("address");
			String Email = request.getParameter("email");
			String Password = request.getParameter("password");
			String Experience = request.getParameter("experience");
			String Service = request.getParameter("service");
			String Charges = request.getParameter("charges");
			String phone = request.getParameter("phone");
			
			handyman.SetUserName(Username);
			handyman.SetPassword(Password);
			handyman.SetEmail(Email);
			handyman.SetExperience(Experience);
			handyman.SetAddress(Address);
			handyman.SetService(Service);
			handyman.Setcharges(Charges);
			handyman.SetPhone(phone);
			
			
			try {
			// SignInCustomer returns the values stored in database if there is no dublicate entry 
				 i = HD.SignInCustomer(handyman);
				
			}catch(ClassNotFoundException e ) {
				e.printStackTrace();
			}
			// if signup is successfull then goTo login page  
			if(i>0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("handymanlogin.html");
				dispatcher.forward(request, response);

			}
			// SignIn is unsuccessfull so again goback to login page 
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("handymansignup.html");
				dispatcher.forward(request, response);
			}
		doGet(request, response);
		
	}

}
