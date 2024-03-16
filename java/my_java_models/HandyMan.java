package my_java_models;

public class HandyMan {
	// to store username and password 
	private String Username ;
	private String Password ;
	private String Email;
	private String Experience ;
	private String Address ;
	private String Service;
	private String Charges ;
	private String Phone ;
	
	
	
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
	public void SetExperience(String experience ) {
		Experience = experience ;
	}
	public void SetAddress(String address ) {
		Address = address  ;
	}
	public void SetService(String service ) {
		Service = service  ;
	}
	public void Setcharges(String charges ) {
		Charges = charges  ;
	}
	public void SetPhone(String phone ) {
		Phone = phone  ;
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
	public String GetExperience() {
		return Experience ;
	}
	public String GetAddress() {
		return Address ;
	}
	public String GetService() {
		return Service  ;
	}
	public String GetCharges() {
		return Charges  ;
	}
	public String GetPhone() {
		return Phone  ;
	}
	
}
