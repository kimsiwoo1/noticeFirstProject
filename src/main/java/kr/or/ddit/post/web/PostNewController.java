package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.util.FileuploadUtil;

/**
 * Servlet implementation class PostNewController
 */
@WebServlet("/postNew")
@MultipartConfig(maxFileSize =  1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(PostNewController.class);

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/postNew.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("postNm");
		String postContents = request.getParameter("postContents");
		String file = request.getParameter("file");
		
		Part part = request.getPart("file");
		part.getName(); //업로드 파라미터명(input의 name속성)
		part.getContentType();	//
		part.getSize();	//업로드 파일 사이즈
		
		part.getHeader("Content-Disposition");
		
		logger.debug("userId : {}", userId);
		logger.debug("postContents : {}", postContents);
		logger.debug("file : {}", file);
		
		logger.debug("part.getName() : {}", part.getName());
		logger.debug("part.getContentType() : {}", part.getContentType());
		logger.debug("header content-disposition : {}", part.getHeader("content-disposition"));
		logger.debug("part.getSize() : {}", part.getSize());
		
		String path = FileuploadUtil.getPath();

		part.write(path+UUID.randomUUID().toString() +
				FileuploadUtil.getFileExtension(part.getHeader("content-disposition")));

		doGet(request, response);
	}

}
