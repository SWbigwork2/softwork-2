package data.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelPO;
import po.RoomPO;

public interface HotelsDao extends Remote{
	/**
	 * @param HotelPO
	 * @return 获取符合条件的酒店列表
	 */
	public ArrayList<HotelPO> getHotelList(HotelPO hotelPO) throws RemoteException;
	
	/**
	 * @param HotelPO
	 * @return 获取符合条件的一家酒店的细节信息
	 */
	public HotelPO getHotelDetails(String hotelName) throws RemoteException;
	
	/**
	 * @param HotelPO
	 * @return 添加酒店
	 */
	
	public boolean insertHotel(HotelPO hotelPO) throws RemoteException;
	
	/**
	 * @param HotelPO
	 * @return 删除酒店
	 */
	public boolean deleteHotel(String hotelName) throws RemoteException;
	
	/**
	 * @param HotelPO 
	 * @return 维护已有酒店信息
	 */
	public boolean updateHotel(HotelPO hotelPO) throws RemoteException;
	
	/**
	 * @param hotelName
	 * @return 返回该酒店的房间列表
	 */
	public ArrayList<RoomPO> getRoomOfHotel(String hotelName) throws RemoteException;
	
	/**
	 * @param hotelName
	 * @return 判断酒店是否存在
	 */
	public boolean judgeHotelExists(String hotelName) throws RemoteException;

	
}