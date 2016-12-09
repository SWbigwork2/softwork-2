package data.dataHelper;

import java.util.Date;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomsDataHelper {

	/**
	 * @param hotelName
	 * @return 某一酒店的房间列表
	 */
	ArrayList<RoomPO> getRoomList(String hotelName);

	/**
	 * @param roomPO
	 * @return 添加房间
	 */
	boolean insertRoom(RoomPO roomPO);

	/**
	 * @param roomID
	 * @return 删除房间
	 */
	
	boolean deleteRoom(String roomID);
	/**
	 * @param roomPO
	 * @return 更新房间信息
	 */
	
	boolean updateRoom(RoomPO roomPO);
    
	/**
	 * 
	 * @param roomID
	 * @param StartTime
	 * @param EndTime
	 * @return 录入房间预定时间
	 */
	boolean recordStartTime(String roomID, Date StartTime, Date EndTime);

	/**
	 * 
	 * @param roomID
	 * @return 将房间置为可预定状态
	 */
	boolean recordCheckOut(String roomID);

}
