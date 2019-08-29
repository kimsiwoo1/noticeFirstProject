package kr.or.ddit.login.web;

import java.io.IOException;

import javax.servlet.ServletException;
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

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    private IUserService userService;
    
    @Override
	public void init() throws ServletException {
		userService = new UserService();
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("login controller doPost()");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
	
		User user = userService.getUser(userId);
		logger.debug("userId: {}", user.getUserId());
		logger.debug("userName: {}", user.getUserNm());
		
		if(user == null) 
			doGet(request, response);
		else if(user.checkLoginValidate(userId, pass)) {
			HttpSession session = request.getSession();
			
			session.setAttribute("S_USER", user);
			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
		}else {
			doGet(request, response);
		}
	}

}
