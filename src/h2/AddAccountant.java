package h2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;



@WebServlet("/AddAccountant")
@MultipartConfig
public class AddAccountant extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException
    {
            try  {
                
           String a=rq.getParameter("name");
           String b=rq.getParameter("email");
           String c=rq.getParameter("gender");
           String d=rq.getParameter("mobile");
           String e=rq.getParameter("check");
           PrintWriter out=rs.getWriter();

           if(a==null ||b==null ||c==null ||d==null ||e==null )
        	   out.print("Fill All details");
           else
           {
           rs.setContentType("text/html");
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true","root","1709");
          PreparedStatement ps=con.prepareStatement("insert into accountant(name,email,gender,mobile) values(?,?,?,?)");
           ps.setString(1,a);
           ps.setString(2,b);
           ps.setString(3,c);
           ps.setString(4,d);
       
           ps.executeUpdate();
           out.print("done");
           }
           
//           out.println("<p>Accountant Added <br>Redirecting You to Homepage in 5 seconds</p>");
//           rs.setHeader("Refresh ", "5;url=index.html");
                  }
    catch(Exception e)
    {
      PrintWriter out=rs.getWriter();

        out.print(e);
    }

    }
}
