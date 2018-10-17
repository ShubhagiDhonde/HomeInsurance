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
	<div class="container cnt-smll">
	<div class="row text-center">
		<div class="col-12 text-center align-self-center">
			<h3>Buy Policy</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-12 align-self-center">
			<label>Quote Id: ${param.confirmation} </label>
			<p>Note: Policy start date cannot be more than 60 days from today's date</p>
			<form name="retrieveQuote" action="buyQuote"
				method="post">
				<div class="form-group row">
					 <div class="col-12">
					 	<p>Enter Policy Start Date: </p>
					    <input class="form-control" type="date" name="policyDate" required>
					 </div>
					<button style="background: transparent; width: 100%;
			    	border-style: none; color: blue"
			    	type="button"
			    	data-toggle="modal" data-target="#termcond">
			    		Read Terms and Conditions before buying policy
			    	</button>
				</div>
				<div class="form-group row">
					<div class="checkbox">
					 	<label><input type="checkbox" value="Yes" name="terms" required>
					 		This is to acknowledge that I have read the terms and conditions of the policy
					 	</label>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">submit</button>
			</form>
		</div>
	</div>
</div>



<!-- Modal -->
<div class="modal fade" id="termcond" tabindex="-1" role="dialog" aria-labelledby="information" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="information">Terms and Conditions</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>
			A summary of your cover
			
			Please read this document carefully, it provides a summary of cover.
			It does not show all of the benefits, exclusions or limits. Please
			refer to your policy booklet and policy schedule for full details of all
			terms, conditions and endorsements or excesses that may apply.
			
			Your policy schedule will show the period of cover and which
			of the following sections of cover you have requested.
			
			Section 1 - Buildings 
			
			What is covered:
			Your home and its walls, roofs, drives, patios
			Permanent fixtures such as kitchen units, bathroom fittings, fitted wardrobes
			utbuildings including sheds, garages
			
			
			Loss or Damage
			
			What you are covered for:
			Fire
			Theft
			Storm or flood
			Vandalism or malicious act
			Escape of water
			Subsidence
			
			Section 2 - Contents
			Household goods, including non-permanent fixtures and fittings like carpets
			and curtains
			Personal belongings in the home, garages and sheds
			
			Loss or Damage
			
			What you are covered for:
			Fire
			Theft
			Storm or flood
			Vandalism or malicious act
			Escape of water
			Subsidence
			
			
			Summary of Exclusions and Limits
			
			Your policy will not pay for the following if caused by any paying guest
			or tenant:
			Theft or attempted theft
			Vandalism or malicious acts
			Accidental breakage of fixed glass and sanitary ware
			Accidental damage
			
			After your home has been unoccupied for more than 60 days in a row your
			policy will not pay for:
			Theft or attempted theft
			Vandalism or malicious acts
			Water or oil escaping
			Damage to plumbing installation by frozen or burst pipes
			Accidental breakage of fixed glass and sanitary ware
			
			Domestic pets:
			Your policy will not pay for accidental damage by domestic pets
			Escape of water:
			Your policy will not pay for loss or damage caused by subsidence, heave or
			landslip that results from the escaping water
			
			Section 3 - Personal Possessions
			
			What is covered: 
			Items that you normally take out of the home
			or on holiday such as jewellery, cameras, sports
			equipment, money and pedal cycles (up to £1,000
			per cycle)
			
			Home Insurance Priority Line: 345-345-345
		</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>