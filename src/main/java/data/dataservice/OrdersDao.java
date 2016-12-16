package data.dataservice;

import java.util.ArrayList;

import data.dao.impl.OrdersDaoImpl;
import po.OrderPO;

public interface OrdersDao {

	public OrderPO getOrder(int orderId); //得到订单信息
	
	public ArrayList<OrderPO> getHotelOrderList(String hotelName); // 得到酒店的订单列表

	public ArrayList<OrderPO> getOrderList(String userId); //得到用户的订单列表
	
	public boolean insert(OrderPO po); //在指定的用户下插入订单信息
	
	public boolean updata(OrderPO po);  //更新指定订单信息
	
	public boolean delete(int orderId);  //删除指定订单信息
	
	/**
	 * @return 得到所有订单信息
	 */
	public ArrayList<OrderPO> getAllOrderList();
	
	

}
