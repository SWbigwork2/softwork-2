package data.dao;

import java.util.ArrayList;
import java.util.Date;

import po.RoomPO;

public interface RoomsDao {
	
	/**
	 * @param hotelName
	 * @return 某一酒店的房间列表
	 */
	public ArrayList<RoomPO> getRoomList(String hotelName);
	
	/**
	 * @param roomPO
	 * @return 添加房间
	 */
	
	public boolean insertRoom(RoomPO roomPO);
	
	/**
	 * @param roomID
	 * @return 删除房间
	 */
	public boolean deleteRoom(String roomID);
	
	/**
	 * @param roomPO
	 * @return 更新房间
	 */
	
	public boolean updateRoom(RoomPO roomPO);
	
	/**
	 * @param roomID
	 * @param StartTime
	 * @param EndTime
	 * @return 记录一个房间不可用时段
	 */
	public boolean recordStartTime(String roomID, Date StartTime, Date EndTime);
	/**
	 * @param roomID
	 * @param StartTime
	 * @return 退房删除一个房间不可用时段
	 */
	public boolean recordCheckOut(String roomID);

}
