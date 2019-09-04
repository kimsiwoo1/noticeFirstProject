package kr.or.ddit.post.repository;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.board.model.BoardPro;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.common.model.Page;
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
		assertEquals(0, list.size());		
	}
	
	@Test
	public void getDetailPostTest() {
		/***Given***/
		
		/***When***/
		Post post = dao.getDetailPost(sqlSession, 4);
		
		/***Then***/
		assertEquals("제목테스트2", post.getPostNm());		
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		Post post = new Post();
		post.setPostNm("이름바꾼다아");
		post.setPostContents("다 바꿔아");
		post.setPostNo(4);
		/***When***/
		int updateCnt = dao.updatePost(sqlSession, post);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, updateCnt);		
	}
	
	@Test
	public void getPostPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(10);
		int boardNo = 3;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pages", page);
		params.put("boardNo", boardNo);
		
		/***When***/
		List<Post> postList = dao.getPostPagingList(sqlSession, params);
		
		/***Then***/
		assertEquals(3, postList.size());		
	}
	
	@Test
	public void getPostTotalCntTest() {
		/***Given***/
		int boardNo = 3;
		/***When***/
		int totalCnt = dao.getPostTotalCnt(sqlSession, boardNo);
		
		/***Then***/
		assertEquals(3, totalCnt);		
	}
	
	@Test
	public void updateGnTest() {
		/***Given***/
		Map<String, Object> gnParams = new HashMap<String, Object>();
		int postNo = 59;
		int gn = postNo;
		gnParams.put("postNo", postNo);
		gnParams.put("gn", gn);
		/***When***/
		int updateCnt = dao.updateGn(sqlSession, gnParams);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, updateCnt);		
	}
	
	@Test
	public void updateDelTest() {
		/***Given***/
		Map<String, Object> delParams = new HashMap<String, Object>();
		int postNo = 59;
		int del = 0;
		delParams.put("postNo", postNo);
		delParams.put("del", del);
		/***When***/
		int updateCnt = dao.updateDel(sqlSession, delParams);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, updateCnt);		
	}

}
