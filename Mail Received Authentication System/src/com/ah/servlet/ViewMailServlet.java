package com.ah.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.bean.MailBean;
import com.ah.dao.ViewMailDAO;
@WebServlet("/viewmail")
public class ViewMailServlet extends HttpServlet	 {
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
		String sub = req.getParameter("subject");
		String body = req.getParameter("body");
		String status = req.getParameter("status");
		
		MailBean bean = new MailBean();
		bean.setSendFrom(sendFrom);
		bean.setSendTo(sendTo);
		bean.setSubject(sub);
		bean.setTime(time);
		bean.setBody(body);
		bean.setStatus(status);
		
		if(!status.equalsIgnoreCase("waiting")){
			ViewMailDAO dao = new ViewMailDAO();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String currentTime = formatter.format(date);
			String msg = dao.updateInSent(sendTo, time, currentTime);
			System.out.println(msg);
		}
		req.setAttribute("mailBean", bean);
		req.getRequestDispatcher("viewmailcontent.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("index.html").forward(req, resp);
		}
	}
}
