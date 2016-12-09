package ordersblimpl;

import java.sql.Timestamp;
import Roomblimpl.*;
import po.RoomPO;

public class RoomInfo extends RoomPO{

	public RoomInfo(String roomName, String hotelBelongTo, RoomType roomType,String introduction,double price,Timestamp startTime,Timestamp endTime) {
		super(roomName,hotelBelongTo,roomType,introduction,price,startTime,endTime);
		// TODO Auto-generated constructor stub
	}
	
}
