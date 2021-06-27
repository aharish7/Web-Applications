package com.ah.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ah.bean.MailBean;
import com.ah.connection.ConnectionFactory;

public class ComposeDAO {
	public boolean store(MailBean bean){
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean status = false;
		int c1 = 0;
		int c2 = 0;
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from mail_account where email='"+bean.getSendTo()+"'");
			if(rs.next()){
				ps = con.prepareStatement("insert into mail_inbox values(?,?,?,?,?,?)");
				ps.setString(1, bean.getSendFrom());
				ps.setString(2, bean.getSendTo());
				ps.setString(3, bean.getSubject());
				ps.setString(4, bean.getBody());
				ps.setString(5, bean.getTime());
				ps.setString(6, bean.getStatus());
				
				c1 = ps.executeUpdate();
				
				ps = con.prepareStatement("insert into mail_sent values(?,?,?,?,?,?)");
				ps.setString(1, bean.getSendFrom());
				ps.setString(2, bean.getSendTo());
				ps.setString(3, bean.getSubject());
				ps.setString(4, bean.getBody());
				ps.setString(5, bean.getTime());
				ps.setString(6, bean.getStatus());
				
				c2 = ps.executeUpdate();
				
			/*	c1 = st.executeUpdate("insert into mail_inbox(sendfrom,sendto,subject,body,time,status) "
						+ "values('"+bean.getSendFrom()+"','"+bean.getSendTo()+"',"
						+ "'"+bean.getSubject()+"','"+bean.getBody()+"','"+bean.getTime()+"','"+bean.getStatus()+"'");
				
				c2 = st.executeUpdate("insert into mail_sent(sendfrom,sendto,subject,body,time,status) "
						+ "values('"+bean.getSendFrom()+"','"+bean.getSendTo()+"',"
						+ "'"+bean.getSubject()+"','"+bean.getBody()+"','"+bean.getTime()+"','"+bean.getStatus()+"'");
			 */
				if(c1 == 1 && c2 == 1)
					status = true;
				else 
					status = false;
			}
			else 
				status = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
