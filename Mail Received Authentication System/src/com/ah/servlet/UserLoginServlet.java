package com.ah.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ah.dao.UserLoginDAO;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setDateHeader("Expires", 0);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserLoginDAO dao = new UserLoginDAO();
		if(dao.validate(email, password)){
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("useraccount.jsp");
		}else{
			//this should come before forward
			request.setAttribute("msg", "Email Id or Password is incorrect..!");
			request.getRequestDispatcher("userlogin.jsp").forward(request, response);
		}
	}
	

}
