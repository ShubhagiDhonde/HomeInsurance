package casestudy_Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HomeIns_case_study.Dao.UserDao;
import HomeIns_case_study.model.User;

/**
* Servlet implementation class index
*/
@WebServlet(urlPatterns={"/" , "/Index"})
public class Index extends HttpServlet {
   private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Index() {
      super();
      // TODO Auto-generated constructor stub
  }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action =request.getServletPath();
      //System.out.println(action);
      System.out.println("Inside the doGet method.");
      switch (action) {
      case "/loginUser":
          try {
            loginUser(request, response);
        } catch (SQLException e) {
            System.out.println("Login unsuccessful");
        }
          break;
      default:
          displayLoginPage(request, response);
          break;
      }
  }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       doGet(request, response);
   }

   //***********Action Methods***************

   private void displayLoginPage(HttpServletRequest request , HttpServletResponse response)
           throws ServletException, IOException{
	   RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
        rd.forward(request, response);

   }

   private void loginUser(HttpServletRequest request , HttpServletResponse response) throws IOException, SQLException {
       System.out.println("Inside the loginUser page.");
       String userName= request.getParameter("UserName");
       String password=request.getParameter("Password");
       System.out.println("UserName: "+ userName);
       System.out.println("Password:" + password);

       UserDao u_dao= new UserDao();
       User u = u_dao.getUserByName(userName);
       if (password.equals(u.getPassword())) {
           System.out.println("You are logged in!");
           response.sendRedirect("getQuote.jsp");
   }  else {
       System.out.println("Invalid User Name or Password");
   }
   }
}

//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Index
// */
//@WebServlet(urlPatterns= {"/" , "/Index"})
//public class Index extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//   
//    public Index() {
//        super();
//       
//    }
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action =request.getServletPath();
//		//System.out.println(action);
//		
//		switch (action) {
//		case "/loginUser":
//			loginUser(request, response);
//			break;
//		default:
//			displayLoginPage(request, response);
//			break;	
//		}
//	}
//	
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}
//	
//	//*****************Action Methods***********************************//
//		
//	private void displayLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
//		rd.forward(request, response);		
//		}
//	
//	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		String userName = request.getParameter("UserName");
//		String password = request.getParameter("Password");
//		System.out.println("User Name: " + userName);
//		System.out.println("Password: " + password);
//		
//		//***********End of Action Methods************//	
//		
//		
//	}		//End of Index Servlet
//}
