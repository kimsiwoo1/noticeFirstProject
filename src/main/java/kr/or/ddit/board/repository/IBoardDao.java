package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardPro;

public interface IBoardDao {
	public int insertBoard(SqlSession sqlSession, BoardPro boardPro);
	
	public List<BoardPro> getAllBoard(SqlSession sqlSession);
	
	public BoardPro getBoard(SqlSession sqlSession, int boardNo);
	
	public int updateBoard(SqlSession sqlSession, BoardPro boardPro);
}
