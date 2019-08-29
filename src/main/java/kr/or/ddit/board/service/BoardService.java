package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardPro;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardService implements IBoardService {
	private IBoardDao dao;
	
	public BoardService() {
		dao = new BoardDao();
	}
	@Override
	public int insertBoard(BoardPro boardPro) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = dao.insertBoard(sqlSession, boardPro);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}
	@Override
	public List<BoardPro> getAllBoard() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<BoardPro> list = dao.getAllBoard(sqlSession);
		sqlSession.close();
		return list;
	}
	
	@Override
	public BoardPro getBoard(int boardNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		BoardPro boardPro = dao.getBoard(sqlSession, boardNo);
		sqlSession.close();
		return boardPro;
	}
	
	@Override
	public int updateBoard(BoardPro boardPro) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = dao.updateBoard(sqlSession, boardPro);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

}
