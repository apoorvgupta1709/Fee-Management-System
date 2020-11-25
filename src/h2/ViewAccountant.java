package h2;
import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import java.sql.*;  
    
@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html><body>");  
         try 
         {  
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true","root","1709");
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from accountant");  
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>Acc_ID</th><th>Name</th><th>Password</th><th>Address</th><th>Email</th><th>Contact</th></tr>");  
             while (rs.next()) 
             {  
                 String a = rs.getString("id");  
                 String b = rs.getString("name");  
                 String c = rs.getString("email");
                 String d = rs.getString("gender");
                 String e = rs.getString("mobile");
                // String f = rs.getString("Contact"); 
                 out.println("<tr><td>" + a + "</td><td>" + b + "</td><td>" + c + "</td><td>" + d +"</td><td>" + e + "</td><td>" );   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  