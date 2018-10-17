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
stmt = conn.prepareStatement(SQLQueries.GET_LOCATION);
%>

<body style="background-color: skyblue;">
	<div class="container">
		<div class="row text-center">
			<div class="col-12 text-center align-self-center">
				<h3>Quote Details</h3>
			</div>
		</div>
		<div class="col-12 align-self-center">
			<table class="text-center table table-bordered table-hover table-striped table-light">
			  <thead>
			    <tr>
			    	<th scope="row">QuoteId</th>
			    	<th scope="row">Residence Type</th>
			    	<th scope="row">Address</th>
			    	<th scope="row">City</th>
			    	<th scope="row">State</th>
					<th scope="row">Zip</th>
			    	<th scope="row">Residence Type</th>
			    	<th scope="row">Status</th>
			    	<th scope="row">Rest of information</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			    <%
			    String location = (String) session.getAttribute("quoteId");
				stmt.setString(1, location);
			    result = stmt.executeQuery();
			    while(result.next()){
			    %>
			      <td><%=result.getString("location_id")%></td>
			      <td><%=result.getString("residential_type") %></td>
			      <td><%=result.getString("address1") %></td>
			      <td><%=result.getString("address_2") %></td>
			      <td><%=result.getString("city") %></td>
			      <td><%=result.getString("state") %></td>
			      <td><%=result.getString("zip") %></td>
			      <td><%=result.getString("user_id") %></td>
			      <td>
			    <%
			    }
			    %>
			      <a style="color: blue;" href="retrieveQuote.jsp?buy=<%=session.getAttribute("quoteId") %>">
			      	Buy
			      </a>
			      </td>
			    </tr>
			  </tbody>
			</table>
		</div>
	</div>
</body>