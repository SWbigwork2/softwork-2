package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import Evaluateblimpl.ResultMessage;
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
	
	public ResultMessage addEvaluate(String hotelName, double score, String comment,String memberName) {
		ResultMessage resultMessage=ResultMessage.fail;
        try {
			this.getConnect();
			String addSql="insert into evaluation (hotelName,score,comment,memberName) values("+"'"+hotelName+"'"+" , "+score+
			        " , "+"'"+comment+"'"+","+"'"+memberName+"'"+")";
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

	public ArrayList<String> getEvaluate(String hotelName) {
		ArrayList<String> evaluateList=new ArrayList<String>();
		try {
			this.getConnect();
			String selectSql="select comment,memberName from evaluation where hotelName="+"'"+hotelName+"'";
			statement=connection.prepareStatement(selectSql);
			resultSet= statement.executeQuery();
			while(resultSet.next()){
				String comment=resultSet.getString(2)+":"+resultSet.getString(1);
				System.out.println(comment);
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
	
	public ArrayList<Double> getScore(String hotelName){
		ArrayList<Double> hotelScore=new ArrayList<Double>();
		try {
			this.getConnect();
			String selectSql="select score from evaluation where hotelName="+"'"+hotelName+"'";
			statement=connection.prepareStatement(selectSql);
			resultSet= statement.executeQuery();
			while(resultSet.next()){
				double score=resultSet.getDouble(1);
				System.out.println(score);
				hotelScore.add(score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.freeConnect();
		}
		return hotelScore;
	}
	
	

}
