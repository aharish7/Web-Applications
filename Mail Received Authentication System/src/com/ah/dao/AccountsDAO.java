package com.ah.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ah.bean.AccountBean;
import com.ah.connection.ConnectionFactory;

public class AccountsDAO {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	List<AccountBean> users = new ArrayList<>();
	
	public AccountsDAO(){
		try {
			con = ConnectionFactory.makeConnection();
			st = con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public List<AccountBean> getUsers(){
		try{
			rs = st.executeQuery("select * from mail_account");
			while(rs.next()){
				AccountBean user = new AccountBean();
				user.setFname(rs.getString(1));
				user.setLname(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setCpassword(rs.getString(5));
				user.setBirthday(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setMobile(rs.getString(8));
				user.setLocation(rs.getString(9));
				
				users.add(user);
		
			}
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
		return users;
	}
	public String delete(String email){
		String msg = "";
		try{
			int c = st.executeUpdate("delete mail_account where email='"+email+"'");
			if(c > 0)
				msg = "Account "+email+" deleted";
			else
				msg = "Account "+email+" failed to deleted";
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;
	}

}
