<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<%@ include file="checkLogin.jsp" %>
	<body style="background-color: orange;">
		<% 
		if(session.getAttribute("username")!=null)
		{ %>
		<%
			if(session.getAttribute("role").equals("admin_role")){
		%>
				<%@ include file="Admin.jsp" %>
		<%
			}
			else{
		%>
			<%@ include file='policy.jsp' %>
		<% 
			}
		}
		%>
	</body>
</html>