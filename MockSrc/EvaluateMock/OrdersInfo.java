package EvaluateMock;

import java.util.Date;

import OrdersMock.OrderPO;
import OrdersMock.OrderType;
import RoomsMock.RoomType;

public class OrdersInfo extends OrderPO{

	public OrdersInfo(int orderId, int userId, String userNameString, String hotelNameString, RoomType roomType,
			int roomNum, double price, OrderType orderType, Date inDate, Date outDate, Date completeDate,
			Date revokeDate, Date deadLine) {
		super(orderId, userId, userNameString, hotelNameString, roomType, roomNum, price, orderType, inDate, outDate,
				completeDate, revokeDate, deadLine);
		// TODO Auto-generated constructor stub
	}

}
