package contactlist.pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewContact
 */
@WebServlet("/NewContact")
public class NewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<link rel=\"stylesheet\" href=\"Site.css\"/>");
		response.getWriter().println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css\"/>");
		response.getWriter().println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js\"></script>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<div class=\"container\">");
		response.getWriter().println("		<h1 class=\"CL-NewContact--Title\">New Contact</h1>");
		response.getWriter().println("		<div class=\"row\">");
		response.getWriter().println("			<label class =\"pull-left\">First Name</label>");
		response.getWriter().println("		</div>");
		response.getWriter().println("		<div class=\"row\">");
		response.getWriter().println( "			<input type=\"text\"/>");
		response.getWriter().println("		</div>");
		response.getWriter().println("</div>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
