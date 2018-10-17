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
stmt = conn.prepareStatement(SQLQueries.GET_QUOTE);
%>
			 
<div class="container cnt-smll">
	<div class="row text-center">
		<div class="col-12 text-center align-self-center">
			<h3>Coverage Details</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-6 align-self-center">
			<img width="100%"src="https://d2cax41o7ahm5l.cloudfront.net/cs/venue/venuehotelimage1-1234.jpg">
		</div>
		<div class="col-6 align-self-center">
			<table class="table table-bordered table-striped table-hover table-light">
			  <thead>
			    <tr>
			    	<th colspan="2">
			    	<button style="background: transparent; width: 100%;
			    	border-style: none; color: blue"
			    	type="button"
			    	data-toggle="modal" data-target="#AdditionalInfo">
			    		Additional Info
			    	</button>
			    	</th>
			    </tr>
			  </thead>
			  <tbody>
			  <%
			    String location = (String) session.getAttribute("quoteId");
				stmt.setString(1, location);
			    result = stmt.executeQuery();
			    while(result.next()){
			   %>
			    <tr>
			      <th scope="row">Quote ID</th>
			      <td><%=result.getString("quote_id") %></td>
			    </tr>
			    <tr>
			      <th scope="row">Premium</th>
			      <td><%=result.getString("monthly_premuim") %></td>
			    </tr>
			    <tr>
			      <th scope="row">Dwelling Coverage</th>
			      <td><%=result.getString("dwelling_coverage") %></td>
			    </tr>
			    <tr>
			    	<th scope="row">Detached Structures</th>
			    	<td><%=result.getString("detached_structures")  %></td>
			    </tr>
			    <tr>
			    	<th scope="row">Personal Property</th>
			    	<td><%=result.getString("personal_property")  %></td>
			    </tr>
			    <tr>
			    	<th scope="row">Additional living expenses</th>
			    	<td><%=result.getString("additional_liv_expense") %></td>
			    </tr>
			    <tr>
			    	<th scope="row">Medical expense</th>
			    	<td><%=result.getString("medical_expense") %></td>
			    </tr>
			    <tr>
			    	<th scope="row">Deductible</th>
			    	<td><%=result.getString("deductable") %></td>
			    </tr>
			   <%
				}
			   %>
			    <tr>
			    	<th colspan="2">
			    	<button style="background: transparent; width: 100%; border-style: none;">
			    		<a style="color: blue;" href="retrieveQuote.jsp?makeSure=<%=session.getAttribute("quoteId") %>">
			    			Proceed to Buy
			    		</a>
			    	</button>
			    	</th>
			    </tr>
			  </tbody>
			</table>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="AdditionalInfo" tabindex="-1" role="dialog" aria-labelledby="information" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="information">Additional Quote Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <h1>Dwelling Coverage</h1>
		<p>This amount is the minimum coverage needed to adequately insure your residence. It is an estimate based on the current cost to rebuild your home, not including the value of the land. If needed, this amount may be increased up to 50% of the amount displayed.
		
		This amount should reflect the cost to rebuild the insured property exactly as it is, using materials of like kind and quality, not including land value. In the event of a covered loss, this provides coverage for: your home; structures attached to your home; property permanently installed in your home such as wall-to-wall carpet, central air conditioner, built in appliances; and construction material at or next to the residence for use in connection with your dwelling. You may increase this amount if you feel additional coverage is needed. The amount paid on the loss will be reduced by the deductible you select.
		</p>
		
		<h1>Detached Structures</h1>
		<p>
		In the event of a covered loss, this provides coverage for structures not attached to the dwelling or only connected to the dwelling by a utility line, fence or similar connection (e.g., detached garage, outbuildings or storage sheds, swimming pool, detached fence). The amount paid on the loss will be reduced by the deductible you select.
		</p>
		
		<h1>Personal Property </h1>
		
		<p>
		In the event of a covered loss or damage, this provides coverage for your personal possessions, defined as personal property owned or used by an insured person anywhere in the world (e.g., clothing, furniture, appliances that are not built in).
		</p>
		<h1>Additional Living Expenses </h1>
		<p>
		In the event of a covered loss, if the dwelling is uninhabitable this provides coverage for additional living expenses (e.g., temporary housing such as a hotel and reasonable expenses necessary to maintain your normal standard of living).
		</p>
		<h1>Medical Expense</h1>
		<p>
		In the event of a covered loss, this provides primary coverage for the medical expenses of a third-party who is injured while on the insured premises or is injured by an animal owned by or in the care of the insured person.
		</p>
		<h1>Deductible</h1>
		<p>
		In the event of a covered loss, payment for property losses will be reduced by the deductible you select.
		</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>