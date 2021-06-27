package com.ah.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ah.bean.MailBean;
import com.ah.connection.ConnectionFactory;

public class InboxDAO {
	public List<MailBean> getInboxMails(String email){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<MailBean> mailList = new ArrayList<>();
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from mail_inbox where sendTo='"+email+"'");
			while(rs.next()){
				MailBean bean = new MailBean();
				bean.setSendFrom(rs.getString(1));
				bean.setSendTo(rs.getString(2));
				bean.setSubject(rs.getString(3));
				bean.setBody(rs.getString(4));
				bean.setTime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				mailList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailList;
	}
}
