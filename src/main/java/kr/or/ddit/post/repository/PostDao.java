package kr.or.ddit.post.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public class PostDao implements IPostDao {


	@Override
	public int insertPost(SqlSession sqlSession, Post post) {
		return sqlSession.insert("post.insertPost", post);
	}

	@Override
	public List<Post> getPost(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectList("post.getPost", boardNo);
	}

	@Override
	public Post getDetailPost(SqlSession sqlSession, int postNo) {
		return sqlSession.selectOne("post.getDetailPost", postNo);
	}

	@Override
	public int updatePost(SqlSession sqlSession, Post post) {
		return sqlSession.update("post.updatePost", post);
	}

}
