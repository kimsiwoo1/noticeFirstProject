package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardPro;

public interface IBoardService {
	public int insertBoard(BoardPro boardPro);
	
	public List<BoardPro> getAllBoard();
	
	public BoardPro getBoard(int boardNo);
	
	public int updateBoard(BoardPro boardPro);
}
