package com.ah.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.ah.connection.ConnectionFactory;

public class ViewMailDAO {
	public String updateInSent(String sendTo, String time, String currentTime){
		Connection con = null;
		Statement st = null;
		String msg = "";
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
			int c1 = st.executeUpdate("update mail_sent set status='"+currentTime+"' where sendto='"+sendTo+"'and time='"+time+"'");
			int c2 = st.executeUpdate("update mail_inbox set status='"+currentTime+"' where sendto='"+sendTo+"'and time='"+time+"'");
			if(c1 > 0 && c2 >0)
				msg = "updated in the sent table";
			else
				msg = "failed to update in sent table";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}

}
