
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost:3306/apo?verifyServerCertificate=false&useSSL=true"  
     user="root"  password="1709"/>  

<sql:query dataSource="${db}" var="rs">  
SELECT * from student;  
</sql:query>

<table border="2" width="100%">  
<tr>  
<th>Student ID</th>  
<th>First Name</th>  
<th>Last Name</th>  
<th>Age</th>  
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.id}"/></td>  
<td><c:out value="${table.name}"/></td>  
<td><c:out value="${table.email}"/></td>  
<td><c:out value="${table.course}"/></td> 
<td><c:out value="${table.gender}"/></td> 
<td><c:out value="${table.contact}"/></td>  
<td><c:out value="${table.contact}"/></td>  
<td><c:out value="${table.contact}"/></td>  
<td><c:out value="${table.contact}"/></td>  
<td><c:out value="${table.contact}"/></td>  
 
 
</tr>  
</c:forEach>  
</table>  

  
  
<%-- <!-- core tag implementation-->
<c:set var="test" value="2" />  
  <c:if test="${test<1}">  
     <c:redirect url="http://www.google.com"/>  
  </c:if>  
  <c:if test="${test>1}">  
 
       <c:out value="doing"></c:out>
  </c:if>  
  <c:set var="String" scope="session" value="true"/>  
<p>First <c:out value="${String}"/></p>  
<c:remove var="income"/>  
<p>Second  <c:out value="${String}"/></p>  --%> 


</body>
</html>