package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.user.model.User;

public class UserServiceTest {
	private IUserService userService;
	private String userId = "brownTest";


	@Before
	public void setup() {
		userService = new UserService();
	}

	@Test
	public void getUserTest() {
		/*** Given ***/
		String userId = "cony";

		/*** When ***/
		User userVo = userService.getUser(userId);

		/*** Then ***/
		assertEquals("코니", userVo.getUserNm());
	}

}
