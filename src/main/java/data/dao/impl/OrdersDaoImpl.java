package data.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import RoomsMock.RoomType;
import data.dao.OrdersDao;
import data.dataHelper.DataFactory;
import data.dataHelper.OrdersDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import data.dataHelper.impl.OrdersDataSqlHelper;
import po.OrderPO;

public class OrdersDaoImpl implements OrdersDao{
	private static OrdersDaoImpl ordersDaoImpl;
	private OrdersDataHelper ordersDataHelper;
	private DataFactory dataFactory;
	
	public OrdersDaoImpl() {
		dataFactory = new DataFactoryImpl();
		ordersDataHelper = dataFactory.getOrdersDataHelper();
		// TODO Auto-generated constructor stub
	}
	
	public static OrdersDaoImpl getInstance(){
		if(ordersDaoImpl ==null){
			ordersDaoImpl = new OrdersDaoImpl();
			return ordersDaoImpl;
		}
		else{
			return ordersDaoImpl;
		}
	}
	public OrderPO getOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getHotelOrderList(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getOrderList(String userId) {
		
		try {
			ArrayList resultList = ordersDataHelper.getOrdersList();
			Iterator iterator = resultList.iterator();
			while(iterator.hasNext()){
				
				Map hm = (Map)iterator.next();
				String userIdtemp= (String) hm.get("userid");
				
				int orderId = (Integer) hm.get("orderid");
				System.out.println(orderId);
				String hotel = (String) hm.get("hotel");
				RoomType type = (RoomType) hm.get("roomtype");
				int roomNum = (Integer) hm.get("roomnumber");
				int peopleNum = (Integer)hm.get("peoplenumber");
				double price = (Double) hm.get("price");
				Date beginDate = (Date) hm.get("begindate");
				Date completeDate = (Date) hm.get("completedate");
				Date inDate = (Date)hm.get("indate");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(OrderPO po, int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updata(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
