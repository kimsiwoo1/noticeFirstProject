package kr.or.ddit.write.service;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.write.model.Write;
import kr.or.ddit.write.repository.IWriteDao;
import kr.or.ddit.write.repository.WriteDao;

public class WriteService implements IWriteService {
	private IWriteDao dao;
	
	public WriteService() {
		dao = new WriteDao();
	}

	@Override
	public int insertWrite(Write write) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = dao.insertWrite(sqlSession, write);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public List<Write> getWrite(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Write> list = dao.getWrite(sqlSession, postNo);
		sqlSession.close();
		return list;
	}

	@Override
	public int deleteWrite(int commentNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = dao.deleteWrite(sqlSession, commentNo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

}
