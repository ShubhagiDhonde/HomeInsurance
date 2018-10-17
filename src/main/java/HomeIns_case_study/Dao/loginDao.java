package HomeIns_case_study.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import HomeIns_case_study.util.SQLQueries;

public class loginDao {
	public String check(String userName, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = MySqlConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueries.LOGIN);
			
			stmt.setString(1, userName);
			stmt.setString(2, password);
			result = stmt.executeQuery();
			
			if(result.next()) {
				String role = result.getString("admin_role");
				if(role.equals("admin")) {
					return "admin_role";
				}
				else if(role.equals("user")) {
					return "user_role";
				}
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
		return "Invalid user credentials";
	}
}
