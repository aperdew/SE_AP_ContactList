package contactlist.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import contactlist.models.contactModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ContactList")
public class DisplayAll_Insert extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static String             url              = "jdbc:mysql://ec2aperdew.ddns.net:3306/contactList";
	static String             user             = "Remote";
	static String             password         = "123";
	static Connection         connection       = null;
	
	public DisplayAll_Insert(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html;charset=UTF-8");
	      List<contactModel> contactList = new ArrayList<>();
	     
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	    	  e.printStackTrace();
	      }
      		connection = null;
	      try {
	         connection = DriverManager.getConnection(url, user, password);
	      } catch (SQLException e) {
	    	  System.out.print("Bad URL");
	         e.printStackTrace();
	      }
	      if (connection != null) {
	      } else {
	         System.out.println("Failed to make connection!");
	      }
	      try {
	         String selectSQL = "SELECT * FROM contacts;";
	         //String theUserName = "Aaron";
	         PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
	         //preparedStatement.setString(1, theUserName);
	         ResultSet rs = preparedStatement.executeQuery();
	         while (rs.next()) {

		        contactModel contact = new contactModel();
	        	contact.setFirstName(rs.getString("FIRSTNAME"));
	        	contact.setLastName(rs.getString("LASTNAME"));
	        	contact.setPhone(rs.getString("PHONE"));
	        	contact.setEmail(rs.getString("EMAIL"));
	        	contact.setAddress(rs.getString("ADDRESS"));
	            contactList.add(contact);
	         }
	         
	         request.setAttribute("contactList", contactList);
	         request.getRequestDispatcher("/ContactList.jsp");
	         
	         //put all of the info from SQL into table
	         //make buttons for navigating to new contact, edit contacts, and 
	         //search contacts
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }            		
	}
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html;charset=UTF-8");
	   
	   String firstName = request.getParameter("firstName");
	   String lastName = request.getParameter("lastName");
	   String phone = request.getParameter("phone");
	   String email = request.getParameter("email");
	   String address = request.getParameter("address");
	     
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	    	  e.printStackTrace();
	      }
   		connection = null;
	      try {
	         connection = DriverManager.getConnection(url, user, password);
	      } catch (SQLException e) {
	    	  System.out.print("Bad URL");
	         e.printStackTrace();
	      }
	      if (connection != null) {
	      } else {
	         System.out.println("Failed to make connection!");
	      }
	      try {
	         String selectSQL = "INSERT INTO contacts(FIRSTNAME, LASTNAME, PHONE, EMAIL, ADDRESS)"
	         		+ "VALUES ('" + firstName + "', '" + lastName + "', '" + phone + "', '" + email +"', '" + address +"');";
	         //String theUserName = "Aaron";
	         PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
	         //preparedStatement.setString(1, theUserName);
	         preparedStatement.executeUpdate();
	        	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	      
	      doGet(request, response);
	   }
}
