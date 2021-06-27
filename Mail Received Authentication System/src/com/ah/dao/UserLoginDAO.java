package com.ah.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ah.connection.ConnectionFactory;

public class UserLoginDAO {
	public boolean validate(String email, String password){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		boolean status = false;
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from mail_account where email='"+email+"' and password='"+password+"'");
			if(rs.next())
				status = true;
			else 
				status = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
