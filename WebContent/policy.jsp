<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ page import="
			 javax.servlet.http.HttpServletRequest,
			 javax.servlet.http.HttpServletResponse,java.util.*, java.io.*" %>
<!DOCTYPE html>
<html>
	<%@ include file="header.html" %>
	<%@ include file="checkLogin.jsp" %>
	<body style="background-color: orange;">		 
		<%
              Enumeration paramNames = request.getParameterNames();
           	  String Quote = String.valueOf(session.getAttribute("quoteId"));
        	  if(!paramNames.hasMoreElements()){
           	   %>
                  	<%@ include file="displayPolicy.jsp" %> 
   	   	  	   <%
              }
              while(paramNames.hasMoreElements()) {
                 String paramName = (String)paramNames.nextElement();
                 String paramValue = request.getParameter(paramName);
                 if(paramName.equals("message") && paramValue.equals("successful")){
	             %>
                      <%@ include file="policygetData.jsp" %> 
	             <%
                 }
                 else if(paramName.equals("action") && paramValue.equals("admin")){
	             %>
                      <%@ include file="displayPolicy.jsp" %> 
	             <%
                 }
              }
           %>
	<%@ include file="footer.html" %>
	</body>
</html>