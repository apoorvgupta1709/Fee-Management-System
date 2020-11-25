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

import adapter.CaeserCipher;
import adapter.Database;
import adapter.studentMethods;
import holder.studentParameter;



/**
 * Servlet implementation class addStudent
 */

@MultipartConfig
@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String Gender=request.getParameter("course");
		String course=request.getParameter("gender");
		String address=request.getParameter("address");
		String comment=request.getParameter("comment");
		//String email=CaeserCipher.encrypt(request.getParameter("email"),3);
		String email=request.getParameter("email");
		if(name==null ||Gender==null ||course==null ||address==null ||comment==null ||email==null )
		{
			out.print("plz fill all fields");
		}
		else
		{
			studentParameter p1=new  studentParameter(name,email,course,Gender,address,comment);
			
			
			
			 int status=studentMethods.save(p1);
			 if(status==0)
			 {
				 out.print("not updates");
			 }
			 else
				 {
				 Connection con=Database.getCon();
					try
					{
						
					studentMethods.getMax();
					
					PreparedStatement ps=con.prepareStatement("insert into fee(total,remaining,submitted,F_id) values(?,?,?,?)");
					ps.setInt(1,0);
					ps.setInt(2,0);	
					ps.setInt(4,0);
					ps.setInt(3,0);
				
					
					status=ps.executeUpdate();
					con.close();
					}
					catch(Exception e)
					{
						 out.print(e);

					}
				 out.print("saved successful");
				 }
		
		
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
