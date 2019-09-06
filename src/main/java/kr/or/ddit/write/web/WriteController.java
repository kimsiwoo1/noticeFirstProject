package kr.or.ddit.write.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.write.model.Write;
import kr.or.ddit.write.service.IWriteService;
import kr.or.ddit.write.service.WriteService;

/**
 * Servlet implementation class WriteController
 */
@WebServlet("/write")
public class WriteController extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(WriteController.class);
	private static final long serialVersionUID = 1L;
	private IWriteService writeService;
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		writeService = new WriteService();
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("S_USER");
		
		String userId = user.getUserId();
		String writer = user.getUserNm();
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String contents = request.getParameter("contents");
		String del = "0";
		logger.debug("userId : {}", userId);
		logger.debug("writer : {}", writer);
		logger.debug("postNo : {}", postNo);
		logger.debug("boardNo : {}", boardNo);
		logger.debug("contents : {}", contents);
		logger.debug("del : {}", del);
		
		Write write = new Write();
		write.setContents(contents);
		write.setDel(del);
		write.setPostNo(postNo);
		write.setUserId(userId);
		write.setWriter(writer);
		
		request.setAttribute("postNo", postNo);
		request.setAttribute("boardNo", boardNo);
		
		writeService.insertWrite(write);
		response.sendRedirect(request.getContextPath() +"/post?postNo="+postNo+"&boardNo="+boardNo);
	}

}
