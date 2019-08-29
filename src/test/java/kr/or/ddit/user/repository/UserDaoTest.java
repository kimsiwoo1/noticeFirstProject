package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IUserDao userDao;
	private SqlSession sqlSession;
	
	private String userId = "brownTest";

	@Before
	public void setUp() throws Exception {
		userDao = new UserDao();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}

	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		
		/***When***/
		User userVo = userDao.getUser(sqlSession, userId);
		
		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
	}

}
