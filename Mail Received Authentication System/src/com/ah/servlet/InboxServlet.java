package com.ah.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.bean.MailBean;
import com.ah.comparator.MyComparator;
import com.ah.dao.InboxDAO;

@WebServlet("/inbox")
public class InboxServlet extends HttpServlet {
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
		InboxDAO dao = new InboxDAO();
		List<MailBean> mailList = dao.getInboxMails(email);
		Collections.sort(mailList, new MyComparator());
		
		req.setAttribute("mailList", mailList);
		req.getRequestDispatcher("inbox.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("index.html").forward(req, resp);
		}
	}
}
