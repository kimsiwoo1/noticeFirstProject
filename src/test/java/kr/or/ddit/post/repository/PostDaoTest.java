package kr.or.ddit.post.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.board.model.BoardPro;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {
	private IPostDao dao;
	private SqlSession sqlSession;
	
	@Before
	public void setUp() throws Exception {
		dao = new PostDao();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}
	
//	@Test
//	public void insertPostTest() {
//		/***Given***/
//		Post post = new Post();
//		post.setDel("1");
//		post.setPostContents("asdfasdf");
//		post.setPostNm("제목테스트");
//		post.setBoardNo(5);
//		post.setUserId("brown");
//		post.setParentPostNo(1);
//		/***When***/
//		
//		int insertCnt = dao.insertPost(sqlSession, post);
//		sqlSession.commit();
//		
//		/***Then***/
//		assertEquals(1, insertCnt);		
//	}
	
	@Test
	public void getPostTest() {
		/***Given***/

		/***When***/
		
		List<Post> list = dao.getPost(sqlSession, 5);
		
		/***Then***/
		assertEquals(1, list.size());		
	}

}