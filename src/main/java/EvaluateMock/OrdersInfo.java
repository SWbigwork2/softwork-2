package EvaluateMock;

import java.util.Date;

import OrdersMock.OrderType;
import RoomsMock.RoomType;
import po.OrderPO;

public class OrdersInfo extends OrderPO{

	public OrdersInfo(int orderId, String userId, String userNameString, String hotelNameString, RoomType roomType,
			int roomNum, double price, OrderType orderType, Date inDate, Date outDate, Date completeDate,
			 Date deadLine,int peopleNum, Date beginDate) {
		super(orderId, userId, hotelNameString, roomType, roomNum, price, orderType, inDate, outDate,
				completeDate,  deadLine,peopleNum,beginDate);
		// TODO Auto-generated constructor stub
	}

}
