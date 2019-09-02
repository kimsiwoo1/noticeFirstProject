package kr.or.ddit.post.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public interface IPostService {
	public int insertPost(Post post);
	
	public List<Post> getPost(int boardNo);
	
	public Post getDetailPost(int postNo);
	
	public int updatePost(Post post);
}
