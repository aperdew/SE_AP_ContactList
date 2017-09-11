package contactlist.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactlist.models.contactModel;

/**
 * Servlet implementation class GetById
 */
@WebServlet("/GetById")
public class GetById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String             url              = "jdbc:mysql://ec2aperdew.ddns.net:3306/contactList";
	static String             user             = "Remote";
	static String             password         = "123";
	static Connection         connection       = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
	     
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
	         String selectSQL = "SELECT * FROM contacts "
	         		+ "WHERE id = "+id+";";
	         //String theUserName = "Aaron";
	         PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
	         //preparedStatement.setString(1, theUserName);
	         ResultSet rs = preparedStatement.executeQuery();	        	 
	         contactModel contact = new contactModel();
	         while (rs.next()) {
	        	 
	        	contact.setFirstName(rs.getString("FIRSTNAME"));
	        	contact.setLastName(rs.getString("LASTNAME"));
	        	contact.setPhone(rs.getString("PHONE"));
	        	contact.setEmail(rs.getString("EMAIL"));
	        	contact.setAddress(rs.getString("ADDRESS"));
	        	contact.setId(rs.getInt("id"));
	         }
	         
	         request.setAttribute("contact", contact);
	         RequestDispatcher rd;
	         rd = request.getRequestDispatcher("/EditContact.jsp");
	         rd.forward(request, response);
	         
	         //put all of the info from SQL into table
	         //make buttons for navigating to new contact, edit contacts, and 
	         //search contacts
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }            		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
