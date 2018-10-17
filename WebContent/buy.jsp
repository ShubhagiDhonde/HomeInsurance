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

<body style="background-color: orange;">
	<div class="container">
		<div class="row text-center">
			<div class="col-12 text-center align-self-center">
				<h3>Quote Summary</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-6 align-self-center">
				<table class="text-center table table-bordered table-hover table-striped table-light">
			  		<tbody>
 					<%
					    String location = (String) session.getAttribute("quoteId");
						stmt.setString(1, location);
					    result = stmt.executeQuery();
					    while(result.next()){
				    %>
					    <tr>
							<th scope="col" colspan="2">Location Details</th>
						</tr>
					    <tr>
					      <th scope="col">Quote ID</th>
					      <td><%=result.getString("location_id") %></td>
					    </tr>
					    <tr>
					      <th scope="col">Residence Type</th>
					      <td><%=result.getString("residential_type") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Address Line 1</th>
					    	<td><%=result.getString("address1")  %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Address Line 2</th>
					    	<td><%=result.getString("address_2")  %></td>
					    </tr>
					    <tr>
					    	<th scope="col">State</th>
					    	<td><%=result.getString("state") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">City</th>
					    	<td><%=result.getString("city") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Zip</th>
					    	<td><%=result.getString("zip") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Residence Use</th>
					    	<td><%=result.getString("use_type") %></td>
					    </tr>
			    	</tbody>
		    	</table>
		    </div>
		    <div class="col-6 align-self-center">
			   	<%
				   	}
				    stmt = conn.prepareStatement(SQLQueries.GET_HOMEOWNER);
					stmt.setString(1, location);
				    result = stmt.executeQuery();
				    while(result.next()){	
			   	%>
			    <table class="text-center table table-bordered table-hover table-striped table-light">
				  <tbody>
						<tr>
							<th scope="col" colspan="2">HomeOwner Details</th>
						</tr>
					    <tr>
					      <th scope="col">First Name</th>
					      <td><%=result.getString("first_name") %></td>
					    </tr>
					    <tr>
					      <th scope="col">Last Name</th>
					      <td><%=result.getString("last_name") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Date of Birth</th>
					    	<td><%=result.getString("dob")  %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Is Retired?</th>
					    	<td><%=result.getString("retired")  %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Social Security Number</th>
					    	<td><%=result.getString("ssn") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Email Address</th>
					    	<td><%=result.getString("email") %></td>
					    </tr>
			    	</tbody>
				</table>    
			</div>
		</div>
		<div class="row">
			<div class="col-6 align-self-center">
				<%
					}
				    stmt = conn.prepareStatement(SQLQueries.GET_PROPERTY);
					stmt.setString(1, location);
				    result = stmt.executeQuery();
				    while(result.next()){	
				%>
				<table class="text-center table table-bordered table-hover table-striped table-light">
				 	<tbody>
						<tr>
							<th scope="col" colspan="2">Property Details</th>
						</tr>
						<tr>
					      <th scope="col">Market Value</th>
					      <td><%=result.getString("market_value") %></td>
					    </tr>
					    <tr>
					      <th scope="col">Year Built</th>
					      <td><%=result.getString("built_year") %></td>
					    </tr>
					    <tr>
					      <th scope="col">Square Footage</th>
					      <td><%=result.getString("square_feet") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Dwelling Style</th>
					    	<td><%=result.getString("dwelling_style")  %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Roof Material</th>
					    	<td><%=result.getString("roof_material")  %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Garage Type</th>
					    	<td><%=result.getString("garage_type") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Number of Full Baths</th>
					    	<td><%=result.getString("num_full_bath") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Number of Half Baths</th>
					    	<td><%=result.getString("num_half_bath") %></td>
					    	
					    </tr>
					    <tr>
					    	<th scope="col">Has Swimming Pool?</th>
					    	<td><%=result.getString("swimming_pool") %></td>
					    	
					    </tr>
				    </tbody>
				</table>
			</div>
			<div class="col-6 align-self-center">
				<%
					}
				    stmt = conn.prepareStatement(SQLQueries.GET_QUOTE);
					stmt.setString(1, location);
				    result = stmt.executeQuery();
				    while(result.next()){	
				%>
		    	<table class="text-center table table-bordered table-hover table-striped table-light">
			  		<tbody>
						<tr>
							<th scope="col" colspan="2">Coverage Details</th>
						</tr>
						<tr>
					      <th scope="col">Quote ID</th>
					      <td><%=result.getString("quote_id") %></td>
					    </tr>
					    <tr>
					      <th scope="col">Premium</th>
					      <td><%=result.getString("monthly_premuim") %></td>
					    </tr>
					    <tr>
					      <th scope="col">Dwelling Coverage</th>
					      <td><%=result.getString("dwelling_coverage") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Detached Structures</th>
					    	<td><%=result.getString("detached_structures")  %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Personal Property</th>
					    	<td><%=result.getString("personal_property")  %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Additional living expenses</th>
					    	<td><%=result.getString("additional_liv_expense") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Medical expense</th>
					    	<td><%=result.getString("medical_expense") %></td>
					    </tr>
					    <tr>
					    	<th scope="col">Deductible</th>
					    	<td><%=result.getString("deductable") %></td>
					    </tr>
			  		</tbody>
				</table>
			   <%
				}
			   %>
			</div>
		</div>
		<table class="text-center table table-bordered table-hover table-striped table-light">
			<tbody>
			    <tr>
			    	<th colspan="2">
			    	<button style="background: transparent; width: 100%;
			    	border-style: none; color: blue">
			    		<a style="color: blue;" href="retrieveQuote.jsp?confirmation=<%=session.getAttribute("quoteId") %>">Buy Quote</a>
			    	</button>
			    	</th>
			    </tr>
		    </tbody>
		</table>
	</div>
</body>