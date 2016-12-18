package data.dao;

import java.util.Date;
import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.RoomPO;

public interface RoomsDao extends Remote{
	
	/**
	 * @param hotelName
	 * @return 某一酒店的房间列表
	 */
	public ArrayList<RoomPO> getRoomList(String hotelName) throws RemoteException;
	
	/**
	 * @param roomPO
	 * @return 添加房间
	 */
	
	public boolean insertRoom(RoomPO roomPO) throws RemoteException;
	
	
	/**
	 * @param roomID
	 * @param StartTime
	 * @param EndTime
	 * @return 记录预定房间
	 */
	public boolean recordReservation(int roomID, Date StartTime,Date EndTime, int orderId) throws RemoteException;
	/**
	 * @param roomID
	 * @param StartTime
	 * @return 退房删除一个房间不可用时段
	 */
	public boolean recordCheckOut(int roomID, int orderId) throws RemoteException;
	/**
	 * @param orderId
	 * @return 得到一个orderId预定的房间
	 */
	
	public ArrayList<Integer> getOrderRoom(int orderId) throws RemoteException;
	/**
	 * 
	 * @param orderId
	 * @param roomIdList
	 * @return 记录一个orderId和预定的房间
	 */
	public boolean recordOrderRoom(int orderId, ArrayList<Integer> roomIdList) throws RemoteException;
	/**
	 * 
	 * @param roomID
	 * @param orderId
	 * @param StartTime
	 * @return
	 */
	public boolean recordCheckIn(int roomID, int orderId, Date StartTime) throws RemoteException;
}
