package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.user.model.User;

public interface IPostDao {
	public int insertPost(SqlSession sqlSession, Post post);
	
	public List<Post> getPost(SqlSession sqlSession, int boardNo);
	
	public Post getDetailPost(SqlSession sqlSession, int postNo);
	
	public int updatePost(SqlSession sqlSession, Post post);
	
	List<Post> getPostPagingList(SqlSession sqlSession, Map<String, Object> params);
	
	int getPostTotalCnt(SqlSession sqlSession, int boardNo);
	
	int updateGn(SqlSession sqlSession, Map<String, Object> gnParams);
	
	int updateDel(SqlSession sqlSession, Map<String, Object> delParams);
	
}
