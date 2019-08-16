package com.theloc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.theloc.dao.UserDao;
import com.theloc.model.User;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		String confirm_pass = request.getParameter("confirm_pass");
		User user = new User();
		user.setUserName(username);
		user.setPassWord(pass);
		if(pass.equals(confirm_pass)) {
			UserDao userDao = new UserDao();
			if(userDao.checkSignUp(user)) {
				request.setAttribute("message", "Register Ok, please Login!!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("message", "Check confirm password!!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
