package HomeIns_case_study.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import HomeIns_case_study.util.SQLQueries;

public class buyQuoteDao {
	
	@SuppressWarnings("resource")
	public boolean buyQuote(String policyId, String quoteId, String startDate, String endDate,
			int term, String Status, String userName) throws SQLException{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		int userId = 0;
		
		try {
			conn = MySqlConnection.getConnection();	
			stmt = conn.prepareStatement(SQLQueries.getUserId);
			stmt.setString(1, userName);
			result = stmt.executeQuery();
			if(result.next()) {
				userId = result.getInt(1);
			}
			else {
				return false;
			}
			
			stmt = conn.prepareStatement(SQLQueries.SAVE_POLICY);
			stmt.setString(1, policyId);
			stmt.setString(2, quoteId);
			stmt.setString(3, startDate);
			stmt.setString(4, endDate);
			stmt.setInt(5, term);
			stmt.setString(6, Status);
			stmt.setInt(7, userId);
			stmt.executeUpdate();
			
			return true;
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(result != null) {
				result.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
}
