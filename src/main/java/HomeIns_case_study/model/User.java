package HomeIns_case_study.model;

public class User {

	//*******************Attributes/Fields*******************
	
	
	private int userId;
	private String userName;
	private String password;
	private String adminRole;
	
	
	
	//*******************Constructors***********************
	
	public User() {
		
		this.adminRole = "user";
		
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.adminRole = "user";
	}
	
	public User(int userId, String userName, String password, String adminRole) {
		super();		
		this.userId = userId;			//user_id
		this.userName = userName;		//user_name
		this.password = password;		//user_password
		this.adminRole = adminRole;		//useful for test study
		this.adminRole = "user";
	}
	
	
	
	
	//*******************Getters&setters********************
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}	
	
	public String toString() {
		String userInfo = "Name: " + this.getUserName() + "\nPassword: " + this.getPassword();
		return userInfo;
	}
	}







