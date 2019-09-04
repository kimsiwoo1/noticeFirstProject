package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;


@WebServlet("/postModifyAction")
@MultipartConfig(maxFileSize =  1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostModifyActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostModifyActionController.class);
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String postNm = request.getParameter("postNm");
		String postContents = request.getParameter("smarteditor");
		
		Post post = new Post();
		post.setPostNm(postNm);
		post.setPostNo(postNo);
		post.setPostContents(postContents);
		
		postService.updatePost(post);
		
		response.sendRedirect(request.getContextPath() + "/post?postNo="+ postNo+"&boardNo="+boardNo);
	}

}
