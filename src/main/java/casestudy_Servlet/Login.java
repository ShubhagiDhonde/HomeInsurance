package casestudy_Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HomeIns_case_study.Dao.loginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("UserId");
		String password = request.getParameter("Password");
		
		loginDao dao = new loginDao();
		
		try {
			String userValidate = dao.check(username, password);
			System.out.println(userValidate);
			if(userValidate.equals("admin_role")){
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					session.setAttribute("role", userValidate);
					response.sendRedirect("Admin.jsp");
					//session.setAttribute("role",username);
			}
			else if(userValidate.equals("user_role")){
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					session.setAttribute("role", userValidate);
					response.sendRedirect("Index.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
