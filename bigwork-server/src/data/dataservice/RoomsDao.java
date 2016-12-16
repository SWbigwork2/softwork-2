package data.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

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
	 * @return 删除房间
	 */
	public boolean deleteRoom(String roomID) throws RemoteException;
	
	/**
	 * @param roomPO
	 * @return 更新房间
	 */
	
	public boolean updateRoom(RoomPO roomPO) throws RemoteException;
	
	/**
	 * @param roomID
	 * @param StartTime
	 * @param EndTime
	 * @return 记录一个房间不可用时段
	 */
	public boolean recordStartTime(String roomID, Date StartTime, Date EndTime) throws RemoteException;
	/**
	 * @param roomID
	 * @param StartTime
	 * @return 退房删除一个房间不可用时段
	 */
	public boolean recordCheckOut(String roomID, Date StartTime) throws RemoteException;

}
