package com.ah.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.bean.MailBean;
import com.ah.dao.AllMailsDAO;
@WebServlet("/allmails")
public class AllMailsServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		resp.setDateHeader("Expires", 0);
		String email = (String)req.getSession().getAttribute("email");
		if(email != null){
		AllMailsDAO dao = new AllMailsDAO();
		Set<MailBean> mailList = dao.getAllMails(email);
		
		
		
		req.setAttribute("mailList", mailList);
		req.getRequestDispatcher("allmails.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("index.html").forward(req, resp);
		}
	}
}
