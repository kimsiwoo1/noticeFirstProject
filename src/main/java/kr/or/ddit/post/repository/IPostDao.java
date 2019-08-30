package kr.or.ddit.post.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public interface IPostDao {
	public int insertPost(SqlSession sqlSession, Post post);
	
	public List<Post> getPost(SqlSession sqlSession, int boardNo);
}
