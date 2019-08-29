package kr.or.ddit.post.repository;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public interface IPostDao {
	public int insertPost(SqlSession sqlSession, Post post);
}
