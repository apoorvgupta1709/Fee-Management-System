
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<%@page errorPage="error_page.jsp" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
      
   <%

int j=0;
try{
	j=Integer.parseInt((String)session.getAttribute("accountant"));
}
catch(Exception e)
{
	
}

if(j==0)
{
	response.sendRedirect("login.jsp");
}
System.out.print(j);


%>     
        
<meta charset="ISO-8859-1">
<title>Student details</title>
</head>
<body style="background-color:powderblue;">


<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true"  
     user="root"  password="1709"/>  

<sql:query dataSource="${db}" var="rs">  
SELECT id, name, email,course, submitted ,total  
   FROM student s, fee p  
   WHERE s.id =p.F_id;    
</sql:query>


<table border="2" width="100%">  
<tr>  
<th>Student ID</th>  
<th> Name</th>  
<th>email </th>  
<th>course</th> 
<th>total</th>  
<th>submitted</th>  
 
</tr>  

<c:forEach var="table" items="${rs.rows}"  >  
<tr>  
<td><c:out value="${table.id}"/></td>  
<td><c:out value="${table.name}"/></td>  
<td><c:out value="${table.email}"/></td>  
<td><c:out value="${table.course}"/></td> 
 <td><c:out value="${table.total}"/></td> 
 <td><c:out value="${table.submitted}"/></td> 
 

 
</tr>  
</c:forEach>  

</table>  

  


</body>
</html>