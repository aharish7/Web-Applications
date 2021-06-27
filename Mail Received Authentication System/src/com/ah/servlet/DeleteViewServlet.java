package com.ah.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.bean.AccountBean;
import com.ah.dao.AccountsDAO;
@WebServlet("/deleteview")
public class DeleteViewServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email1 = (String)req.getSession().getAttribute("email");
		if(email1 != null){
		
		AccountsDAO dao = new AccountsDAO();
		List<AccountBean> users = dao.getUsers();
		
		req.setAttribute("users", users);
		req.getRequestDispatcher("deleteusers.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("index.html").forward(req, resp);
		}
	}
}
