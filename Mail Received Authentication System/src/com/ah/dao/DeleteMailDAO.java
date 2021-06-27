package com.ah.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.ah.connection.ConnectionFactory;

public class DeleteMailDAO {
	public String deleteFromInbox(String email, String sendFrom, String time){
		Connection con = null;
		Statement st = null;
		String msg = "";
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
			int c = st.executeUpdate("delete mail_inbox where sendFrom='"+sendFrom+"'and time='"+time+"'");
			if(c != 0)
				msg = c+"Mails deleted from "+email;
			else
				msg = "Deletion failed from "+email;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public String deleteFromSent(String email, String sendTo, String time){
		Connection con = null;
		Statement st = null;
		String msg = "";
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
			int c = st.executeUpdate("delete mail_sent where sendFrom='"+sendTo+"'and time='"+time+"'");
			if(c != 0)
				msg = c+"Mails deleted from "+email;
			else
				msg = "Deletion failed from "+email;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
