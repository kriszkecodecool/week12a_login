package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (session.getAttribute("loggedin").equals(1)) {
            out.print("<b>Welcome to Profile</b>");  
            out.print("<br>Welcome, "+ session.getAttribute("name"));
            request.getRequestDispatcher("logout.html").include(request, response); 
		}
		else {
            out.print("Please login first");  
            }
		out.close();
	}
}
