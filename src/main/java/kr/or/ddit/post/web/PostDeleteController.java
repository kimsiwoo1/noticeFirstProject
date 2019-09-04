package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

/**
 * Servlet implementation class PostDeleteController
 */
@WebServlet("/postDelete")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int del = 1;
		
		Map<String, Object> delParams = new HashMap<String, Object>();
		delParams.put("postNo", postNo);
		delParams.put("del", del);
		
		postService.updateDel(delParams);
		
		response.sendRedirect(request.getContextPath() + "/boardView?boardNo="+ boardNo);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
