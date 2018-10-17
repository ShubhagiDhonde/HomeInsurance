package casestudy_Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HomeIns_case_study.Dao.getQuoteDao;

/**
 * Servlet implementation class getQuote
 */
@WebServlet("/getQuote")
public class getQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String action = request.getParameter("action");
		if(action.equals("locationEntry")) {
			location(request, response);
		}
		else if(action.equals("homeOwnerEntry")) {
			homeOwnerEntry(request, response);
		}
		else if(action.equals("propertyEntry")) {
			propertyEntry(request, response);
		}
	}
	
	private void location(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String residence = request.getParameter("residencyType");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 =request.getParameter("addressLine2");
		String city = request.getParameter("inputCity");
		String state = request.getParameter("inputState");
		int zipCode = Integer.parseInt(request.getParameter("inputZip"));
		String residenceUse = request.getParameter("residenceUse");
		
		getQuoteDao dao = new getQuoteDao();
		
		try {
			final HttpSession session = request.getSession();
			if(session.getAttribute("location")==null) {
				String userName = (String) session.getAttribute("username");
				System.out.println(userName);
				if(userName != null) 
				{
					int locationID = dao.location(residence, addressLine1, addressLine2, city, state, zipCode, residenceUse, userName);
					request.setAttribute("action", "HomeOwner");
					session.setAttribute("resdType", residence);
					session.setAttribute("location", locationID);
					System.out.print("location ID: " + locationID);
					response.sendRedirect("getQuote.jsp?action=HomeOwner");
				}
				else {
					System.out.print("You are not logged in");
				}
			}
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void homeOwnerEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		String dob = (String) request.getParameter("dob");
		String retired = request.getParameter("retired");
		int ssn = Integer.parseInt(request.getParameter("ssn"));
		String email = request.getParameter("email");
		
		getQuoteDao dao = new getQuoteDao();
		
		try {
			final HttpSession session = request.getSession();
			int location = (Integer) session.getAttribute("location");
			if(location != 0) {
				String userName = (String) session.getAttribute("username");
				if(userName != null) 
				{
					boolean successful = dao.HomeOwner(location, firstName, secondName, dob, retired, ssn, email, userName);
					if(successful) {
						request.setAttribute("action", "property");
						response.sendRedirect("getQuote.jsp?action=property");
					}
					else {
						System.out.println("Error in code");
					}
				}
			}
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void propertyEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int marketValue = Integer.parseInt(request.getParameter("marketValue"));
		int yearBuilt = Integer.parseInt(request.getParameter("yearBuilt"));
		int squareFootage = Integer.parseInt(request.getParameter("squareFootage"));
		String dwellingStyle = request.getParameter("dwellingStyle");
		String rootMaterial = request.getParameter("rootMaterial");
		String garageType = request.getParameter("garageType");
		int fullBaths = Integer.parseInt(request.getParameter("fullBaths"));
		int halfBaths = Integer.parseInt(request.getParameter("halfBaths"));
		String Pool = request.getParameter("Pool");
		
		getQuoteDao dao = new getQuoteDao();
		
		try {
			final HttpSession session = request.getSession();
			int locationId = (Integer) session.getAttribute("location");
			String location = String.valueOf(locationId);
			if(session.getAttribute("location")!=null) 
			{
				boolean propertySuccess = dao.property(location, marketValue, yearBuilt, squareFootage, dwellingStyle, 
						rootMaterial, garageType, fullBaths, halfBaths, Pool);
				System.out.print("Check before if: " + propertySuccess);
				if(propertySuccess) {
					System.out.print("Property Success");
					String residenceType = (String) session.getAttribute("resdType");
					boolean calculate = propertyValue(location, residenceType, marketValue, yearBuilt, squareFootage, dwellingStyle, 
							rootMaterial, garageType, fullBaths, halfBaths, Pool, request);
					if(calculate) {
						String redirect = ("retrieveQuote.jsp?quoteId=" + location);
						session.setAttribute("quoteId", location);
						session.setAttribute("location", null);
						response.sendRedirect(redirect);
					}
					else {
						System.out.print("Calculate returns false");
					}
				}
			}
			else {
				System.out.print("You have not started a quote, please return to quote id");
			}
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean propertyValue(String location, String residenceType, int marketValue, int yearBuilt, 
			int squareFootage, String dwellingStyle, String rootMaterial, String garageType,
			int fullBaths, int halfBaths, String pool, HttpServletRequest request) {
		
		//Constants 
		int rate = 5;
		int exposureUnits = 1000;
		int costPerSqFT = 120;
		int medicalExpenses = 5000;
		
		//Calculate Premium
		double premium = rate * marketValue / exposureUnits;
		
		switch(residenceType) {
			case "Single-Family Home":
				premium = premium * (premium * .5 /  100);
				break;
			case "Condo":
			case "Duplex":
			case "Apartment":
				premium = premium * (premium * .06 /  100);
				break;
			case "Townhouse":
			case "Rowhouse":
				premium = premium * (premium * .07 /  100);
				break;
		}
		
		premium = premium/12;
		
		//Calculate Coverage
		double homeValue = squareFootage * costPerSqFT;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int yearsOld = currentYear - yearBuilt;
		if(yearsOld <= 5) {
			homeValue -= (homeValue * 10/100);
		}
		else if(yearsOld <= 10) {
			homeValue -= (homeValue * 20/100);
		}
		else if(yearsOld <= 20) {
			homeValue -= (homeValue * 30/100);
		}
		else if(yearsOld >= 20) {
			homeValue -= (homeValue * 40/100);
		}
		
		double dwellingCoverage = homeValue + (marketValue/2);
		double detacheStruc = dwellingCoverage * .1;
		double personalProperty = dwellingCoverage * .6;
		double addLivingExpense = dwellingCoverage * .2;
		double deductible = marketValue * .1;

		getQuoteDao dao = new getQuoteDao();
		
		try {
			boolean coverage = dao.coverage(location, premium, dwellingCoverage, detacheStruc,
					personalProperty, addLivingExpense, medicalExpenses,deductible);
			if(coverage) {
				final HttpSession session = request.getSession();
				session.setAttribute("premium", premium);
				session.setAttribute("DwellCov", dwellingCoverage);
				session.setAttribute("DetacheStruc", detacheStruc);
				session.setAttribute("personal_pro", personalProperty);
				session.setAttribute("medExpense", medicalExpenses);
				session.setAttribute("addLiving", addLivingExpense);
				session.setAttribute("Deduct", deductible);
				return true;
			}
		}
		catch(SQLException e)  {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
