package kr.or.ddit.post.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.chart.PieChart.Data;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.FileuploadUtil;

/**
 * Servlet implementation class PostNewController
 */
@WebServlet("/postNew")
@MultipartConfig(maxFileSize =  1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(PostNewController.class);
    private IPostService postService;
    
    
    @Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		request.setAttribute("boardNo", boardNo);
		request.getRequestDispatcher("/jsp/postNew.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
		
    	int boardNo = Integer.parseInt(request.getParameter("no"));
    	String postNm = request.getParameter("postNm");
    	String postContents = request.getParameter("postContents");
    	String userId = request.getParameter("userId");
    	int postNo = 0;
    	String writeDate = null;
    	int parentPostNo = 0;
    	String del = "1";
		
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
		
		logger.debug("user parameter : {}, {}, {}, {}", boardNo, postNm, postContents, userId);
		
		//사용자 등록
		Post post = new Post();
		post.setBoardNo(boardNo);
		post.setPostNm(postNm);
		post.setPostContents(postContents);
		post.setUserId(userId);
		post.setParentPostNo(0);
		post.setDel("1");
		
		postService.insertPost(post);
		
		request.getRequestDispatcher("jsp/post.jsp").forward(request, response);

			
		
		
	}

}
