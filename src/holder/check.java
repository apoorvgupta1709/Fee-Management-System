package holder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;



@WebServlet("/check")
public class check extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{

		

		String a=request.getParameter("name");
		String b=request.getParameter("age");
		String c=request.getParameter("email");
		PrintWriter pw=response.getWriter();


		Connection con =null;
		
		try

		
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true","root","1709");
			Statement st= con.createStatement();
			String querry=" create table pqr(name varchar(20), age varchar(20),email varchar(20),password varchar(20))";
//			String qy="select * from pop";
			st.executeUpdate(querry);
//			PreparedStatement ps=con.prepareStatement("select * from pop");  
//			ps.setString(1, request.getParameter("name"));
//			ResultSet r=ps.executeQuery();  
			
//			String querry=" create table dataStore(name varchar(20), age varchar(20),email varchar(20),password varchar(20))";

			
//			pw.print("<tr>");  
//		
//			if(r.next())
//			{
//				pw.print(r.getString(0));
//			}
			
			//st.executeUpdate(querry);
			
//			insert into pope(name,phone,email) values('"+a+","+b+","+c+"')
			
//autoReconnect=true&useSSL=false
		}



		catch (Exception e)
		{
			pw.print(e);

		}
	//	jdbc:mysql://localhost:3306/cse?autoReconnect=true&useSSL=false

		//jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true
	}

}
