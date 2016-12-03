package data.dao.impl;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import RoomsMock.RoomType;
import data.dao.OrdersDao;
import data.dataHelper.DataFactory;
import data.dataHelper.OrdersDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import data.dataHelper.impl.OrdersDataSqlHelper;
import ordersblimpl.OrderType;
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
	public OrderPO getOrder(int orderId) {   //根据id查找单个订单的实现
		ArrayList<OrderPO> resultList = getAllOrderList();
		for(OrderPO po:resultList){
			if(po.getOrderId()==orderId){
				return po;
			}
		}
		
		return null;
	}

	public ArrayList<OrderPO> getHotelOrderList(String hotelName) {  //根据酒店名查找所有订单的实现
		ArrayList<OrderPO> resultList = getAllOrderList();
		ArrayList<OrderPO> hotelList = new ArrayList<OrderPO>();
		for(OrderPO po:resultList){
			if(po.getHotelNameString().equals(hotelName)){
				hotelList.add(po);
			}
		}
		
		
		return hotelList;
	}

	public ArrayList<OrderPO> getOrderList(String userId) {    //得到指定用户的所有订单的方法实现
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

	public boolean updata(OrderPO po) {
		// TODO Auto-generated method stub
		return ordersDataHelper.updataOrder(po);
	}

	public boolean delete(int orderId) {    //删除指定的订单
		System.out.println("delete");
		// TODO Auto-generated method stub
		return ordersDataHelper.deleteOrder(orderId);
	}
	private ArrayList<OrderPO> getAllOrderList(){ //私有方法，得到所有的Order信息
		ArrayList<OrderPO> resultPos = new ArrayList<OrderPO>();  //存储结果po列表
		try {
			ArrayList resultList = ordersDataHelper.getOrdersList();
			Iterator iterator = resultList.iterator();
			while(iterator.hasNext()){
				
				Map hm = (Map)iterator.next();
				String userIdtemp= (String) hm.get("userid");    //判断用户名是否一致
				
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
		
		Date beginDate =  new Date(((Timestamp)(hm.get("begindate"))).getTime());
		Date completeDate = new Date(((Timestamp)(hm.get("completedate"))).getTime());
		Date inDate =new Date(((Timestamp)(hm.get("indate"))).getTime());
		Date outDate = new Date(((Timestamp)(hm.get("outdate"))).getTime());
		Date deadLine = new Date(((Timestamp)(hm.get("deadline"))).getTime());
		int temp =(Integer)hm.get("hasChild");
		boolean hasChild = true;
		if(temp==0){
			hasChild = false;
		}
		String name = (String)hm.get("name");
		OrderPO po =new OrderPO(orderId, userIdtemp,name, hotel, roomType, roomNum, price, type, inDate, outDate, completeDate, deadLine, peopleNum, beginDate, hasChild);
		return po;
		
	}

}
