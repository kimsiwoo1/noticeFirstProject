package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardPro;
import kr.or.ddit.common.model.Page;

public interface IBoardService {
	public int insertBoard(BoardPro boardPro);
	
	public List<BoardPro> getAllBoard();
	
	public BoardPro getBoard(int boardNo);
	
	public int updateBoard(BoardPro boardPro);
	
}
