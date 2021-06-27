package com.ah.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.bean.AccountBean;
import com.ah.dao.CreateAccountDAO;

@WebServlet("/create")
public class CreateAccountServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setDateHeader("Expires", 0);
		AccountBean bean = new AccountBean();
		
		bean.setFname(request.getParameter("fname"));
		bean.setLname(request.getParameter("lname"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		bean.setCpassword(request.getParameter("cpassword"));
		bean.setBirthday(request.getParameter("birthday"));
		bean.setGender(request.getParameter("gender"));
		bean.setMobile(request.getParameter("mobile"));
		bean.setLocation(request.getParameter("location"));
		
		CreateAccountDAO dao = new CreateAccountDAO();
		String msg = dao.create(bean);
		System.out.println(msg);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("newaccount.jsp").forward(request, response);
		
			
	}
}
