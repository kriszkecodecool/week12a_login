package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("admin") && password.equals("test1234")) {
			if(session.getAttribute("name") == null)
			{
				session.setAttribute("name", username);
				session.setAttribute("loggedin", 1);
				String name = (String) session.getAttribute("name");
				out.print("Welcome" + " " + name + "Have a nice day!");
				request.getRequestDispatcher("logout.html").include(request, response); 
			}
			else
			{
				out.print("You are already logged in.");
				request.getRequestDispatcher("logout.html").include(request, response); 
			}
		}
		else {
			out.print("Invalid username or password. Permission denied.");
		}
	}

}
