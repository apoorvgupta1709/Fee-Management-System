package h2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		PrintWriter out=rs.getWriter();   
		
		String email=rq.getParameter("email");
		String password=rq.getParameter("password");
		if(email.equals("admin1@gmail.com")&&password.equals("admin1")){
			HttpSession session=rq.getSession();
			session.setAttribute("admin","true");
			rq.getRequestDispatcher("adminhome.html").include(rq, rs);
		}
                else if(email.equals("admin2@gmail.com")&&password.equals("admin2")){
			HttpSession session=rq.getSession();
			session.setAttribute("admin","true");
			rq.getRequestDispatcher("adminhome.html").include(rq, rs);
                }
                else{
			out.println("<p>Sorry you are not a admin<br><br><b>Redirecting to home in 5 Seconds...</p>");
                        rs.setHeader("Refresh ", "5;url=index.html");
			
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
 
}
