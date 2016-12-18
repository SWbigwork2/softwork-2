package data.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.impl.OrdersDaoImpl;
import po.OrderPO;

public interface OrdersDao extends Remote{

	public OrderPO getOrder(int orderId) throws RemoteException; //得到订单信息
	
	public ArrayList<OrderPO> getHotelOrderList(String hotelName) throws RemoteException; // 得到酒店的订单列表

	public ArrayList<OrderPO> getOrderList(String userId) throws RemoteException; //得到用户的订单列表
	

	
	public boolean insert(OrderPO po) throws RemoteException; //在指定的用户下插入订单信息
	
	public boolean updata(OrderPO po) throws RemoteException;  //更新指定订单信息
	
	public boolean delete(int orderId) throws RemoteException;  //删除指定订单信息
	
	/**
	 * @return 得到所有订单信息
	 */
	public ArrayList<OrderPO> getAllOrderList() throws RemoteException;
	
	

}
