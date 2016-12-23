package ordersblimpl;

import java.util.Date;

import Roomblimpl.RoomType;

/**
 * @author 朱润之
 * 从roomservice中抽离的接口，用于添加入住信息以及离店信息
 *
 */
public interface RoomReservationService {
	public void makeReservation(int orderId,String hotelName,RoomType roomType,Date startTime,Date endTime,int roomNum);
	public void revokeReservatio(int orderId);
}
