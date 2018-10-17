<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ page import="
			 javax.servlet.http.HttpServletRequest,
			 javax.servlet.http.HttpServletResponse,java.util.*, java.io.*" %>
<!DOCTYPE html>
<html>
	<%@ include file="Aheader.html" %>
	<%@ include file="checkLogin.jsp" %>
	<body style="background-color: orange;">		 
		<%
              Enumeration paramNames = request.getParameterNames();
           	  String username = String.valueOf(session.getAttribute("AuserId"));
        	  if(!paramNames.hasMoreElements()){
           	   %>
                  	<%@ include file="Aretrieve.html" %> 
   	   	  	   <%
              }
              while(paramNames.hasMoreElements()) {
                 String paramName = (String)paramNames.nextElement();
                 String paramValue = request.getParameter(paramName);
                 if(paramName.equals("user") && paramValue.equals(username)){
	             %>
                      <%@ include file="APolicyDetails.jsp" %> 
	             <%
                 }
              }
           %>
	<%@ include file="footer.html" %>
	</body>
</html>