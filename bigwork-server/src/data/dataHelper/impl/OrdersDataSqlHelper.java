package data.dataHelper.impl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import data.dataHelper.OrdersDataHelper;
import javafx.print.PageOrientation;
import po.OrderPO;

public class OrdersDataSqlHelper implements OrdersDataHelper{
	public static void main(String[] args) {
		OrdersDataSqlHelper odsq = new OrdersDataSqlHelper();
		try {
			odsq.getOrdersList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Connection connection=null;
	
	PreparedStatement statement = null;
	
	ResultSet resultSet = null;
	private static ArrayList resultSetToList(ResultSet rs) throws java.sql.SQLException {   //resultset转list，每个订单的数据存在一个map中
        if (rs == null)   
            return null;  
        ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等   
        int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数   
        ArrayList list = new ArrayList();   
        Map rowData = new HashMap();   
        while (rs.next()) {   
         rowData = new HashMap(columnCount);   
         for (int i = 1; i <= columnCount; i++) {   
                 rowData.put(md.getColumnName(i), rs.getObject(i));   
         }   
         list.add(rowData);   
         System.out.println("list:" + list.toString());   
        }   
        return list;   
}  


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

	public ArrayList getOrdersList() throws SQLException{
		ArrayList tempList = new ArrayList();
		try{
		getConnect();
		String getListSql = "select * from orders";
		statement = connection.prepareStatement(getListSql);
		resultSet = statement.executeQuery();
		tempList=resultSetToList(resultSet); //得到结果的列表，转成array
		// TODO Auto-generated method stub
		
		}
		finally {
			freeConnect();
		}
		return tempList;
	}

	public boolean insertOrder(OrderPO po) {
		
		getConnect();	
		
		String orderid =+ po.getOrderId()+"";
		String roomnumber = po.getRoomNum()+"";
		String userid = po.getUserId();
		String peoplenumber = po.getPeopleNum()+"";
		String hotel = po.getHotelNameString();
		String roomtype = po.getRoomType().toString();
		String type = po.getOrderType().toString();
		String price = po.getPrice()+"";
		
		String preCommand = "INSERT INTO orders ";
		
		String dataField = "(orderid,userid,hotel,type,price,roomnumber,roomtype,peoplenumber,begindate,completedate,deadline,indate,outdate) " ;
		
		String values = "VALUES "+"("+orderid+","+"'"+userid+"'"+","+"'"+hotel+"'"+","+"'"+type+"'"+","+price+","+roomnumber+","
		+"'"+roomtype+"'"+","+peoplenumber+",?,?,?,?,?"+")"+";";
		String SQL = preCommand+dataField+values;
		System.out.println(SQL);
		try {
			statement = connection.prepareStatement(SQL);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			freeConnect();
			return false;// TODO: handle exception
		}
	
		
		
		Timestamp beginTs = new Timestamp(po.getBeginDate().getTime());
		Timestamp completeTs = null;
		if(po.getCompleteDate()!=null){
		completeTs = new Timestamp(po.getCompleteDate().getTime());
		}
		Timestamp inTs =new Timestamp(po.getInDate().getTime());
		Timestamp outTs = new Timestamp(po.getOutDate().getTime());
		Timestamp deadline = new Timestamp(po.getDeadLine().getTime());
		try {
			statement.setTimestamp(1, beginTs);
			statement.setTimestamp(2, completeTs);
			statement.setTimestamp(3, deadline);
			statement.setTimestamp(4, inTs);
			statement.setTimestamp(5, outTs);
			statement.executeUpdate();
			freeConnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			freeConnect();
			return false;// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		
	}

	public boolean updataOrder(OrderPO po) {   //更新订单信息
		int deleteId = po.getOrderId();
		
		if(!deleteOrder(deleteId)){
			return false;
		}
		if(!insertOrder(po)){
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean deleteOrder(int orderId) {     //根据id删除订单
		try {
			getConnect();
			String preCommand = "delete from orders";
			String mainCommand = " where orderid = "+orderId+";";
			System.out.println(mainCommand);
			statement = connection.prepareStatement(preCommand+mainCommand);
			int i=statement.executeUpdate();
			if(i<1){
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
			
			// TODO: handle exception
		} 
		finally {
			freeConnect();
		
		}
		// TODO Auto-generated method stub
		return true;
	}

}
