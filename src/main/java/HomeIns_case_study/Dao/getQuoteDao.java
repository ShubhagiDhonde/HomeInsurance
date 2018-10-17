package HomeIns_case_study.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import HomeIns_case_study.util.SQLQueries;

public class getQuoteDao {
	@SuppressWarnings("resource")
	public int location(String residence, String addressLine1, String addressLine2,
			String city, String state, int zipCode, String residenceUse, String userName) throws SQLException{
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
			
			stmt = conn.prepareStatement(SQLQueries.SAVE_LOCATION);
			stmt.setString(1, residence);
			stmt.setString(2, addressLine1);
			stmt.setString(3, addressLine2);
			stmt.setString(4, city);
			stmt.setString(5, state);
			stmt.setInt(6, zipCode);
			stmt.setString(7, residenceUse);
			stmt.setInt(8, userId);
			stmt.executeUpdate(); 
			
			stmt = conn.prepareStatement(SQLQueries.GET_LOCATION_ID);
			stmt.setString(1, residence);
			stmt.setString(2, addressLine1);
			stmt.setString(3, addressLine2);
			stmt.setString(4, city);
			stmt.setString(5, state);
			stmt.setInt(6, zipCode);
			stmt.setString(7, residenceUse);
			stmt.setInt(8, userId);
			result = stmt.executeQuery();
			if(result.next()) {
				return result.getInt(1);
			}
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
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
		return 0;
	}
	
	@SuppressWarnings({ "resource", "finally" })
	public boolean HomeOwner(int location, String firstName, String lastName, String DOB,
			String retired, int ssn, String email, String Username) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		int userId = 0;
		
		try {
			conn = MySqlConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueries.getUserId);
			stmt.setString(1, Username);
			result = stmt.executeQuery();
			if(result.next()) {
				userId = result.getInt(1);
			}
			
			stmt = conn.prepareStatement(SQLQueries.SAVE_HOMEOWNER);
			stmt.setInt(1, location);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, DOB);
			stmt.setString(5, retired);
			stmt.setInt(6, ssn);
			stmt.setString(7, email);
			stmt.setInt(8, userId);
			stmt.executeUpdate();
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
			return true;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean property(String location, int marketValue, int yearBuilt, int squareFootage, String dwellingStyle,
			String rootMaterial, String garageType, int fullBaths, int halfBaths, String Pool) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = MySqlConnection.getConnection();
			
			stmt = conn.prepareStatement(SQLQueries.SAVE_PROPERTY);
			stmt.setString(1, location);
			stmt.setInt(2, marketValue);
			stmt.setInt(3, yearBuilt);
			stmt.setInt(4, squareFootage);
			stmt.setString(5, dwellingStyle);
			stmt.setString(6, rootMaterial);
			stmt.setString(7, garageType);
			stmt.setInt(8, fullBaths);
			stmt.setInt(9, halfBaths);
			stmt.setString(10, Pool);
			stmt.executeUpdate();
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			return true;
		}
	}
	
	public boolean coverage(String location, double premium, double dwellingCoverage, double detacheStruc,
			double personalProperty, double addLivingExpense, int medicalExpenses, double deductible) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = MySqlConnection.getConnection();
			
			stmt = conn.prepareStatement(SQLQueries.SAVE_QUOTE);
			stmt.setString(1, location);
			stmt.setDouble(2, premium);
			stmt.setDouble(3, dwellingCoverage);
			stmt.setDouble(4, detacheStruc);
			stmt.setDouble(5, personalProperty);
			stmt.setDouble(6, addLivingExpense);
			stmt.setInt(7, medicalExpenses);
			stmt.setDouble(8, deductible);
			stmt.executeUpdate();
			return true;
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
}
