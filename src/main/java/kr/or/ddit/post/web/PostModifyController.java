package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostModifyController
 */
@WebServlet("/postModify")
public class PostModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNm = request.getParameter("postNm");
		String postContents = request.getParameter("postContents");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("postNm", postNm);
		params.put("postContents", postContents);
		
		request.setAttribute("params", params);
		request.getRequestDispatcher("jsp/postModify.jsp");
	}

}
