package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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

}
