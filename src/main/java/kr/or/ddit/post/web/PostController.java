package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.write.model.Write;
import kr.or.ddit.write.service.IWriteService;
import kr.or.ddit.write.service.WriteService;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
@MultipartConfig(maxFileSize =  1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPostService postService;
	private IWriteService writeService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
		writeService = new WriteService();
		
	}
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Post post = postService.getDetailPost(postNo);
		List<Write> writeList = writeService.getWrite(postNo);
		request.setAttribute("post", post);
		request.setAttribute("writeList", writeList);
		request.setAttribute("boardNo", boardNo);
		request.getRequestDispatcher("jsp/post.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
