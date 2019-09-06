package kr.or.ddit.write.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.or.ddit.user.repository.UserDaoTest;
import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.write.model.Write;

public class WriteDaoTest {
private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IWriteDao writeDao;
	private SqlSession sqlSession;
	
	@Before
	public void setUp() throws Exception {
		writeDao = new WriteDao();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}

//	@Test
//	public void insertWriteTest() {
//		/***Given***/
//		Write write = new Write();
//		write.setContents("내용");
//		write.setDel("0");
//		write.setPostNo(60);
//		write.setUserId("brown");
//		write.setWriter("brown");
//		/***When***/
//		
//		int insertCnt = writeDao.insertWrite(sqlSession, write);
//		sqlSession.commit();
//		
//		/***Then***/
//		assertEquals(1, insertCnt);		
//	}
	
	@Test
	public void getWriteTest() {
		/***Given***/
		int postNo = 60;
		/***When***/
		
		List<Write> list = writeDao.getWrite(sqlSession, postNo);
		
		/***Then***/
		assertEquals(1, list.size());		
	}
	
	@Test
	public void deleteWriteTest() {
		/***Given***/
		int commentNo = 1;
		/***When***/
		
		int deleteCnt = writeDao.deleteWrite(sqlSession, commentNo);
		
		/***Then***/
		assertEquals(1, deleteCnt);		
	}

}
