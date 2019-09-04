package kr.or.ddit.post.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public interface IPostService {
	public int insertPost(Post post);
	
	public List<Post> getPost(int boardNo);
	
	public Post getDetailPost(int postNo);
	
	public int updatePost(Post post);
	
	List<Post> getPostPagingList(Map<String, Object> params);
	
	int getPostTotalCnt(int boardNo);
	
	int updateGn(Map<String, Object> gnParams);
	
	int updateDel(Map<String, Object> delParams);
}
