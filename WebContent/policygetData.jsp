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
String userName = (String) session.getAttribute("username");
String policyId = (String) session.getAttribute("policyId");
%>
<div class="container cnt-smll">
		<div class="row text-center">
			<div class="col-12 text-center align-self-center">
				<h3>Policy Confirmation</h3>
			</div>
		</div>
		<div class="col-12 align-self-center text-center">
			<table class="table table-bordered table-striped table-hover table-light">
			  <thead>
			    <tr>
			    	<th scope="row" colspan="2">
						<p>Our customer service representative will contact you shortly for<br>
						 premium collection arrangements.</p>
			    	</th>
			  </thead>
			  <tbody>
			  <%
			  	stmt = conn.prepareStatement(SQLQueries.GET_POLICY);
				stmt.setString(1, policyId);
			    result = stmt.executeQuery();
			    while(result.next()){
			   %>
			    <tr>
			      <th scope="row">Policy ID</th>
			      <td><%=result.getString("policy_id") %></td>
			    </tr>
			    <tr>
			      <th scope="row">Quote ID</th>
			      <td><%=result.getInt("quote_Id") %></td>
			    </tr>
			    <tr>
			      <th scope="row">Start Date</th>
			      <td><%=result.getDate("p_effective_date") %></td>
			    </tr>
			    <tr>
			      	<th scope="row">Start Date</th>
			    	<td><%=result.getDate("p_end_date")  %></td>
			    </tr>
			    <tr>
			      	<th scope="row">Term</th>
			    	<td><%=result.getInt("policy_term") %></td>
			    </tr>
			    <tr>
			      	<th scope="row">Status</th>
			    	<td><%=result.getString("p_status")  %></td>
			    </tr>
			    <tr>
			      	<th scope="row">User Name</th>
			    	<td><%=userName %></td>
			    </tr>
			   <%
				}
			   %>
			  </tbody>
			</table>
		</div>
	</div>