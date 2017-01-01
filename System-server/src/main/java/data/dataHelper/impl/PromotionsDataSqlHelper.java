package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		String password = "zhurunzhi654";
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
	
	/**
	 * @param promotionsIPO
	 * @return 制定策略一生日特惠
	 */
public boolean addPromotionsI(PromotionsIPO promotionsIPO){
        
		boolean result=false;
		try {
			if(!isExist(promotionsIPO) ){
				getConnect();
			    String sql="insert into strategiesi values("+promotionsIPO.getType()+","+"'"+promotionsIPO.getHotel()+"'"
					+","+"'"+promotionsIPO.getIntroduction()+"'"+","+promotionsIPO.getDiscount()+")";
			    statement=connection.prepareStatement(sql);
			 
				int row=statement.executeUpdate();
				if(row==1)
				result=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();			
		}finally {
			freeConnect();
		}
		return result;
		
		
	}

/**
 * @param promotionsIIPO
 * @return 制定策略二节日特惠
 */
	public  boolean addPromotionsII(PromotionsIIPO promotionsIIPO){//date时间转换？？？
		boolean result=false;
		
		
		try {
			
			if(!isExist(promotionsIIPO) ){
				getConnect();
			String sql="insert into strategiesii values("+promotionsIIPO.getType()+","+"'"+promotionsIIPO.getHotel()+"'"
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
			e.printStackTrace();
		}finally {
			freeConnect();
		}
		return result;
		
	}

	/**
	 * @param promotionsIIIPO
	 * @return 制定策略三多间特惠
	 */
public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO){
		

		boolean result=false;
		try {
		
			if(!isExist(promotionsIIIPO) ){
				getConnect();
			String sql="insert into strategiesiii values("+promotionsIIIPO.getType()+","+"'"+promotionsIIIPO.getHotel()+"'"
					+","+"'"+promotionsIIIPO.getIntroduction()+"'"+","
					+promotionsIIIPO.getNum()+","+promotionsIIIPO.getDiscount()+")";
			    statement=connection.prepareStatement(sql);
				int row=statement.executeUpdate();
				if(row==1)
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			freeConnect();
		}
		return result;
		
		
	}

/**
 * @param promotionsIVPO
 * @return 制定策略四合作企业特惠
 */
public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO){
	

	boolean result=false;
	try {
		
		if(!isExist(promotionsIVPO) ){
			getConnect();
		String sql="insert into strategiesiv values("+promotionsIVPO.getType()+","+"'"+promotionsIVPO.getHotel()+"'"
				+","+"'"+promotionsIVPO.getIntroduction()+"'"
				+","+promotionsIVPO.getDiscount()
				+","+"'"+promotionsIVPO.getcompanyname()+"'"+")";
		 statement=connection.prepareStatement(sql);
			int row=statement.executeUpdate();
			if(row==1)
			result=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		freeConnect();
	}
	return result;
	
	
}

/**
 * @param promotionsVPO
 * @return 制定策略五商圈特惠
 */
public boolean addPromotionsV(PromotionsVPO promotionsVPO){
	

	boolean result=false;
	try {
		
		if(!isExist(promotionsVPO) ){
			getConnect();
		String sql="insert into strategiesv values("+promotionsVPO.getType()+","+"'"+promotionsVPO.getHotel()+"'"
				+","+"'"+promotionsVPO.getIntroduction()+"'"+","
				+promotionsVPO.getViplevel()+","+"'"+promotionsVPO.getArea()+"'"+","+promotionsVPO.getDiscount()+")";
		 statement=connection.prepareStatement(sql);
			int row=statement.executeUpdate();
			if(row==1)
			result=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		freeConnect();
	}
	return result;
	
	
}

/**
 * @param promotionsVIPO
 * @return 制定策略六等级特惠
 */
public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO){
	

	boolean result=false;
	try {
		
		if(!isExist(promotionsVIPO) ){
			getConnect();
		String sql="insert into strategiesvi values("+promotionsVIPO.getType()+","+"'"+promotionsVIPO.getHotel()+"'"
				+","+"'"+promotionsVIPO.getIntroduction()+"'"+","
				+promotionsVIPO.getViplevel()+","+promotionsVIPO.getDiscount()+")";
		 statement=connection.prepareStatement(sql);
			int row=statement.executeUpdate();
			if(row==1)
			result=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		freeConnect();
	}
	return result;
	
	
}

/**
 * @param promotionsPO
 * @return 删除策略
 */
public boolean deletePromotions(PromotionsPO promotionsPO){
	boolean result=false;
	int table[]={1,2,3,4,5,6};
	int type=promotionsPO.getType();
	String hotel=promotionsPO.getHotel();
	String introduction=promotionsPO.getIntroduction();
	String promotions[]={"strategiesi","strategiesii","strategiesiii","strategiesiv","strategiesv"
			,"strategiesvi"}; 
	try {
		for(int i=0;i<table.length;i++){
			if(type==table[i]){
				this.getConnect();
				String deleteSql="delete from "+promotions[i]+" where type="+type+" and hotel="+"'"+hotel+"'"+
						" and introduction="+"'"+introduction+"'";
		        statement=connection.prepareStatement(deleteSql);
				int row=statement.executeUpdate();
				if(row==1){
				    result=true;
				}
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

/**
 * @param promotionsPO
 * @return 判断策略是否存在
 */
private boolean isExist(PromotionsPO promotionsPO){
	boolean result=false;
	int table[]={1,2,3,4,5,6};
	String promotions[]={"strategiesi","strategiesii","strategiesiii","strategiesiv","strategiesv"
			,"strategiesvi"}; 
	try {
		this.getConnect();
		for(int i=0;i<table.length;i++){
			if(promotionsPO.getType()==table[i]){
				String findSql="select * from "+promotions[i]+" where type="+promotionsPO.getType()+" and hotel="+"'"+promotionsPO.getHotel()+"'"+
						" and introduction="+"'"+promotionsPO.getIntroduction()+"'";
				statement=connection.prepareStatement(findSql);
				resultSet=statement.executeQuery();
				
			    if(resultSet.next()){
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

/**
 * @param hotel
 * @return 得到酒店策略列表
 */
public ArrayList<PromotionsPO> getHotelPromotions(String hotel) {
	// TODO Auto-generated method stub
	 ArrayList<PromotionsPO> list=new ArrayList<PromotionsPO>();
	
	try {
		this.getConnect();
		   
			String findhotelpromotionssql1="select * from strategiesi where hotel="+"'"+hotel+"'";
			PreparedStatement statement1=connection.prepareStatement(findhotelpromotionssql1);
			ResultSet resultSet1=statement1.executeQuery();
			if(resultSet1==null){
				
			}else{
				while(resultSet1.next()){
					int type=resultSet1.getInt(1);
					String hotelname=resultSet1.getString(2);
					String introduction=resultSet1.getString(3);
					double discount=resultSet1.getDouble(4);
					PromotionsIPO promotionsIPO=new PromotionsIPO(type, hotelname, introduction, discount);
					list.add(promotionsIPO);
				}			
			}
			String findhotelpromotionssql2="select * from strategiesii where hotel="+"'"+hotel+"'";
			PreparedStatement statement2=connection.prepareStatement(findhotelpromotionssql2);
			ResultSet resultSet2=statement2.executeQuery();
			if(resultSet2==null){
				
			}else{
				while(resultSet2.next()){
					int type=resultSet2.getInt(1);
					String hotelname=resultSet2.getString(2);
					String introduction=resultSet2.getString(3);
					String startdate =resultSet2.getString(4);
					String enddate =resultSet2.getString(5);
					double discount=resultSet2.getDouble(6);
					PromotionsIIPO promotionsIIPO=new PromotionsIIPO(type, hotelname, introduction, startdate, enddate, discount);
					list.add(promotionsIIPO);
				}
				String findhotelpromotionssql3="select * from strategiesiii where hotel="+"'"+hotel+"'";
				PreparedStatement statement3=connection.prepareStatement(findhotelpromotionssql3);
				ResultSet resultSet3=statement3.executeQuery();
				if(resultSet3==null){
					
				}else{
					while(resultSet3.next()){
						int type=resultSet3.getInt(1);
						String hotelname=resultSet3.getString(2);
						String introduction =resultSet3.getString(3);
						int num=resultSet3.getInt(4);
						double discount=resultSet3.getDouble(5);
						PromotionsIIIPO promotionsIIIPO=new PromotionsIIIPO(type, hotelname, introduction, num, discount);
						list.add(promotionsIIIPO);
						
					}
				}
				String findhotelpromotionssql4="select * from strategiesiv where hotel="+"'"+hotel+"'";
				PreparedStatement statement4=connection.prepareStatement(findhotelpromotionssql4);
				ResultSet resultSet4=statement4.executeQuery();
				if(resultSet4==null){
					
				}else{
					while(resultSet4.next()){
						int type=resultSet4.getInt(1);
						String hotelname=resultSet4.getString(2);
						String introduction =resultSet4.getString(3);
						String companyname=resultSet4.getString(5);
						double discount=resultSet4.getDouble(4);
						PromotionsIVPO promotionsIVPO=new PromotionsIVPO(type, hotelname, introduction, companyname, discount);
						list.add(promotionsIVPO);
					}
				}
				String findhotelpromotionssql5="select * from strategiesv where hotel="+"'"+hotel+"'";
				PreparedStatement statement5=connection.prepareStatement(findhotelpromotionssql5);
				ResultSet resultSet5=statement5.executeQuery();
				if(resultSet5==null){
					
				}else{
					while(resultSet5.next()){
						int type=resultSet5.getInt(1);
						String hotelname=resultSet5.getString(2);
						String introduction =resultSet5.getString(3);
						int  viplevel=resultSet5.getInt(4);
						String area=resultSet5.getString(5);
						double discount=resultSet5.getDouble(6);
						PromotionsVPO promotionsVPO=new PromotionsVPO(type, hotelname, introduction, viplevel, area, discount);
						list.add(promotionsVPO);
					}
				}
				String findhotelpromotionssql6="select * from strategiesvi where hotel="+"'"+hotel+"'";
				PreparedStatement statement6=connection.prepareStatement(findhotelpromotionssql6);
				ResultSet resultSet6=statement6.executeQuery();
				if(resultSet6==null){
					
				}else{
					while(resultSet6.next()){
						int type=resultSet6.getInt(1);
						String hotelname=resultSet6.getString(2);
						String introduction =resultSet6.getString(3);
						int  viplevel=resultSet6.getInt(4);
						double discount=resultSet6.getDouble(5);
						PromotionsVIPO promotionsVIPO=new PromotionsVIPO(type, hotelname, introduction, viplevel, discount);
						list.add(promotionsVIPO);
					}
				}
				
			}
			
			
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		this.freeConnect();
	}
	
	return list;
}

}
