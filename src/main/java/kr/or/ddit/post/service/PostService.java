package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
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
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public Post getDetailPost(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Post post = dao.getDetailPost(sqlSession, postNo);
		sqlSession.commit();
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

	@Override
	public List<Post> getPostPagingList(Map<String, Object> params) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Post> postList = dao.getPostPagingList(sqlSession, params);
		int boardNo = (int) params.get("boardNo");
		Page p = (Page) params.get("pages");
		int totalCnt = dao.getPostTotalCnt(sqlSession, boardNo);
		params.put("paginationSize", (int)Math.ceil((double)totalCnt / p.getPagesize()));
		sqlSession.commit();
		sqlSession.close();
		return postList;
	}

	@Override
	public int getPostTotalCnt(int boardNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int totalCnt = dao.getPostTotalCnt(sqlSession, boardNo);
		sqlSession.commit();
		sqlSession.close();
		return totalCnt;
	}

	@Override
	public int updateGn(Map<String, Object> gnParams) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = dao.updateGn(sqlSession, gnParams);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int updateDel(Map<String, Object> delParams) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = dao.updateDel(sqlSession, delParams);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

}
