package my_java_models;

public class Customer {
	// to store username and password 
	private String Username ;
	private String Password ;
	private String Email;
	private String Fullname ;
	private String Address ;
	private String PostalCode ;
	private String State ;
	private String City ;
	    
	
	
	
// we created two getters  to store the data 	
	public void SetUserName(String username ) {
		Username = username  ;
	}
	public void SetPassword(String password) {
		Password = password ;
	}
	public void SetEmail(String email ) {
		Email = email  ;
	}
	public void SetFullname(String fullname ) {
		Fullname = fullname  ;
	}
	public void SetPostalCode(String postalcode ) {
		PostalCode = postalcode  ;
	}
	public void SetAddress(String address ) {
		Address = address  ;
	}
	public void SetState(String state ) {
	    State = state  ;
	}
	public void SetCity(String city ) {
		City = city  ;
	}
// create setters to return the values 
	public String GetUsername() {
		return Username ;
	}
	public String GetPassword() {
		return Password ;
	}
	public String GetEmail() {
		return Email ;
	}
	public String GetFullname() {
		return Fullname ;
	}
	public String GetAddress() {
		return Address ;
	}
	public String GetPostalcode() {
		return PostalCode  ;
	}
	public String GetState() {
		return State  ;
	}
	public String GetCity() {
		return City  ;
	}
}
