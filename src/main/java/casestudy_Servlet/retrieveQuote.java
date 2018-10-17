package casestudy_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class retrieveQuote
 */
@WebServlet("/retrieveQuote")
public class retrieveQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final HttpSession session = request.getSession();
			String quotePost = request.getParameter("quoteId");
			request.setAttribute("quoteId", quotePost);
			session.setAttribute("quoteId", quotePost);
			String quote = (String) session.getAttribute("quoteId");
			response.sendRedirect("retrieveQuote.jsp?quoteId=" + quote);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		final HttpSession session = request.getSession();
		int quote = (Integer) session.getAttribute("quoteId");
		if(quote != 0) {
			response.sendRedirect("retrieveQuote.jsp");
		}
		else {
			response.sendRedirect("retrieveQuote.jsp?quoteId=" + quote);
		}
	}
	
}
