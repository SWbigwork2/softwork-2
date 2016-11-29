package data.dataHelper.impl;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import data.dataHelper.MembersDataHelper;
import po.MemberPO;

public class MembersDataSqlHelper implements MembersDataHelper {

	
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
	private void freeConnect(){       //释放连接
		try {
			SqlConnectHelper.close(connection, statement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MemberPO getMember(String id) throws SQLException {
		// TODO Auto-generated method stub
		try{
			
			getConnect();
			String sql="select * from members where id = "+id+"";
			
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if(resultSet!=null){
				String name =resultSet.getString(2);
				String password=resultSet.getString(3);
				String special=resultSet.getString(4);
				double credit=resultSet.getDouble(5);
				String telephone=resultSet.getString(6);
				int type=resultSet.getInt(7);
				int level=resultSet.getInt(8);
			    return new MemberPO(id,password,name,telephone,credit,special,type,level);
			}else{
				return null;
			}
			
			
			}
			finally { 
				freeConnect();
			}
	}


	public boolean updateMemberCredit(String id,double changecredit) {
		// TODO Auto-generated method stub	
		try {
			getConnect();
			String sql="select * from members where id = "+id+"";
			if(sql!=null){
				sql="update members set credit="+changecredit+" where id="+id+"";
				statement = connection.prepareStatement(sql);
			  statement.executeUpdate();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
