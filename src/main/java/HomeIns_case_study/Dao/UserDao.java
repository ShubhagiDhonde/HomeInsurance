package HomeIns_case_study.Dao;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import HomeIns_case_study.model.User;

import java.sql.SQLException;


public class UserDao {
 
	
	public List<User> getAllUsers() throws SQLException {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	User user = null;
	List <User> allUsers= null;
	String url = null;
	
	try
	{
		
		//2) load and register driver
		url = "jdbc:mysql://localhost:3306/qe03_casestudttest";
		
		//3 CREATE CONNECTION
		conn = DriverManager.getConnection(url, "root", "root");
		System.out.println("Connection created to qe03_casestudttest");
		
		stmt = conn.createStatement();
		
		String qString= "SELECT * FROM users";
		
		//4 create statement
		rs = stmt.executeQuery(qString);
		
		//5 execute the query
		allUsers = new ArrayList<User>();
		
		//Process the results
		while(rs.next()) {
			user = new User();
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setAdminRole(rs.getString(4));
			allUsers.add(user);
		}
		
	}
	catch (Exception e)
	{
		System.out.println("Error: " + e.getMessage());
	}
	
	finally
	{
		if (rs != null) {
			rs.close();
		}
		
		if (stmt != null) {
			stmt.close();
		}
		
		if (conn != null) {
			conn.close();
		}
		}
	
	return allUsers;
	
	} //End of getAllUsers method
	
	
	//****************register users******************
	public Integer registerUser(User user) throws ClassNotFoundException, IOException, SQLException{
		
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String url = null;
	
	
	String iString = "insert into users(user_name, password, admin_role) values (?, ?, ?)";
	
	int ID = -1;
	String[] COL = {"user_id"};
	
	MySqlConnection MYSqlConn = new MySqlConnection();
	

	try
	{
		conn = MYSqlConn.getConnection();
		stmt = conn.prepareStatement(iString, COL);
		
		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());
		stmt.setString(3, user.getAdminRole());
		
		stmt.executeUpdate();
		rs = stmt.getGeneratedKeys();
		if (rs!= null && rs.next())
		{
			ID = rs.getInt(1);
		}
		System.out.println(ID);
	
	}
	catch (SQLException e)
	{
		System.out.println("Error: " + e.getMessage());
	}
	
	finally
	{
		if (rs != null) {
			rs.close();
		}
		
		if (stmt != null) {
			stmt.close();
		}
		
		if (conn != null) {
			conn.close();
		}
		
		

	}
 return ID;
 //End of getAllUsers method

} //**********************getUserById Method*********************************//
	
	public User getUserById(int userId) throws SQLException {
		//declares variable
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;
		
		
		//Assign
		String qstring = "select * from users where user_id = ? ";
		

		//make a connection to database
		MySqlConnection MYSQL = new MySqlConnection();
		
		try
{
	//Assign Connection and PreparedStatement variables
	conn = MYSQL.getConnection();
	stmt = conn.prepareStatement(qstring);
	
	//Set query parameter(s)
	stmt.setInt(1, userId);
	
	//Run query
	rs =stmt.executeQuery();
	
	//Retrieve results and assign to user
	u = new User ();

			if (rs.next()) {
			u.setUserId(rs.getInt(1));
			u.setUserName(rs.getString(2));
			u.setPassword(rs.getString(3));
			u.setAdminRole(rs.getString(4));
			//now we have a user with data to return
		}
	}
catch (Exception e) 
{
	System.out.println("ERROR: " + e.getMessage());
}

finally
{

	if (rs != null) {
		rs.close();
	}
	
	if (stmt != null) {
		stmt.close();
	}
	
	if (conn != null) {
		conn.close();
		
	}
}
	return u;
}
		
	
	//******************************getUserByName () method****************************//
	public User getUserByName(String userName) throws IOException, SQLException
	{
		System.out.println("Inside the getUserByName method.");
	      Connection conn=null;
	      PreparedStatement stmt=null;
	      ResultSet rs=null;
	      User u=null;
	      
	      String qString= "select * from users where user_name=?";
	      MySqlConnection oc = new MySqlConnection();
	      
	      try
	      {
	          conn=oc.getConnection();
	          System.out.println("Connection Successful");
	          stmt=conn.prepareStatement(qString);
	          stmt.setString(1, userName);
	          
	          rs=stmt.executeQuery();
	          
	          if(rs.next()) {
	        	  u = new User();
	              u.setUserId(rs.getInt(1));
	              u.setUserName(rs.getString(2));
	              u.setPassword(rs.getString(3));
	              u.setAdminRole(rs.getString(4));
	          }    
	      }
	      catch(Exception e)
	      {
	          System.out.println("Error: "+e.getMessage());
	      }
	      finally
	      {
	          if (rs != null) {
	              rs.close();
	          }
	          if (stmt != null) {
	              stmt.close();
	          }
	          if (conn != null) {
	              conn.close();
	             }
	         }
	      return u;
	}
	      
	public Boolean updateUser1(User u) throws SQLException
	{
	 //declare variables
	 Connection conn=null;
	 PreparedStatement stmt=null;
	 Integer queryResponse=null;

	 //create query string
	 String updateString ="update users set user_name=?,password=? where user_id=?";

	 //make  connection to database
	 MySqlConnection orcl=new MySqlConnection ();

	 //try/catch
	 try
	 {
	     conn=orcl.getConnection();
	     stmt=conn.prepareStatement(updateString);

	     //Set query Parameter
	     stmt.setString(1, u.getUserName());
	     stmt.setString(2, u.getPassword());
	     stmt.setInt(3, u.getUserId());

	 //Run Query
	 queryResponse=stmt.executeUpdate();
	 }
	     catch (ClassNotFoundException | IOException |SQLException e)
	     {
	         System.out.println("ERROR: " + ((Throwable) e).getMessage());
	     }
	     // 7) close connection
	     finally
	     {
	         if (stmt != null) {
	             stmt.close();
	         }
	         if (conn != null) {
	             conn.close();
	         }
	         }
	         if (queryResponse>0) {
	     return true;

	     }

	 return false;
	}
	
	
	
		
//*******************updateUSER()METHOD***********************//
	//UpdateUser
	public boolean updateUser(User u) throws SQLException {
		//declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer queryResponse = null;
		
		//create query string
		String updateString = "update user set user_name = ?, password= ? where user_id = ? ";
		
		//make connection to database
		MySqlConnection MYSQL = new MySqlConnection();
		
		//Begin try/catch
		try
		{
			//Assign connection and preparedstatement variables
			conn = MYSQL.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			//set query parameters
			stmt.setString(1,  u.getUserName());
			stmt.setString(2, u.getPassword() );
			stmt.setString(3, u.getAdminRole());
			
			//Run query
			 queryResponse =stmt.executeUpdate();
//			//if (queryResponse > 0) {
//				//return true;
//			}
//			return false;
		}
			catch (Exception e)
			{
				System.out.println("ERROR: " + e.getMessage());
			}

			finally
			{
				
				if (stmt != null) {
					stmt.close();
				}
				
				if (conn != null) {
					conn.close();
					
				}
			}
		if (queryResponse > 0) {
				return true;
		}
		return false;
		
		
	}//end of updatingUser()method 
	
	public Boolean removerUser(int id) throws SQLException, ClassNotFoundException, IOException
    {
        Connection conn=null;
        PreparedStatement stmt =null;
        Integer queryResponse =null;
        String removeString ="delete from users where user_id =?";
        MySqlConnection MYSQL = new MySqlConnection();
        
        try
        {
            conn= MYSQL.getConnection();
            stmt = conn.prepareStatement(removeString);
            stmt.setInt(1, id);
            
            queryResponse =stmt.executeUpdate();
        }
        catch(SQLException e)
           {
               System.out.println("Error: " + e.getMessage());
           }

           finally
           {
        	if (stmt != null) {
        		stmt.close();
				                     
             }
            if (conn != null) {			//check here below
            	conn.close();
             }    
           }
        
            if(queryResponse >0)
            {
             return true;
            }else {
            return false;
           }
    }
   
	/*UserDao u_dao = new UserDao();
	 User u = u_dao.getUserByName(userName);
	 if (password
		
	*/

     
    
   public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
     
        UserDao u_dao = new UserDao();
          User user=new User(3, "test_User","changed_password", "User");
           Boolean b=u_dao.removerUser(3);
            System.out.println(b);
    }
}