package h2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@MultipartConfig
@WebServlet("/DeleteAccountant")
public class DeleteAccountant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
    {
       try
       {
           rs.setContentType("text/html");
           PrintWriter out=rs.getWriter();
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true","root","1709");
           PreparedStatement st=con.prepareStatement("delete from accountant  where email=?");
           st.setString(1,rq.getParameter("t1"));
           int i=st.executeUpdate();
           if(i>0)
              out.print("Record Deleted successfully");
          
           else
               out.print("Record Not Exist" );


// rq.getRequestDispatcher("index.html").include(rq, rs);
           
       }
       catch(Exception e)
       {
        System.out.println(e);   
       }
    }
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs){
    	doGet(rq,rs);
    }

    
    

}
