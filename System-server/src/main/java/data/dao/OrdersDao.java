package data.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.impl.OrdersDaoImpl;
import po.OrderPO;

/**
 * @author 朱润之
 * order模块的数据层接口
 */
public interface OrdersDao extends Remote{

	/**
	 * @param orderId
	 * @return 得到订单
	 * @throws RemoteException
	 */
	public OrderPO getOrder(int orderId) throws RemoteException; 
	
	/**
	 * @param hotelName
	 * @return 得到酒店的订单列表
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> getHotelOrderList(String hotelName) throws RemoteException; 

	/**
	 * @param userId
	 * @return 得到用户的订单列表
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> getOrderList(String userId) throws RemoteException; 
	

	
	/**
	 * @param po
	 * @return 在指定的用户下插入订单信息
	 * @throws RemoteException
	 */
	public boolean insert(OrderPO po) throws RemoteException;
	
	/**
	 * @param po
	 * @return 更新指定订单信息
	 * @throws RemoteException
	 */
	public boolean updata(OrderPO po) throws RemoteException;  
	
	/**
	 * @param orderId
	 * @return 删除指定订单信息
	 * @throws RemoteException
	 */
	public boolean delete(int orderId) throws RemoteException;  
	
	/**
	 * @return 得到所有订单信息
	 */
	public ArrayList<OrderPO> getAllOrderList() throws RemoteException;
	
	

}
