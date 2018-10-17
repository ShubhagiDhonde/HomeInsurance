package HomeIns_case_study.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import HomeIns_case_study.util.SQLQueries;

public class retrievePolicyDao {
	
	public int getUserId(String userName) throws SQLException{
		
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
				return userId;
			}
			else {
				return 0;
			}
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			return 0;
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
	
	public boolean renew(String policy_Id) throws SQLException{
			
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String startDate = getStartDate();
		String endDate = getEndDate();
		
		try {
			conn = MySqlConnection.getConnection();	
			stmt = conn.prepareStatement(SQLQueries.RENEW_POLICY);
			stmt.setString(1, startDate);
			stmt.setString(2, endDate);
			stmt.setString(3, policy_Id);
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
	
	public boolean cancel(String policy_Id) throws SQLException {
			
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String date = getStartDate();
		
		try {
			conn = MySqlConnection.getConnection();	
			stmt = conn.prepareStatement(SQLQueries.CANCEL_POLICY);
			stmt.setString(1, date);
			stmt.setString(2, policy_Id);
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
	
	String getStartDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String formatDate = dateFormat.format(date);
		
		return formatDate;
	}
	
	String getEndDate() {
		String startDate = getStartDate();
		
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
