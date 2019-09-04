package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.user.model.User;

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

	@Override
	public List<Post> getPostPagingList(SqlSession sqlSession, Map<String, Object> params) {
		return sqlSession.selectList("post.getPostPagingList", params);
	}

	@Override
	public int getPostTotalCnt(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("post.getPostTotalCnt", boardNo);
	}

	@Override
	public int updateGn(SqlSession sqlSession, Map<String, Object> gnParams) {
		return sqlSession.update("post.updateGn", gnParams);
	}

	@Override
	public int updateDel(SqlSession sqlSession, Map<String, Object> delParams) {
		return sqlSession.update("post.updateDel", delParams);
	}

}
