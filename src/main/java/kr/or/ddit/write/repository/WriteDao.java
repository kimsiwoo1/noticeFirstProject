package kr.or.ddit.write.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.write.model.Write;

public class WriteDao implements IWriteDao {

	@Override
	public int insertWrite(SqlSession sqlSession, Write write) {
		return sqlSession.insert("write.insertWrite", write);
	}

	@Override
	public List<Write> getWrite(SqlSession sqlSession, int postNo) {
		return sqlSession.selectList("write.getWrite", postNo);
	}

	@Override
	public int deleteWrite(SqlSession sqlSession, int commentNo) {
		return sqlSession.update("write.deleteWrite", commentNo);
	}


}
