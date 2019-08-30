package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

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
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

/**
 * Servlet implementation class BoardViewController
 */
@WebServlet("/boardView")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(NoticeCreateController.class);
	
	private IBoardService boardService;
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		postService = new PostService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardPro boardPro  = boardService.getBoard(boardNo);
		List<Post> postList = postService.getPost(boardNo);
		request.setAttribute("boardPro", boardPro);
		request.setAttribute("postList", postList);
		request.getRequestDispatcher("jsp/boardView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
