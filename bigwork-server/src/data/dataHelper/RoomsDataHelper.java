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
	 * 
	 * @param roomID
	 * @param StartTime
	 * @param EndTime
	 * @return 录入房间预定时间
	 */
	boolean recordReservation(int roomID, Date StartTime, Date EndTime,int orderId);

	/**
	 * 
	 * @param roomID
	 * @param StartTime
	 * @return 删除房间预定时间
	 */
	boolean recordCheckOut(int roomID, int orderId);
	/**
	 * @param orderId
	 * @param roomIdList
	 * @return 添加订单号对应的房间
	 */
	boolean recordOrderRoom(int orderId, ArrayList<Integer> roomIdList);
	/**
	 * 
	 * @param orderId
	 * @return 返回订单号对应的房间
	 */
	ArrayList<Integer> getOrderRoom(int orderId);
	/**
	 * 
	 * @param roomID
	 * @param orderId
	 * @param StartTime
	 * @return
	 */
	boolean recordCheckIn(int roomID, int orderId, Date StartTime);
	

}
