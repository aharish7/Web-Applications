package com.ah.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.dao.AccountsDAO;
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email1 = (String)req.getSession().getAttribute("email");
		if(email1 != null){
		
		String email = req.getParameter("email");
		AccountsDAO dao = new AccountsDAO();
		String msg = dao.delete(email);
		System.out.println(msg);
		req.getRequestDispatcher("deleteview").forward(req, resp);
		}else{
			req.getRequestDispatcher("index.html").forward(req, resp);
		}
	}
}
