
package my_java_models ;
import java.sql.* ;

public class CustomerDAO{
	public int SignInCustomer(Customer customer) throws ClassNotFoundException{
		
		int result = 0; 
		// loads mysql jdbc driver from memory 
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			// these three lines are used to simplify the program 
			// url har class mein constant hai woh jdbc se connect karne ke liye use hoga 
			String url = "jdbc:mysql://localhost:3306/hackoverflow" ;
			// ye mysql ke passwords and username hai jo humko connnection banate time pass karna hai. done for  sake simplicity
			String username = "root" ;
			String password = "root" ;
			
			// this line is used to set connection to the data base using connection Object 
			Connection connection = DriverManager.getConnection(url,username,password);
			
			DuplicateEntry DE = new DuplicateEntry();
			
			if(DE.Entry(customer)) {
				result = 0 ;
			}
			
			else {
				// above line is used to add values to database 
				java.sql.PreparedStatement ps = connection.prepareStatement("INSERT INTO customer "
						+ "(Email, Name, Password, Fullname, Address, PostalCode,stateprovince,City)"
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ? );");
				ps.setString(1, customer.GetEmail());
				ps.setString(2, customer.GetUsername());
				ps.setString(3, customer.GetPassword());
				ps.setString(4, customer.GetFullname());
				ps.setString(5, customer.GetAddress());
				ps.setString(6, customer.GetPostalcode());
				ps.setString(7, customer.GetState());
				ps.setString(8, customer.GetCity());
				
				// to update/insert Query or to add data in the database 
				result = ps.executeUpdate();
			}
			// used to close the database connection 
			connection.close();
			
		}catch(SQLException e ) {
			// process SQL Exception 
			e.printStackTrace();
		}
		
		return result ;
	}
}