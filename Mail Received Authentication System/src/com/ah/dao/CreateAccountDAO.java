package com.ah.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ah.bean.AccountBean;
import com.ah.connection.ConnectionFactory;

public class CreateAccountDAO {
	public String create(AccountBean bean){
		String msg = "";
		int count = 0;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
			rs = st.executeQuery("select count(*) from mail_account where email='"+bean.getEmail()+"'");
			if(rs.next()){
				count = rs.getInt(1);
				if(count == 0){
					ps = con.prepareStatement("insert into mail_account values(?,?,?,?,?,?,?,?,?)");
					ps.setString(1, bean.getFname());
					ps.setString(2, bean.getLname());
					ps.setString(3, bean.getEmail());
					ps.setString(4, bean.getPassword());
					ps.setString(5, bean.getCpassword());
					ps.setString(6, bean.getBirthday());
					ps.setString(7, bean.getGender());
					ps.setString(8, bean.getMobile());
					ps.setString(9, bean.getLocation());
					int c = ps.executeUpdate();
					if(c == 1)
						msg = "Account created successfully";
					else
						msg = "Failed! please try again";
				}else
					msg = "User already exists with this email id";
			}else
				msg = "Somthing went wrong!";
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(con != null)
					con.close();
				if(st != null)
					st.close();
				if(rs != null)
					rs.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return msg;
	}
}
