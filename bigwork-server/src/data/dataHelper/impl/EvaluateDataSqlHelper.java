package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import EvaluateServerAssist.ResultMessage;
import data.dataHelper.EvaluateDataHelper;

public class EvaluateDataSqlHelper implements EvaluateDataHelper{
	    Connection connection=null;//数据库连接
	    PreparedStatement statement=null;//句柄
	    ResultSet resultSet = null;//存储结果
	    
	    private void getConnect() {         //连接到数据库
			String url = "jdbc:mysql://localhost:3306/software2";
			String user = "root";
			String password = "yktobeno.1";
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
	
	public ResultMessage addEvaluate(String hotelName, double score, String comment,String memberId) {
		ResultMessage resultMessage=ResultMessage.fail;
        try {
			this.getConnect();
			String addSql="insert into evaluation (hotelName,score,comment,memberId) values("+"'"+hotelName+"'"+" , "+score+
			        " , "+"'"+comment+"'"+","+"'"+memberId+"'"+")";
			statement = connection.prepareStatement(addSql);
			statement.executeUpdate();
			System.out.println(addSql);
			resultMessage=ResultMessage.success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.freeConnect(); 
		}
        
		return resultMessage;
	}

	public ArrayList getEvaluate(String hotelName) {
		ArrayList<String> evaluateList=new ArrayList<String>();
		try {
			this.getConnect();
			String selectSql="select hotelName,score,comment,memberId from evaluation where hotelName="+"'"+hotelName+"'";
			statement=connection.prepareStatement(selectSql);
			resultSet= statement.executeQuery();
			while(resultSet.next()){
				String comment=resultSet.getString(4)+"_"+resultSet.getString(1)+"_"+resultSet.getDouble(2)+"_"+resultSet.getString(3);
				evaluateList.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.freeConnect();
		}
		return evaluateList;
	}

}
