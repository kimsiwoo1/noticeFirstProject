package kr.or.ddit.write.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.write.model.Write;

public interface IWriteDao {
	public int insertWrite(SqlSession sqlSession, Write write);
	
	public List<Write> getWrite(SqlSession sqlSession, int postNo);
	
	public int deleteWrite(SqlSession sqlSession, int commentNo);
}
