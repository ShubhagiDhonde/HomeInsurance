package HomeIns_case_study.util;

public class SQLQueries {
	
	// Login and Register SQL Queries
	public static final String LOGIN = "SELECT * FROM users WHERE user_name = ? AND password = ?";
	public static final String checkUsername = "SELECT * FROM users WHERE user_name = ?";
	public static final String register = "INSERT INTO users (`user_name`,`password`, `admin_role`) VALUES (?, ?, 'user')";
	public static final String getUserId = "SELECT user_id FROM users WHERE user_name = ?";
	// getQuote Queries
	public static final String SAVE_LOCATION = "INSERT INTO location (residential_type, " +
			"address1, address_2, city, state, zip, use_type, user_id) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String GET_LOCATION_ID = "SELECT location_id from location where residential_type = ? and " +
			"address1 = ? and address_2 = ? and city = ? and state = ? and zip = ? and use_type = ? and user_id = ?";
	
	public static final String SAVE_HOMEOWNER = "INSERT INTO homeowners (location_id, first_name, last_name, " +
			"dob, retired, ssn, email, users_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SAVE_PROPERTY = "INSERT INTO property_details (location_id, market_value, built_year, " +
			"square_feet, dwelling_style, roof_material, garage_type, num_full_bath, " +
			"num_half_bath, swimming_pool) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SAVE_QUOTE = "INSERT INTO quote_details (quote_id, monthly_premuim, dwelling_coverage, detached_structures, " +
			"personal_property, additional_liv_expense, medical_expense, deductable) VALUES " +
			"(?, ?, ?, ?, ?, ?, ?, ?)";

	/* Retrieving Quote from DB */
	public static final String GET_LOCATION = "select * from location where location_id = ?";
	public static final String GET_HOMEOWNER = "select * from homeowners where location_id = ?";
	public static final String GET_PROPERTY = "select * from property_details where location_id = ?";
	public static final String GET_QUOTE = "select * from quote_details where quote_id = ?";
	
	public static final String SAVE_POLICY = "INSERT INTO policy_table (policy_id, quote_id, p_effective_date, " +
			"p_end_date, policy_term, p_status, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	/* Gets all policies */
	public static final String GET_POLICIES = "SELECT * from policy_table p, Location l where p.QUOTE_ID= l.QUOTE_ID and l.USER_NAME = ?";
	public static final String GET_POLICY = "SELECT * from policy_table where policy_id = ?";
	public static final String GET_POLICY_BY_User = "SELECT * from policy_table where user_id = ?";
	public static final String RENEW_POLICY = "UPDATE policy_table SET policy_term = policy_term + 1, p_status = 'RENEWED', p_effective_date=?, p_end_date=? where policy_id = ?";
	public static final String CANCEL_POLICY = "UPDATE policy_table SET p_status = 'CANCELLED', p_end_date=? where policy_id = ?";
}
