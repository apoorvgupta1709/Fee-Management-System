package servletss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapter.studentMethods;
import holder.studentParameter;

/**
 * Servlet implementation class update
 */


@MultipartConfig
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int roll=Integer.parseInt(request.getParameter("roll"));
		
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String Gender=request.getParameter("gender");
		String course=request.getParameter("course");
		String address=request.getParameter("address");
		String comment=request.getParameter("comment");
		
		if(name==null ||Gender==null ||course==null ||address==null ||comment==null ||email==null   )
		{
			out.print("plz fill all fields");
		}
		else
		{
			studentParameter p1=new  studentParameter(roll,name,email,course,Gender,address,comment);
			int status=studentMethods.update(p1);

			if(status!=0)
			{
				out.print("update successful");
			}
			else
				out.print("not update possible");
		
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
