package data.dataHelper.impl;

import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.StyledEditorKit.BoldAction;

import data.dataHelper.PromotionsDataHelper;
import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;

public class PromotionsDataSqlHelper implements PromotionsDataHelper{

    Connection connection=null;
	
	PreparedStatement statement = null;
	
	ResultSet resultSet = null;
	private void getConnect() {         //连接到数据库
		String url = "jdbc:mysql://localhost:3306/software2";
		String user = "root";
		String password = "zl1314like@70";
		connection = SqlConnectHelper.getConnection(url, user, password);
		// TODO Auto-generated constructor stubc
	}
	private void freeConnect(){       //释放连接
		try {
			SqlConnectHelper.close(connection, statement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean addPromotionsI(PromotionsIPO promotionsIPO){
		

		boolean result=false;
		try {
			getConnect();
			if(!isExist(promotionsIPO) ){
			String sql="insert into strategiesi values("+promotionsIPO.getType()+","+"'"+promotionsIPO.getHotel()+"'"
					+","+"'"+promotionsIPO.getIntroduction()+"'"+","+promotionsIPO.getDiscount()+")";
			 statement=connection.prepareStatement(sql);
				int row=statement.executeUpdate();
				if(row==1)
				result=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
		
		
	}
	public  boolean addPromotionsII(PromotionsIIPO promotionsIIPO){
		boolean result=false;
		try {
			getConnect();
			if(!isExist(promotionsIIPO) ){
			String sql="insert into strategiesi values("+promotionsIIPO.getType()+","+"'"+promotionsIIPO.getHotel()+"'"
					+","+"'"+promotionsIIPO.getIntroduction()+"'"+","
					+"'"+promotionsIIPO.getStartdate()+"'"+","
					+"'"+promotionsIIPO.getEnddate()+"'"+","+promotionsIIPO.getDiscount()+")";
			 statement=connection.prepareStatement(sql);
				int row=statement.executeUpdate();
				if(row==1)
				result=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
		
	}
public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO){
		

		boolean result=false;
		try {
			getConnect();
			if(!isExist(promotionsIIIPO) ){
			String sql="insert into strategiesi values("+promotionsIIIPO.getType()+","+"'"+promotionsIIIPO.getHotel()+"'"
					+","+"'"+promotionsIIIPO.getIntroduction()+"'"+","
					+promotionsIIIPO.getNum()+","+promotionsIIIPO.getDiscount()+")";
			 statement=connection.prepareStatement(sql);
				int row=statement.executeUpdate();
				if(row==1)
				result=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
		
		
	}
public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO){
	

	boolean result=false;
	try {
		getConnect();
		if(!isExist(promotionsIVPO) ){
		String sql="insert into strategiesi values("+promotionsIVPO.getType()+","+"'"+promotionsIVPO.getHotel()+"'"
				+","+"'"+promotionsIVPO.getIntroduction()+"'"+","+promotionsIVPO.getDiscount()+")";
		 statement=connection.prepareStatement(sql);
			int row=statement.executeUpdate();
			if(row==1)
			result=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result;
	
	
}
public boolean addPromotionsV(PromotionsVPO promotionsVPO){
	

	boolean result=false;
	try {
		getConnect();
		if(!isExist(promotionsVPO) ){
		String sql="insert into strategiesi values("+promotionsVPO.getType()+","+"'"+promotionsVPO.getHotel()+"'"
				+","+"'"+promotionsVPO.getIntroduction()+"'"+","
				+promotionsVPO.getViplevel()+","+"'"+promotionsVPO.getArea()+"'"+","+promotionsVPO.getDiscount()+")";
		 statement=connection.prepareStatement(sql);
			int row=statement.executeUpdate();
			if(row==1)
			result=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result;
	
	
}
public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO){
	

	boolean result=false;
	try {
		getConnect();
		if(!isExist(promotionsVIPO) ){
		String sql="insert into strategiesi values("+promotionsVIPO.getType()+","+"'"+promotionsVIPO.getHotel()+"'"
				+","+"'"+promotionsVIPO.getIntroduction()+"'"+","
				+promotionsVIPO.getViplevel()+","+promotionsVIPO.getDiscount()+")";
		 statement=connection.prepareStatement(sql);
			int row=statement.executeUpdate();
			if(row==1)
			result=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result;
	
	
}
	public boolean deletePromotions(int type,String hotel,String introduction){
		boolean result=false;
		int table[]={1,2,3,4,5,6};
		String promotions[]={"strategiesi","strategiesii","strategiesiii","strategiesiv","strategiesv"
				,"strategiesvi"}; 
		try {
			this.getConnect();
			for(int i=0;i<table.length;i++){
				if(type==table[i]){
					String deleteSql="delete from "+promotions[i]+" where hotel="+"'"+hotel+"'"+
							",and introduction="+"'"+introduction+"'";
			        statement=connection.prepareStatement(deleteSql);
					statement.executeUpdate();
					result=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.freeConnect();
		}
		return result;
	}
	
	private boolean isExist(PromotionsPO promotionsPO){
		boolean result=false;
		int table[]={1,2,3,4,5,6};
		String promotions[]={"strategiesi","strategiesii","strategiesiii","strategiesiv","strategiesv"
				,"strategiesvi"}; 
		try {
			this.getConnect();
			for(int i=0;i<table.length;i++){
				if(promotionsPO.getType()==table[i]){
					String findSql="select * from "+promotions[i]+" where hotel"+"'"+promotionsPO.getHotel()+"'"+
							",and introduction="+"'"+promotionsPO.getIntroduction()+"'";
					statement=connection.prepareStatement(findSql);
					int row=statement.executeUpdate();
					if(row==0){
						result=false;
					}else{
						result=true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.freeConnect();
		}
		return result;
	}
}
