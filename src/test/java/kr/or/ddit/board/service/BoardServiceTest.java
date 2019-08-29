package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.board.model.BoardPro;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

public class BoardServiceTest {
	private IBoardService boardService;


	@Before
	public void setup() {
		boardService = new BoardService();
	}

//	@Test
//	public void insertBoardTest() {
//		/***Given***/
//		BoardPro boardPro = new BoardPro();
//		boardPro.setBoardNm("코니이름테스트");
//		boardPro.setUse("0");
//		boardPro.setUserId("cony");
//		
//		/***When***/
//		int insertCnt = boardService.insertBoard(boardPro);
//		
//		/***Then***/
//		assertEquals(1, insertCnt);
//	}
	
	@Test
	public void getAllBoardTest() {
		/***Given***/
		
		/***When***/
		List<BoardPro> list = boardService.getAllBoard();
		
		/***Then***/
		assertEquals(8, list.size());		
	}
	
	
	@Test
	public void getBoardTest() {
		/***Given***/
		
		/***When***/
		
		BoardPro boardPro = boardService.getBoard(6);
		
		/***Then***/
		assertEquals("테스트입니다", boardPro.getBoardNm());		
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardPro boardPro = new BoardPro();
		boardPro.setBoardNm("바꾼다아");
		boardPro.setUse("1");
		boardPro.setBoardNo(4);
		
		/***When***/
		int updateCnt = boardService.updateBoard(boardPro);
		
		/***Then***/
		assertEquals(1, updateCnt);		
	}

}
