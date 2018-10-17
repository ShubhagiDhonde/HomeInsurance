package HomeIns_case_study_JunitTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import HomeIns_case_study.Dao.UserDao;
import HomeIns_case_study.model.User;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeThat;
import static org.junit.Assert.assertFalse;

public class UserDaoTest {

	@Test
	public void testGetAllUsers() throws SQLException {
		UserDao u_dao = new UserDao();
		List<User> userList= u_dao.getAllUsers();
		
		assumeNotNull(userList);
		System.out.println(userList.size());
		assertThat(userList.size(), is(not(0)));
		assumeThat(userList.get(0).getUserName(), is("jane98"));
		
	}	
}