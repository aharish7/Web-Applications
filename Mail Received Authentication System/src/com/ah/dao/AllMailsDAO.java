package com.ah.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import com.ah.bean.MailBean;
import com.ah.comparator.MyComparator;
import com.ah.connection.ConnectionFactory;

public class AllMailsDAO {
	public Set<MailBean> getAllMails(String email){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Set<MailBean> mailList = new TreeSet<>(new MyComparator());
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from mail_sent where sendfrom='"+email+"'");
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
			rs = st.executeQuery("select * from mail_inbox where sendto='"+email+"'");
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
