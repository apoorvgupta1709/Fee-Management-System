<%@page import="paytm_java.PaytmConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.paytm.pg.merchant.CheckSumServiceHelper"%>    

<%@ page import="java.sql.Connection" %>
<%@ page import="adapter.Database" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page errorPage="error_page.jsp" %>  

<%

Enumeration<String> paramNames = request.getParameterNames();
Map<String, String[]> mapData = request.getParameterMap();
TreeMap<String,String> parameters = new TreeMap<String,String>();
String paytmChecksum =  "";
while(paramNames.hasMoreElements()) {
	String paramName = (String)paramNames.nextElement();
	parameters.put(paramName,mapData.get(paramName)[0]);	
}

HttpSession session2=request.getSession(false);  
 //ck[0].getValue();  
 String n=(String)session.getAttribute("student");  


String a=request.getParameter("TXN_AMOUNT");
Connection con=Database.getCon();
PreparedStatement ps1=con.prepareStatement("select submitted from fee where F_id=?");
ps1.setString(1,n);	
ResultSet rs=ps1.executeQuery();

int f=0;
while(rs.next()){

	 f=Integer.parseInt(rs.getString(1));
}

/* 
PreparedStatement ps3=con.prepareStatement("select remaining from fee where F_id=?");
ps3.setString(1,n);	
ResultSet rs3=ps3.executeQuery();
int remaining=0;
while(rs3.next()){

	remaining=Integer.parseInt(rs3.getString(1));
} */

PreparedStatement ps6=con.prepareStatement("select total from fee where F_id=?");
ps6.setString(1,n);	
ResultSet rs6=ps6.executeQuery();
int total=0;
while(rs6.next()){

	total=Integer.parseInt(rs6.getString(1));
}
int sum= f + Integer.parseInt(a);


PreparedStatement ps=con.prepareStatement("update  fee set submitted=? where F_id =?");
ps.setString(1, Integer.toString(sum));
ps.setString(2,n);	
int status=ps.executeUpdate();

int remain2=total-sum;
if(remain2<0)
{
	remain2=0;
}

PreparedStatement ps4=con.prepareStatement("update  fee set remaining=? where F_id =?");
ps4.setString(1, Integer.toString(remain2));
ps4.setString(2,n);	
int status2=ps4.executeUpdate();

System.out.print(remain2+sum+total);

con.close();



parameters.put("MID",PaytmConstants.MID);
parameters.put("CHANNEL_ID",PaytmConstants.CHANNEL_ID);
parameters.put("INDUSTRY_TYPE_ID",PaytmConstants.INDUSTRY_TYPE_ID);
parameters.put("WEBSITE",PaytmConstants.WEBSITE);
parameters.put("MOBILE_NO","7777777777");
parameters.put("EMAIL","test@gmail.com");
parameters.put("CALLBACK_URL", "http://localhost:8080//Fee_Management_System_J2EE_Project/pgResponse.jsp");


String checkSum =  CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(PaytmConstants.MERCHANT_KEY, parameters);


StringBuilder outputHtml = new StringBuilder();
outputHtml.append("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
outputHtml.append("<html>");
outputHtml.append("<head>");
outputHtml.append("<title>Merchant Check Out Page</title>");
outputHtml.append("</head>");
outputHtml.append("<body>");
outputHtml.append("<center><h1>Please do not refresh this page...</h1></center>");
outputHtml.append("<form method='post' action='"+ PaytmConstants.PAYTM_URL +"' name='f1'>");
outputHtml.append("<table border='1'>");
outputHtml.append("<tbody>");

for(Map.Entry<String,String> entry : parameters.entrySet()) {
	String key = entry.getKey();
	String value = entry.getValue();
	outputHtml.append("<input type='hidden' name='"+key+"' value='" +value+"'>");	
}	  
	  


outputHtml.append("<input type='hidden' name='CHECKSUMHASH' value='"+checkSum+"'>");
outputHtml.append("</tbody>");
outputHtml.append("</table>");
outputHtml.append("<script type='text/javascript'>");
outputHtml.append("document.f1.submit();");
outputHtml.append("</script>");
outputHtml.append("</form>");
outputHtml.append("</body>");
outputHtml.append("</html>");
out.println(outputHtml);
%>
