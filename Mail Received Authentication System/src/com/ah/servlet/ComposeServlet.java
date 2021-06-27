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
import com.ah.dao.ComposeDAO;

@WebServlet("/compose")
public class ComposeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setDateHeader("Expires", 0);
		String email = (String)request.getSession().getAttribute("email");
		if(email != null){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		
		String to = request.getParameter("sendto");
		String sub = request.getParameter("subject");
		String body = request.getParameter("body");
		String time = formatter.format(date);
		
		MailBean bean = new MailBean();
		bean.setSendFrom(email);
		bean.setSendTo(to);
		bean.setSubject(sub);
		bean.setBody(body);
		bean.setTime(time);
		bean.setStatus("waiting");		
		ComposeDAO dao = new ComposeDAO();
		boolean status = dao.store(bean);
		if(status){
			request.setAttribute("msg", "Mail has been sent successfully");
			request.getRequestDispatcher("useraccount.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "Failed..! Please try again.");
			request.getRequestDispatcher("useraccount.jsp").forward(request, response);
		}
	}
		else{
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}
