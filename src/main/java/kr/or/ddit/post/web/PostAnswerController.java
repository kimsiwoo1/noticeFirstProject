package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

/**
 * Servlet implementation class PostAnswerController
 */
@WebServlet("/postAnswer")
@MultipartConfig(maxFileSize =  1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostAnswerController.class);
	IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int gn = Integer.parseInt(request.getParameter("gn"));
		int parentPostNo = postNo;
		
		request.setAttribute("postNo", postNo);
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("parentPostNo", parentPostNo);
		request.setAttribute("gn", gn);
		request.getRequestDispatcher("jsp/postAnswer.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	
    	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    	String postNm = request.getParameter("postNm");
    	String postContents = request.getParameter("smarteditor");
    	String userId = request.getParameter("userId");
    	int parentPostNo = Integer.parseInt(request.getParameter("parentPostNo"));
    	int gn = Integer.parseInt(request.getParameter("gn"));
    	
		
		Part picture = request.getPart("picture");
		String filename = "";
		String path = "";
		//사용자가 파일을 업로드 한 경우
//		if(picture.getSize() > 0) {
//			filename = FileuploadUtil.getFilename(picture.getHeader("Content-Disposition")); //사용자가 업로드한 파일명
//			String realFilename = UUID.randomUUID().toString();
//			String ext = FileuploadUtil.getFileExtension(picture.getHeader("Content-Disposition"));
//			path = FileuploadUtil.getPath() + realFilename + ext;
//			
//			picture.write(path);
//		}
		
		logger.debug("user parameter : {}, {}, {}, {}, {}", boardNo, postNm, postContents, userId, parentPostNo);
		
		
		//글 등록
		Post post = new Post();
		post.setBoardNo(boardNo);
		post.setPostNm(postNm);
		post.setPostContents(postContents);
		post.setUserId(userId);
		post.setParentPostNo(parentPostNo);
		post.setDel("0");
		
		postService.insertPost(post);
		int postNo = post.getPostNo();
		Map<String, Object> gnParams = new HashMap<String, Object>();
		gnParams.put("postNo", postNo);
		gnParams.put("gn", gn);
		postService.updateGn(gnParams);
		logger.debug("postNo : {}", postNo);
		
		response.sendRedirect(request.getContextPath() +"/post?postNo="+postNo+"&boardNo="+boardNo+"&gn="+gn);
	}

}
