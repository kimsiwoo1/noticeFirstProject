package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;

public class PostServiceTest {
	private IPostService service;


	@Before
	public void setup() {
		service = new PostService();
	}

//	@Test
//	public void insertPostTest() {
//		/***Given***/
//		Post post = new Post();
//		post.setDel("0");
//		post.setPostContents("ashhrr35");
//		post.setPostNm("제목테스트2");
//		post.setBoardNo(1);
//		post.setUserId("brown");
//		/***When***/
//		
//		int insertCnt = service.insertPost(post);
//		
//		/***Then***/
//		assertEquals(1, insertCnt);		
//	}
	
	@Test
	public void getPostTest() {
		/***Given***/

		/***When***/
		
		List<Post> list = service.getPost(5);
		
		/***Then***/
		assertEquals(0, list.size());		
	}
	
	@Test
	public void getDetailPostTest() {
		/***Given***/
		
		/***When***/
		Post post = service.getDetailPost(4);
		
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
		int updateCnt = service.updatePost(post);
		
		/***Then***/
		assertEquals(1, updateCnt);		
	}
	
	@Test
	public void getPostPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(10);
		int boardNo = 5;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pages", page);
		params.put("boardNo", boardNo);
		
		/***When***/
		List<Post> postList = service.getPostPagingList(params);
		
		/***Then***/
		assertEquals(6, postList.size());		
	}
	
	@Test
	public void getPostTotalCntTest() {
		/***Given***/
		int boardNo = 5;
		/***When***/
		int totalCnt = service.getPostTotalCnt(boardNo);
		
		/***Then***/
		assertEquals(6, totalCnt);		
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
		int updateCnt = service.updateGn(gnParams);
		
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
		int updateCnt = service.updateDel(delParams);
		
		/***Then***/
		assertEquals(1, updateCnt);		
	}

}
