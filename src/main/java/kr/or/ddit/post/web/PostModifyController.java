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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class PostModifyController
 */
@WebServlet("/postModify")
@MultipartConfig(maxFileSize =  1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostModifyController.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String postNm = request.getParameter("postNm");
		String postContents = request.getParameter("postContents");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		logger.debug("postNm : {}", postNm);
		logger.debug("postContents : {}", postContents);
		logger.debug("postNo : {}", postNo);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("postNm", postNm);
		params.put("postContents", postContents);
		params.put("postNo", postNo);
		params.put("boardNo", boardNo);
		
		request.setAttribute("params", params);
		request.getRequestDispatcher("jsp/postModify.jsp").forward(request, response);
	}

}
