
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<%@page errorPage="error_page.jsp" %>
 <%@ page import = "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.io.PrintWriter,java.sql.Connection,java.sql.DriverManager"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
      
   <%
/* 
int j=0;
try{
	j=Integer.parseInt((String)session.getAttribute("admin"));
}
catch(Exception e)
{

}

if(j==0)
{
	response.sendRedirect("login.jsp");
}
System.out.print(j);
 */

%>     
        
<meta charset="ISO-8859-1">
<title>Student details</title>
</head>
<body style="background-color:powderblue;">


<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true"  
     user="root"  password="1709"/>  

<sql:query dataSource="${db}" var="rs">  
SELECT id, name, email,course, submitted ,total ,remaining 
   FROM student s, fee p  
   WHERE s.id =p.F_id;    
</sql:query>



<%
PrintWriter out2 = response.getWriter();  
response.setContentType("text/html");  
try 
{  
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true","root","1709");
 	PreparedStatement ps=con.prepareStatement("select SUM(submitted) FROM fee ");
    ResultSet rs = ps.executeQuery();  
    int a=0;
    while (rs.next()) 
    {  
         a = rs.getInt(1);  
     
       // out.println( "<h1>"+ " Total Fee Received :  " + a + "</h1>" );   
    }  
     
    
	PreparedStatement ps2=con.prepareStatement("select SUM(remaining) FROM fee ");
    ResultSet rs2 = ps2.executeQuery();  
    int b=0;
    while (rs2.next()) 
    {  
        b= rs2.getInt(1);  
     
       // out.println( "<h1>"+ " Total Fee remaining :  " + a + "</h1>" );   
    }  
    out.println("<h1>"+ " Total Fee Received :  " +  a +"</h1>"+   "<h1>"+ " Total Fee remaining :  " + b+ "</h1>" );   

    
    con.close();  
   }  
    catch (Exception e) 
   {  
   }  



%>


<table border="2" width="100%">  
<tr>  
<th>Student ID</th>  
<th> Name</th>  
<th>email </th>  
<th>course</th> 
<th>total</th>  
<th>remaining</th>  
<th>submitted</th>  
 
</tr>  

<c:forEach var="table" items="${rs.rows}"  >  
<tr>  
<td><c:out value="${table.id}"/></td>  
<td><c:out value="${table.name}"/></td>  
<td><c:out value="${table.email}"/></td>  
<td><c:out value="${table.course}"/></td> 
 <td><c:out value="${table.total}"/></td> 
  <td><c:out value="${table.remaining}"/></td> 
 <td><c:out value="${table.submitted}"/></td> 
 

 
</tr>  
</c:forEach>  

</table>  

  


</body>
</html>