package casestudy_Servlet;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/retrievePolicy")
public class retrievePolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
			String userName = request.getParameter("userName");
			
			retrievePolicyDao dao = new retrievePolicyDao();
			int userIdFound;
			try {
				userIdFound = dao.getUserId(userName);
				if(userIdFound != 0) {
					request.setAttribute("AuserId", userIdFound);
					session.setAttribute("AuserId", userIdFound);
					session.setAttribute("AuserName", userName);
					response.sendRedirect("Admin.jsp?user=" + userIdFound);
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
