package po;

import java.io.Serializable;
import java.util.Date;

import Roomblimpl.RoomType;
import ordersblimpl.OrderType;




public class OrderPO implements Serializable{
	int orderId;
	String userId;
	String name;
	int peopleNum;
	String hotelNameString;
	RoomType roomType;
	int roomNum;
	double price;
	OrderType orderType;
	Date beginDate; //订单开始时间
	Date inDate;   //入住时间
	Date outDate;  //离店时间
	Date completeDate; //订单完成时间
	
	Date deadLine;    //最晚执行时间
	boolean hasChild;
	
	public OrderPO(int orderId, String userId, String name,
			String hotelNameString, RoomType roomType, int roomNum,
			double price, OrderType orderType, Date inDate, Date outDate,
			Date completeDate, Date deadLine,int peopleNum,Date beginDate,boolean hasChild) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.name = name;
		this.hotelNameString = hotelNameString;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.price = price;
		this.orderType = orderType;
		this.inDate = inDate;
		this.outDate = outDate;
		this.completeDate = completeDate;
		
		this.deadLine = deadLine;
		this.peopleNum = peopleNum;
		this.beginDate = beginDate;
	}
	
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public String getName(){
		return name;
	}
	public Date getBeginDate(){
		return beginDate;
	}
	public int getPeopleNum(){
		return peopleNum;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getUserId(){
		return userId;
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
	
	public Date getDeadLine(){
		return deadLine;
	}
	public boolean isHasChild(){
		return hasChild;
	}

}


