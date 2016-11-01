package OrdersMock;

import java.util.Date;

import RoomsMock.RoomType;

public class OrderVO {
	
	public String userNameString;
	public String hotelNameString;
	RoomType roomType;
	int roomNum;
	public double price;
	OrderType orderType;
	Date inDate;
	Date outDate;
	Date completeDate;
	Date revokeDate;
	Date deadLine;
	public OrderVO(OrderItem item) {
		this.userNameString = item.getName();
		this.hotelNameString = item.getHotel();
		this.roomType = item.getType();
		this.roomNum = item.roomNum;
		this.price = item.calPrice();
		this.orderType = item.orderType;
		this.inDate = item.inDate;
		this.outDate = item.outDate;
		this.completeDate = item.completeDate;
		this.revokeDate = item.revokeDate;
		this.deadLine = item.deadLine;
	}
	

}
