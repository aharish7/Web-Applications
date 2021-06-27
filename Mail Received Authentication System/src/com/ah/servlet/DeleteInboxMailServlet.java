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
import com.ah.dao.DeleteMailDAO;
import com.ah.dao.InboxDAO;
import com.ah.dao.SentMailsDAO;

@WebServlet("/deletemail")
public class DeleteInboxMailServlet extends HttpServlet {
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
		String sendFrom = req.getParameter("sendfrom");
		String sendTo = req.getParameter("sendto");
		String time = req.getParameter("time");
		if(sendFrom != null){
			DeleteMailDAO dao = new DeleteMailDAO();
			String msg = dao.deleteFromInbox(email, sendFrom, time);

			System.out.println(sendFrom);System.out.println(time);
			System.out.println(msg);

			InboxDAO dao1 = new InboxDAO();
			List<MailBean> mailList = dao1.getInboxMails(email);

			Collections.sort(mailList, new MyComparator());

			req.setAttribute("mailList", mailList);
			req.getRequestDispatcher("inbox.jsp").forward(req, resp);
		}
		
		if(sendTo != null){
			DeleteMailDAO dao = new DeleteMailDAO();
			String msg = dao.deleteFromSent(email, sendTo, time);

			System.out.println(sendFrom);System.out.println(time);
			System.out.println(msg);

			SentMailsDAO dao1 = new SentMailsDAO();
			List<MailBean> mailList = dao1.getSentMails(email);

			Collections.sort(mailList, new MyComparator());

			req.setAttribute("mailList", mailList);
			req.getRequestDispatcher("sentmails.jsp").forward(req, resp);
		}

		}else{
			req.getRequestDispatcher("index.html").forward(req, resp);
		}
	}
}
