package OrderStub;

import java.util.Date;

public class OrderVO {
	String userNameString;
	String hotelNameString;
	RoomType roomType;
	int roomNum;
	double price;
	OrderType orderType;
	Date inDate;
	Date outDate;
	Date completeDate;
	Date revokeDate;
	Date deadLine;
	public OrderVO(String userNameString, String hotelNameString, RoomType roomType, int roomNum, double price,
			OrderType orderType, Date inDate, Date outDate, Date completeDate, Date revokeDate, Date deadLine) {
		this.userNameString = userNameString;
		this.hotelNameString = hotelNameString;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.price = price;
		this.orderType = orderType;
		this.inDate = inDate;
		this.outDate = outDate;
		this.completeDate = completeDate;
		this.revokeDate = revokeDate;
		this.deadLine = deadLine;
	}
	

}
