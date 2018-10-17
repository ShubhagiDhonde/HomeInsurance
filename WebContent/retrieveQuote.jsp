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
                  	<%@ include file="retrieve.html" %> 
   	   	  	   <%
              }
              while(paramNames.hasMoreElements()) {
                 String paramName = (String)paramNames.nextElement();
                 String paramValue = request.getParameter(paramName);
                 if(paramName.equals("quoteId") && paramValue.equals(Quote)){
	             %>
                      <%@ include file="quoteDetails.jsp" %> 
	             <%
                 }
                 else if(paramName.equals("makeSure")){
                 %>
                	 <%@ include file="makeSure.jsp" %>
                 <%
                 }
                 else if(paramName.equals("buy")){
                %>
                	 <%@ include file="buy.jsp" %>
                 <%
                 }
                 else if(paramName.equals("confirmation")){
                %>
                	 <%@ include file="confirmation.jsp" %>
                 <%
                 }
              }
           %>
	<%@ include file="footer.html" %>
	</body>
</html>