package data.dataHelper.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.dataHelper.MembersDataHelper;
import po.CreditrecordPO;
import po.MemberPO;

public class MembersDataSqlHelper implements MembersDataHelper {

	
    Connection connection=null;
	
	PreparedStatement statement = null;
	
	ResultSet resultSet = null;
	private void getConnect() {         //连接到数据库
		String url = "jdbc:mysql://localhost:3306/software2";
		String user = "root";
		String password = "zhurunzhi654";
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
	public MemberPO getMember(String id) {
		// TODO Auto-generated method stub
		MemberPO po=null;
		try{		
			getConnect();
			String sql="select * from members where id = "+id+"";
			
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				String name =resultSet.getString(2);
				String password=resultSet.getString(3);
				String special=resultSet.getString(4);
				double credit=resultSet.getDouble(5);
				String telephone=resultSet.getString(6);
				int type=resultSet.getInt(7);
				int level=resultSet.getInt(8);
			  po= new MemberPO(id,password,name,telephone,credit,special,type,level);
			}
		
			}catch(SQLException e){
				e.printStackTrace();
			}
			finally { 
				freeConnect();
			}
		return po;
	}


	public boolean updateMemberCredit(String id,double changecredit) {
		// TODO Auto-generated method stub	
		try {
			getConnect();
			  int viplevel=1;
			  if(changecredit<0){
				  viplevel=0;
			  }else if(changecredit>=0&&viplevel<500){
				  viplevel=1;
			  }else if(changecredit>=500&&changecredit<1000){
				  viplevel=2;
			  }else if(changecredit>=1000&&changecredit<2000){
				  viplevel=3;
			  }else if(changecredit>=2000&&changecredit<3000){
				  viplevel=4;
			  }else if(changecredit>=3000&&changecredit<5000){
				  viplevel=5;
			  }else if(changecredit>=5000){
				  viplevel=6;
			  }
			  String sql="update members set credit="+changecredit+", level="+viplevel+" where id ="+"'"+id+"'";
				
				statement = connection.prepareStatement(sql);
			  statement.executeUpdate();
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid) {
		// TODO Auto-generated method stub
		ArrayList<CreditrecordPO> list=new ArrayList<CreditrecordPO>();
		try {
			getConnect();
			String creditrecordsql="select * from creditrecord where memberid ="+memberid+"";
			statement=connection.prepareStatement(creditrecordsql);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
			   String time=resultSet.getString(2);
			   int orderid=resultSet.getInt(3);
			   String action=resultSet.getString(4);
			   double changecredit=resultSet.getDouble(5);
			   double resultcredit=resultSet.getDouble(6);
			   CreditrecordPO creditrecordPO=new CreditrecordPO(memberid, time, orderid, action, changecredit, resultcredit);
			   list.add(creditrecordPO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			freeConnect();
		}
		return list;
	}
	@Override
	public void insertCreditRecord(CreditrecordPO po) {
		// TODO Auto-generated method stub
		try {
			getConnect();
			String sql="insert into creditrecord (memberid,time,orderid,action,creditchange,creditresult ) values( "+"'"+po.getMemberid()+"'"+","+"'"+po.getTime()+"'"+","
			+po.getRecordid()+","+"'"+po.getAction()+"'"+","+po.getCreditchange()+","+po.getCreditresult()+")";
			 statement=connection.prepareStatement(sql);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			freeConnect();
		}
	}

}
