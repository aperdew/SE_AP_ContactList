package contactlist.pages;

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

@WebServlet("/ContactAccessor")
public class ContactList extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static String             url              = "jdbc:mysql://ec2aperdew.ddns.net:3306/contactList";
	static String             user             = "Remote";
	static String             password         = "123";
	static Connection         connection       = null;
	
	public ContactList(){
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
	         //response.getWriter().println(selectSQL + "<br>");
	         response.getWriter().println("------------------------------------------<br>");
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
	            contactList.add(contact);
	         }
	         response.getWriter().print(contactList);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }            		
	}
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      doGet(request, response);
	   }
}
