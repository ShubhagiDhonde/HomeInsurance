<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.io.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="HomeIns_case_study.util.SQLQueries" %>
<%@page import="HomeIns_case_study.Dao.MySqlConnection" %>


<%

Connection conn = null;
PreparedStatement stmt = null;
ResultSet result = null;
conn = MySqlConnection.getConnection();
String userName = (String) session.getAttribute("AuserName");
%>

<div class="container cnt-smll">
		<div class="row text-center">
			<div class="col-12 text-center align-self-center">
				<h3><%=userName %> Policies</h3>
			</div>
		</div>
		<div class="col-12 align-self-center text-center">
			<table class="table table-bordered table-striped table-hover table-light">
			  <thead>
			    <tr>
			    	<th scope="row">Policy ID</th>
			    	<th scope="row">Quote ID</th>
			    	<th scope="row">Start Date</th>
			    	<th scope="row">End Date</th>
			    	<th scope="row">Term</th>
			    	<th scope="row">Status</th>
			    	<th scope="row">User Name</th>
			    	<th scope="row" colspan="2">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  <%
			  	int userId = (Integer) session.getAttribute("AuserId");
			  	stmt = conn.prepareStatement(SQLQueries.GET_POLICY_BY_User);
				stmt.setInt(1, userId);
			    result = stmt.executeQuery();
			    while(result.next()){
			   %>
			    <tr>
			      <td><%=result.getString("policy_id") %></td>
			      <td><%=result.getInt("quote_Id") %></td>
			      <td><%=result.getDate("p_effective_date") %></td>
			    	<td><%=result.getDate("p_end_date")  %></td>
			    	<td><%=result.getInt("policy_term") %></td>
			    	<td><%=result.getString("p_status")  %></td>
			    	<td><%=userName %></td>
			    	<td>
			    		<form action="editPolicy?action=renew" method="post">
				    		<button type="submit" name="renew" class="btn btn-primary"
				    			value="<%=result.getString("policy_id") %>">
				    			Renew
				    		</button>
				    	</form>
			    	</td>
			    	<td>
			    		<form action="editPolicy?action=cancel" method="post">
				    		<button type="submit" name="cancel" class="btn btn-primary"
				    			value="<%=result.getString("policy_id") %>">
				    			Cancel
				    		</button>
			    		</form>
			    	</td>
			    </tr>
			   <%
				}
			   %>
			  </tbody>
			</table>
		</div>
	</div>