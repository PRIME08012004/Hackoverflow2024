<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String User=(String)request.getSession().getAttribute("USER");
if(User==null)
{
	response.sendRedirect("LoginPage.html");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<%
		String Email,Name,password, Fullname, address,PostalCode;
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
		
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/air_ticket_booking","root","root");
			
			java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE Email ='"+User+"' ");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Email = rs.getString("Email");
				Name = rs.getString("Name");
				password = rs.getString("Password");
				Fullname = rs.getString("Fullname");
				address = rs.getString("Address");
				PostalCode = rs.getString("PostalCode");
				%>
				
				<p>Email : <%=Email%> </p>
				<p>Username   : <%=Name%> </p>
				<p>Password   :<%=password%> </p>
				<p>Fullname   : <%=Fullname%> </p>
				<p>Address    :<%=address%> </p>
				<p>PostalCode : <%=PostalCode%> </p>
				
				<hr>
				<br>
				<%			
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</div>

</body>
</html>