package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardPro;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.User;

/**
 * Servlet implementation class NoticeCreateController
 */
@WebServlet("/noticeCreat")
public class NoticeCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(NoticeCreateController.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardPro> list = boardService.getAllBoard();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/noticeCreate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String boardNm = request.getParameter("boardNm");
		String use = request.getParameter("boardSelect");
		String userId = request.getParameter("userId");
		
		logger.debug("boardNm : {}", boardNm);
		logger.debug("userId : {}", userId);
		logger.debug("use : {}", use);
		
		BoardPro boardPro = new BoardPro();
		boardPro.setBoardNm(boardNm);
		boardPro.setUse(use);
		boardPro.setUserId(userId);
		
		boardService.insertBoard(boardPro);
		
		doGet(request, response);
	
	}

}
