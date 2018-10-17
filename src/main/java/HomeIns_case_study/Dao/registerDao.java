package HomeIns_case_study.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import HomeIns_case_study.util.SQLQueries;

public class registerDao {
	@SuppressWarnings("resource")
	public boolean registered(String userName, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = MySqlConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueries.checkUsername);
			
			stmt.setString(1, userName);
			result = stmt.executeQuery();
			
			if(!result.next()) {
				System.out.println(userName + " is not found");
				stmt = conn.prepareStatement(SQLQueries.register);
				stmt.setString(1, userName);
				stmt.setString(2, password);
				System.out.println("Creating new user " + userName + " " + password);
				stmt.executeUpdate();
				return true;
			}
			else {
				System.out.println(userName + " is found");
			}
			
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return false;
	}
}
