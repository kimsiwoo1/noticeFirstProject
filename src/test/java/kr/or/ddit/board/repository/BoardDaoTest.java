package kr.or.ddit.board.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardPro;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoTest;
import kr.or.ddit.util.MybatisUtil;

public class BoardDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IBoardDao boardDao;
	private SqlSession sqlSession;
	
	@Before
	public void setUp() throws Exception {
		boardDao = new BoardDao();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}

//	@Test
//	public void insertBoardTest() {
//		/***Given***/
//		BoardPro boardPro = new BoardPro();
//		boardPro.setBoardNm("이름테스트");
//		boardPro.setUse("1");
//		boardPro.setUserId("brown");
//		
//		/***When***/
//		int insertCnt = boardDao.insertBoard(sqlSession, boardPro);
//		sqlSession.commit();
//		
//		/***Then***/
//		assertEquals(1, insertCnt);
//	}
	
	@Test
	public void getAllBoardTest() {
		/***Given***/
		
		/***When***/
		
		List<BoardPro> list = boardDao.getAllBoard(sqlSession);
		
		/***Then***/
		assertEquals(8, list.size());		
	}
	
	@Test
	public void getBoardTest() {
		/***Given***/
		
		/***When***/
		
		BoardPro boardPro = boardDao.getBoard(sqlSession, 6);
		
		/***Then***/
		assertEquals("테스트입니다", boardPro.getBoardNm());		
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardPro boardPro = new BoardPro();
		boardPro.setBoardNm("바꾼이름");
		boardPro.setUse("0");
		boardPro.setBoardNo(4);
		
		/***When***/
		int updateCnt = boardDao.updateBoard(sqlSession, boardPro);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, updateCnt);		
	}

}
