package kr.or.ddit.write.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.write.model.Write;

public interface IWriteService {
	public int insertWrite(Write write);
	
	public List<Write> getWrite(int postNo);
	
	public int deleteWrite(int commentNo);
}
