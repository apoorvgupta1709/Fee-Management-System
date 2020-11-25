package servletss;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapter.Database;
import adapter.accountantMethods;
import adapter.studentMethods;



/**
 * Servlet implementation class studentLogin
 */
@MultipartConfig
@WebServlet("/studentLogin")
public class studentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public studentLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try
		{
			String name=request.getParameter("emails");
			String idF=request.getParameter("passS");
			String id=idF.substring(2);

			String type=request.getParameter("gender");
			
			
			  if(name==null || idF==null ||type==null ) { out.print("fill all fields"); }
			 

			if(type.equals("student") && idF.substring(0, 2).equals("ST"))
			{

				boolean status=studentMethods.validate(name, id);
				if(status)
				{
					HttpSession session=request.getSession();
					session.setAttribute("student",id);
					request.getRequestDispatcher("Student_W_Login.jsp").include(request, response);
				}else
				{


//					HttpSession s = request.getSession();
//					s.setAttribute("msg", "sorry username doesnt exist");
					request.getRequestDispatcher("login.jsp").include(request, response);
				}

			}



			else if(type.equals("accountant")&& idF.substring(0, 2).equals("AC"))
			{

				boolean status=accountantMethods.validate(name, id);

				if(status)
				{
					HttpSession session=request.getSession();
					session.setAttribute("accountant",id);
					request.getRequestDispatcher("Accountant_first_page.jsp").include(request, response);
				}
				else
				{
					out.println("<p>Sorry, username or password error!</p>");

//					HttpSession s = request.getSession();
//					s.setAttribute("msg", "sorry username doesnt exist");
					request.getRequestDispatcher("login.jsp").include(request, response);
				}
			}
			else if(type.equals("admin") && idF.substring(0,2).equals("AD"))
			{

				boolean status;
				Connection con=Database.getCon();
				PreparedStatement ps=con.prepareStatement("select * from admin where email=? AND id=? ");
				ps.setString(1,name);
				ps.setString(2,id);

				ResultSet rs=ps.executeQuery();
				status=rs.next();

				con.close();
				if(status)
				{
					HttpSession session=request.getSession();
					session.setAttribute("admin",id);
					request.getRequestDispatcher("AdminHome.jsp").include(request, response);

				}
				else
				{
					request.getRequestDispatcher("register_page.jsp").include(request, response);

				}
				

			}
			else
			{
				request.getRequestDispatcher("login.jsp").include(request, response);

			}
		}
		catch(Exception e)
		{


			request.getRequestDispatcher("login.jsp").include(request, response);


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
