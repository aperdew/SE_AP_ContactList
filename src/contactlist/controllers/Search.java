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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String             url              = "jdbc:mysql://ec2aperdew.ddns.net:3306/contactList";
	static String             user             = "Remote";
	static String             password         = "123";
	static Connection         connection       = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		List<contactModel> contactList = new ArrayList<>();
		String searchQuery = request.getParameter("searchQuery").trim();
		String[] queryTokens = searchQuery.split(" ");
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
	    	  String selectSQL = null;
	    	  if(queryTokens.length==1){
		         selectSQL = "SELECT * FROM contacts "
	         		+ "WHERE FIRSTNAME  LIKE '" + searchQuery+"%' OR LASTNAME  LIKE '" + searchQuery+"%'";
	    	  }else{
	    		  selectSQL = "SELECT * FROM contacts "
	  	         		+ "WHERE FIRSTNAME  LIKE '" + queryTokens[0]+"%' OR LASTNAME  LIKE '" + queryTokens[0]+"%' "
         				+ "OR FIRSTNAME  LIKE '" + queryTokens[1]+"%' OR LASTNAME  LIKE '" + queryTokens[1]+"%';";
	    	  }
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
	        	contact.setId(rs.getInt("id"));
	            contactList.add(contact);
	            
	         }
	         
	         request.setAttribute("contactList", contactList);
	         RequestDispatcher rd;
	         
	         if(contactList.size()>1){
	        	 rd = request.getRequestDispatcher("/ContactList.jsp");
	         } else{
	        	 if(contactList.size()==0){
	        		 System.out.println("No results returned");
	        		 rd = request.getRequestDispatcher("/Contacts");
	        	 } else{
		        	 System.out.println("One search result returned");
		        	 request.setAttribute("contact", contactList.get(0));
		        	 rd = request.getRequestDispatcher("EditContact.jsp");
	        	 }
	        	 
	         }      
	                 
	         rd.forward(request, response);
	         
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
