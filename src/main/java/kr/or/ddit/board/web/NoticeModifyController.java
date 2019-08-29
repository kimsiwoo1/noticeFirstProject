package kr.or.ddit.board.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardPro;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class NoticeModifyController
 */
@WebServlet("/noticeModify")
public class NoticeModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(NoticeModifyController.class);
	IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNm = request.getParameter("boardNm");
		String use = request.getParameter("boardSelect");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		logger.debug("boardNm : {}", boardNm);
		logger.debug("use : {}", use);
		logger.debug("boardNo : {}", boardNo);
		
		
		BoardPro boardPro = new BoardPro();
		boardPro.setBoardNm(boardNm);
		boardPro.setUse(use);
		boardPro.setBoardNo(boardNo);
		
		boardService.updateBoard(boardPro);
		request.getRequestDispatcher("jsp/noticeCreate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
