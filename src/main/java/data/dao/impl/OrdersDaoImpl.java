package data.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import OrdersMock.OrderType;
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
	public static void main(String[] args) {
		OrdersDaoImpl ordersDaoImpl = new OrdersDaoImpl();
		ordersDaoImpl.getOrderList("admin");
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
		ArrayList<OrderPO> resultPos = new ArrayList<OrderPO>();  //存储结果po列表
		try {
			ArrayList resultList = ordersDataHelper.getOrdersList();
			Iterator iterator = resultList.iterator();
			while(iterator.hasNext()){
				
				Map hm = (Map)iterator.next();
				String userIdtemp= (String) hm.get("userid");    //判断用户名是否一致
				if(!userIdtemp.equals(userId)){
					continue;
				}
				OrderPO po = Map2Po(hm);            //将map转换成po
				resultPos.add(po);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return resultPos;
	}

	public boolean insert(OrderPO po) {
		if(po==null){
			return false;
		}
		else{
			return ordersDataHelper.insertOrder(po);
		}
		
		// TODO Auto-generated method stub
		
	}

	public boolean updata(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}
	private OrderPO Map2Po(Map map) {    //将map里的数据转换成po
		Map hm = map;
		String userIdtemp= (String) hm.get("userid");
		
		System.out.println(userIdtemp);
		int orderId = (Integer) hm.get("orderid");
		System.out.println(orderId);
		String hotel = (String) hm.get("hotel");
		OrderType type = Enum.valueOf(OrderType.class, (String)hm.get("type"));
		RoomType roomType = Enum.valueOf(RoomType.class, (String)hm.get("roomtype"));
		int roomNum = (Integer) hm.get("roomnumber");
		int peopleNum = (Integer)hm.get("peoplenumber");
		double price = Double.valueOf((Float)hm.get("price"));
		Date beginDate = (Date) hm.get("begindate");
		
		Date completeDate = (Date) hm.get("completedate");
		Date inDate = (Date)hm.get("indate");
		Date outDate = (Date)hm.get("outdate");
		Date deadLine = (Date)hm.get("deadline");
	
		OrderPO po =new OrderPO(orderId, userIdtemp, hotel, roomType, roomNum, price, type, inDate, outDate, completeDate, deadLine, peopleNum, beginDate);
		return po;
		
	}

}
