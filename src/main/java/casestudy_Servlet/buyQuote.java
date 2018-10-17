package casestudy_Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HomeIns_case_study.Dao.buyQuoteDao;

/**
 * Servlet implementation class buyQuote
 */
@WebServlet("/buyQuote")
public class buyQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyQuote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final HttpSession session = request.getSession();
		String startDate = request.getParameter("policyDate");
		String quoteId = (String) session.getAttribute("quoteId");
		String policyId = quoteId + "_1";
		String policyStatus = "ACTIVE";
		int term = 1;

		String endDate = getEndDate(startDate);
		
		buyQuoteDao dao = new buyQuoteDao();
		
		try {
			if(session.getAttribute("quoteId")!=null) {
				System.out.println(session.getAttribute("username"));
				String userName = (String) session.getAttribute("username");
				boolean bought = dao.buyQuote(policyId, quoteId, startDate, endDate, term, policyStatus, userName);
				
				if(bought)
				{
					session.setAttribute("policyId", policyId);
					response.sendRedirect("policy.jsp?message=successful");
				}
				else {
					response.sendRedirect("retrieveQuote.jsp");
				}
			}
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getEndDate(String startDate) {
		// TODO Auto-generated method stub
		//Set End Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(format.parse(startDate));
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.YEAR, 1);
		String endDate = format.format(c.getTime());
		
		return endDate;
	}

}