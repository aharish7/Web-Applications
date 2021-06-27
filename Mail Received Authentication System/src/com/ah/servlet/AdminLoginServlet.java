package com.ah.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		if(email.equals("admin@gmail.com") && pass.equals("admin11")){
			req.getSession().setAttribute("email", email);
			System.out.println(req.getSession().getAttribute("email"));
			req.getRequestDispatcher("adminpage.jsp").forward(req, resp);
		}else{
			req.setAttribute("msg", "Email or Password is incorrect..!");
			req.getRequestDispatcher("adminlogin.jps").forward(req, resp);
		}
	}

}
