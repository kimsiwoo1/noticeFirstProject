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
//		post.setBoardNo(4);
//		post.setUserId("brown");
//		post.setParentPostNo(1);
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
		assertEquals(1, list.size());		
	}

}
