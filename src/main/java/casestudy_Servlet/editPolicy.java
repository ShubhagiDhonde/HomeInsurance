package casestudy_Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HomeIns_case_study.Dao.retrievePolicyDao;

/**
 * Servlet implementation class retrieveQuote
 */
@WebServlet("/editPolicy")
public class editPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
			
		final String action = request.getParameter("action");
		if(session.getAttribute("role").equals("admin_role")) {
			if(action.equals("renew")) {
				renew(request, response);
			}
			else if(action.equals("cancel")) {
				cancel(request, response);
			}	
		}
		else {
			if(action.equals("renew")) {
				urenew(request, response);
			}
			else if(action.equals("cancel")) {
				ucancel(request, response);
			}	
		}
	}

	private void urenew(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
		String actionRenew = request.getParameter("renew");
		
		retrievePolicyDao dao = new retrievePolicyDao();

		try {
			boolean successfull = dao.renew(actionRenew);
			if(successfull) {
				response.sendRedirect("policy.jsp");
			}
			else {
				response.sendRedirect("Index.jsp");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void ucancel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
		String actionCanceled = request.getParameter("cancel");
		
		retrievePolicyDao dao = new retrievePolicyDao();

		try {
			boolean successfull = dao.cancel(actionCanceled);
			if(successfull) {
				response.sendRedirect("policy.jsp");
			}
			else {
				response.sendRedirect("Index.jsp");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void renew(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
		String actionRenew = request.getParameter("renew");
		
		retrievePolicyDao dao = new retrievePolicyDao();

		try {
			boolean successfull = dao.renew(actionRenew);
			if(successfull) {
				response.sendRedirect("Admin.jsp?user=" + session.getAttribute("AuserId"));
			}
			else {
				response.sendRedirect("Index.jsp");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
		String actionCanceled = request.getParameter("cancel");
		
		retrievePolicyDao dao = new retrievePolicyDao();

		try {
			boolean successfull = dao.cancel(actionCanceled);
			if(successfull) {
				response.sendRedirect("Admin.jsp?user=" + session.getAttribute("AuserId"));
			}
			else {
				response.sendRedirect("Index.jsp");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
