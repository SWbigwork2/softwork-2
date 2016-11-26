package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.dataHelper.MembersDataHelper;
import po.MemberPO;

public class MembersDataSqlHelper implements MembersDataHelper {

	
//	public static void main(String[] args) {
//		MembersDataSqlHelper mdsr=new MembersDataSqlHelper();
//		try {
//			//mdsr.getMemberList();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
    Connection connection=null;
	
	PreparedStatement statement = null;
	
	ResultSet resultSet = null;
	private void getConnect() {         //连接到数据库
		String url = "jdbc:mysql://localhost:3306/software2";
		String user = "root";
		String password = "zl1314like@70";
		connection = SqlConnectHelper.getConnection(url, user, password);
		// TODO Auto-generated constructor stub
	}
	public MemberPO getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean updateCredit(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
