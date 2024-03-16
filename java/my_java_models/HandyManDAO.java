package my_java_models ;
import java.sql.* ;

public class HandyManDAO{
	public int SignInCustomer(HandyMan handyman) throws ClassNotFoundException{
		
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
			
			HandymanDup HD = new HandymanDup();
			
			if(HD.Entry(handyman)) {
				result = 0 ;
			}
			
			else {
				// above line is used to add values to database 
				java.sql.PreparedStatement ps = connection.prepareStatement("INSERT INTO handyman "
				        + "(Name,Password ,Email ,Experience ,Address ,Services,Charges,phone)" // Removed extra comma
				        + "VALUES(?, ?, ?, ?, ?, ?, ?, ? );");

				ps.setString(1,handyman.GetUsername() );
				ps.setString(2,handyman.GetPassword() );
				ps.setString(3,handyman.GetEmail() );
				ps.setString(4,handyman.GetExperience());
				ps.setString(5,handyman.GetAddress() );
				ps.setString(6,handyman.GetService() );
				ps.setString(7,handyman.GetCharges() );
				ps.setString(8,handyman.GetPhone() );
				
				
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