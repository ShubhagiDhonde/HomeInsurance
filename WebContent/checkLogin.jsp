<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	// HTTP 1.1 Prevent back button
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	// HTTP 1.0 Prevent back button
	response.setHeader("Pragma", "no-cache");
	
	//Prevent back button on Proxies
	response.setHeader("Expires", "0"); 
	
	//Validates if the user is login
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
	

%>