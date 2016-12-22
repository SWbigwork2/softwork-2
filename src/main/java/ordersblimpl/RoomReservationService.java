package ordersblimpl;

import java.util.Date;

import Roomblimpl.RoomType;

public interface RoomReservationService {
	public void makeReservation(int orderId,String hotelName,RoomType roomType,Date startTime,Date endTime,int roomNum);
	public void revokeReservatio(int orderId);
}
