package kr.or.ddit.post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.post.repository.PostDao;
import kr.or.ddit.util.MybatisUtil;

public class PostService implements IPostService {
	private IPostDao dao;
	
	public PostService() {
		dao = new PostDao();
	}

	@Override
	public int insertPost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = dao.insertPost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public List<Post> getPost(int boardNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Post> list = dao.getPost(sqlSession, boardNo);
		sqlSession.close();
		return list;
	}

	@Override
	public Post getDetailPost(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Post post = dao.getDetailPost(sqlSession, postNo);
		sqlSession.close();
		return post;
	}

	@Override
	public int updatePost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = dao.updatePost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

}
