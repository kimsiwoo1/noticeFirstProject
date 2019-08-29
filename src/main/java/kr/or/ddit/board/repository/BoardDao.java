package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardPro;

public class BoardDao implements IBoardDao {

	
	@Override
	public int insertBoard(SqlSession sqlSession, BoardPro boardPro) {
		return sqlSession.insert("board.insertBoard", boardPro);
	}

	@Override
	public List<BoardPro> getAllBoard(SqlSession sqlSession) {
		return sqlSession.selectList("board.getAllBoard");
	}

	@Override
	public BoardPro getBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("board.getBoard", boardNo);
	}

	@Override
	public int updateBoard(SqlSession sqlSession, BoardPro boardPro) {
		return sqlSession.update("board.updateBoard", boardPro);
	}
	
	

}
