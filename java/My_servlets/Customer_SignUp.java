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
@WebServlet("/CustomerSignUp")
public class Customer_SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_SignUp() {
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
		    CustomerDAO CD = new CustomerDAO();  // two classes ke objects create kiye 
		    Customer customer = new Customer();
		    System.out.println("servlet connected successfully ");  
			int i = 0 ;
			// used to take values from html textfield signup page 
			String Username = request.getParameter("name");
			String Password = request.getParameter("password");
			String Email = request.getParameter("email");
			String Fullname = request.getParameter("fullname");
			String PostalCode = request.getParameter("postal");
			String Address = request.getParameter("address1");
			String State = request.getParameter("state");
			String City = request.getParameter("city");
			    
			
			customer.SetUserName(Username);
			customer.SetPassword(Password);
			customer.SetEmail(Email);
			customer.SetFullname(Fullname);
			customer.SetPostalCode(PostalCode);
			customer.SetAddress(Address);
			customer.SetState(State);
			customer.SetCity(City);
			
			try {
			// SignInCustomer returns the values stored in database if there is no dublicate entry 
				 i = CD.SignInCustomer(customer);
				
			}catch(ClassNotFoundException e ) {
				e.printStackTrace();
			}
			// if signup is successfull then goTo login page  
			if(i>0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("customerlogin.html");
				dispatcher.forward(request, response);

			}
			// SignIn is unsuccessfull so again goback to login page 
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("customerlsignup.html");
				dispatcher.forward(request, response);
			}
		doGet(request, response);
		
	}

}
