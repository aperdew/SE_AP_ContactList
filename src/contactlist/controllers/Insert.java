package contactlist.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String             url              = "jdbc:mysql://ec2aperdew.ddns.net:3306/contactList";
	static String             user             = "Remote";
	static String             password         = "123";
	static Connection         connection       = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
		   response.getWriter().println("adding new contact");
		   System.out.println("new contact");
		   
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
		      response.getWriter().println("finished adding contact");		      
		      RequestDispatcher rd;
		      rd = request.getRequestDispatcher("Contacts");
		      rd.forward(request, response);
	}

}
