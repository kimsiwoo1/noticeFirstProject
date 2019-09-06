package kr.or.ddit.write.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.write.service.IWriteService;
import kr.or.ddit.write.service.WriteService;

/**
 * Servlet implementation class WriteDeleteController
 */
@WebServlet("/writeDelete")
public class WriteDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IWriteService writeService;
	
	@Override
	public void init() throws ServletException {
		writeService = new WriteService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		writeService.deleteWrite(commentNo);
		response.sendRedirect(request.getContextPath() +"/post?postNo="+postNo+"&boardNo="+boardNo);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
