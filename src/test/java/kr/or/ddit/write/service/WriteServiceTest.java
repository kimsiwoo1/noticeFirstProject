package kr.or.ddit.write.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.write.model.Write;

public class WriteServiceTest {
	private IWriteService service;


	@Before
	public void setup() {
		service = new WriteService();
	}
	
//	@Test
//	public void insertWriteTest() {
//		/***Given***/
//		Write write = new Write();
//		write.setContents("내용");
//		write.setDel("0");
//		write.setPostNo(61);
//		write.setUserId("brown");
//		write.setWriter("brown");
//		/***When***/
//		
//		int insertCnt = service.insertWrite(write);
//		
//		/***Then***/
//		assertEquals(1, insertCnt);		
//	}
	
	@Test
	public void getWriteTest() {
		/***Given***/
		int postNo = 60;
		/***When***/
		
		List<Write> list = service.getWrite( postNo);
		
		/***Then***/
		assertEquals(1, list.size());		
	}
	
	@Test
	public void deleteWriteTest() {
		/***Given***/
		int commentNo = 1;
		/***When***/
		
		int deleteCnt = service.deleteWrite(commentNo);
		
		/***Then***/
		assertEquals(1, deleteCnt);		
	}

}
