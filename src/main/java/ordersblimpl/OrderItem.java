package ordersblimpl;

import java.util.Date;

import Hotelblimpl.HotelsInfo;
import Membersblimpl.MembersInfo;
import Promotionsblimpl.PriceInfo;
import Promotionsblimpl.PromotionGetPrice;
import Promotionsblimpl.Promotions;
import Roomblimpl.RoomType;
import Roomblimpl.RoomsInfo;





public class OrderItem {
	String memberId;
	PromotionGetPrice promotions;
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
		return membersInfo.getName();
	}
	public String getMemberId(){
		return membersInfo.getID();
	}
	public String getHotel(){
		return hotelsInfo.getName();
	}
	public RoomType getType(){
		return roomsInfo.getRoomType();
	}
	public OrderItem(PromotionGetPrice promotions, int orderId, MembersInfo membersInfo, HotelsInfo hotelsInfo,
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
		PriceInfo info=promotions.getPrice(hotelsInfo.getName(), roomsInfo.getPrice(), roomNum, memberId,1);
		return info.getPrice();
	}
}
