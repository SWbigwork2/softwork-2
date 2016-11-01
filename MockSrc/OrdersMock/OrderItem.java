package OrdersMock;

import java.util.Date;

import PromotionsMock.Promotions;
import RoomsMock.RoomType;




public class OrderItem {
	Promotions promotions;
	int orderId;
	MembersInfo membersInfo;
	HotelsInfo hotelsInfo;
	int peopleNum;
	RoomsInfo roomsInfo;
	int roomNum;
	OrderType orderType;
	Date inDate;
	Date outDate;
	Date completeDate;
	public String getName(){
		return membersInfo.name;
	}
	public int getId(){
		return membersInfo.memberId;
	}
	public String getHotel(){
		return hotelsInfo.getName();
	}
	public RoomType getType(){
		return roomsInfo.getType();
	}
	public OrderItem(Promotions promotions, int orderId, MembersInfo membersInfo, HotelsInfo hotelsInfo,
			RoomsInfo roomsInfo, int roomNum, OrderType orderType, Date inDate, Date outDate, Date completeDate,
			Date revokeDate, Date deadLine,int peopleNum) {
		this.promotions = promotions;
		this.orderId = orderId;
		this.membersInfo = membersInfo;
		this.hotelsInfo = hotelsInfo;
		this.roomsInfo = roomsInfo;
		this.roomNum = roomNum;
		this.orderType = orderType;
		this.inDate = inDate;
		this.outDate = outDate;
		this.completeDate = completeDate;
		this.revokeDate = revokeDate;
		this.deadLine = deadLine;
	}
	Date revokeDate;
	Date deadLine;
	public double calPrice(){
		promotions = new Promotions();
		return promotions.getPrice(roomsInfo, roomNum);
		
	}
}
