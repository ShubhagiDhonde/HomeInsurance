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
              if(!paramNames.hasMoreElements()){
           	   %>
                  	<%@ include file="location.html" %> 
   	   	  	   <%
              }
              while(paramNames.hasMoreElements()) {
                 String paramName = (String)paramNames.nextElement();
                 String paramValue = request.getParameter(paramName);
                 if(paramName.equals("action") && paramValue.equals("location")){
	            %>
                     <%@ include file="location.html" %> 
	            <%
	            break;
                 }
                 else if(paramName.equals("action") && paramValue.equals("HomeOwner")){
	             %>
                      <%@ include file="homeOwn.html" %> 
	             <%
                 }
                 else if(paramName.equals("action") && paramValue.equals("property")){
	             %>
                      <%@ include file="property.html" %> 
	             <%
                 }
              }
           %>
	<%@ include file="footer.html" %>
	</body>
</html>