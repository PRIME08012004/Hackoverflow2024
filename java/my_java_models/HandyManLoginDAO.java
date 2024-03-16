// login servlet mei bhi tahi code hai so iska koi use nahi hai dono same hai 
package my_java_models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class HandyManLoginDAO {
	// verify method is used to 
	public boolean verify(HandyMan handyman) throws ClassNotFoundException{
		
		boolean status = false ;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			// used to maintain simplicity 
			// url har class mein constant hai woh jdbc se connect karne ke liye use hoga 
			
			String url = "jdbc:mysql://localhost:3306/hackoverflow" ;
			// ye mysql ke passwords and username hai jo humko connnection banate time pass karna hai
			String username = "root" ;
			String password = "root" ;
			
			// used to connect to the database 
			Connection connection = DriverManager.getConnection(url,username,password);
			
			// add values to the database 
			java.sql.PreparedStatement ps = connection.prepareStatement("SELECT * FROM handyman WHERE Email = ? and Password = ? ");
			ps.setString(1, handyman.GetEmail());
			ps.setString(2, handyman.GetPassword());
			// ye executeQuery Query ke code ko run karta hai 
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
			
			connection.close();
			
			
		}catch(SQLException e) {
			// process sql exception 
			e.printStackTrace();
			
		}
		return status ;
	}

}
