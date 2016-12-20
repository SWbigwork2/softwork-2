package blservice;

import java.util.Date;
import java.util.ArrayList;
import java.util.Map;

import Roomblimpl.RoomType;
import view.member.RoomVo;

public interface RoomService {
	/**
	 * 
	 * @param roomList
	 */
	public void addNewRoom(ArrayList<RoomVo> roomList);
	/**
	 * 
	 * @param hotelName
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public ArrayList<RoomVo> getRoomOfHotel(String hotelName,Date startTime,Date endTime);
	/**
	 * 
	 * @param hotelName
	 * @param roomType
	 * @param startTime
	 * @param endTime
	 * @param roomNum
	 * 根据酒店名 房间类型 入住时间 退房时间 房间数量来记录入住
	 */
	public void makeReservation(int orderId,String hotelName,RoomType roomType,Date startTime,Date endTime,int roomNum);
	/**
	 * 
	 * @param hotelName
	 * @param roomId
	 * @param endTime
	 */
	public void makeCheckOut(int orderId, int roomId, Date endTime);
	/**
	 * 
	 * @param hotelName
	 * @param startTime
	 * @param endTime
	 * @return 返回最高价的房间价格
	 */
	public double getHighestPrice(String hotelName,Date startTime,Date endTime);
	/**
	 * 
	 * @param hotelName
	 * @param startTime
	 * @param endTime
	 * @return 返回最低价的房间价格
	 */
	public double getLowestPrice(String hotelName, Date startTime,Date endTime);
	/**
	 * 
	 * @param hotelName
	 * @param startTime
	 * @param endTime 
	 * @return 返回房间总数
	 */
	public int numberOfAllRooms(String hotelName, Date startTime,Date endTime);
	
	/**
	 * 
	 * @param hotelName
	 * @param startTime
	 * @param endTime
	 * @return 返回房间类型列表
	 */
	public ArrayList<RoomType> getHotelRoomType(String hotelName, Date startTime,Date endTime);
	/**
	 * 
	 * @param hotelName
	 * @return 得到酒店名称和时间得到对应房间的数目
	 */
	public Map<RoomType, Integer> getNumOfRoom(String hotelName,Date startTime,Date endTime);
	/**
	 * 
	 * @param hotelName
	 * @return 得到酒店对应房间的价格
	 */
	public Map<RoomType, Double> getPriceOfRoom(String hotelName,Date startTime,Date endTime);
	/**
	 * 
	 * @param orderId
	 * @param startTime
	 */
	public void makeCheckIn(int orderId, Date startTime);
	/**
	 * 
	 */
	public void revokeReservatio(int orderId);
	
	
}