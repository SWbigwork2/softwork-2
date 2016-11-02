package OrdersMock;

import java.io.Serializable;
import java.util.Date;

import RoomsMock.RoomType;




public class OrderPO implements Serializable{
	int orderId;
	int userId;
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
	public OrderPO(int orderId, int userId, String userNameString,
			String hotelNameString, RoomType roomType, int roomNum,
			double price, OrderType orderType, Date inDate, Date outDate,
			Date completeDate, Date revokeDate, Date deadLine) {
		super();
		this.orderId = orderId;
		this.userId = userId;
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
	public int getOrderId() {
		return orderId;
	}
	public int userId(){
		return userId;
	}
	public String getUserNameString(){
		return userNameString;
	}
	public String getHotelNameString() {
		return hotelNameString;
	}
	public RoomType getRoomType(){
		return roomType;
	}
	public int getRoomNum(){
		return roomNum;
	}
	public double getPrice(){
		return price;
	}
	public OrderType getOrderType(){
		return orderType;
	}
	public Date getInDate(){
		return inDate;
	}
	public Date getOutDate(){
		return outDate;
	}
	public Date getCompleteDate(){
		return completeDate;
	}
	public Date getRevokeDate(){
		return revokeDate;
	}
	public Date getDeadLine(){
		return deadLine;
	}

}


