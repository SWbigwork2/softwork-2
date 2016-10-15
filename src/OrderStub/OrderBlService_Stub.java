package OrderStub;

import java.util.ArrayList;
import java.util.Date;

public class OrderBlService_Stub implements OrdersBlService{
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
	
	public OrderBlService_Stub(int orderId, int userId, String userNameString, String hotelNameString,
			RoomType roomType, int roomNum, double price, OrderType orderType, Date inDate, Date outDate,
			Date completeDate, Date revokeDate, Date deadLine) {
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
	//订单界面得到订单信息
	public OrderVO find(int orderId){
		return new OrderVO(userNameString, hotelNameString, roomType, orderId, orderId, orderType, inDate, outDate, completeDate, revokeDate, deadLine);
	}
	//执行订单步骤
	public ArrayList<OrderVO> getOrderList(int UserId,OrderType orderType){
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		orderVOs.add(new OrderVO(userNameString, hotelNameString, roomType, UserId, UserId, orderType, inDate, outDate, completeDate, revokeDate, deadLine));
		return orderVOs;
	}
	public ResultMessage add(int userId,String hotelName, RoomType roomType,int roomNum, int peopleNum, Date beginDate, Date endDate, Date deadline){
		if(userId == 0001){
			return ResultMessage.notEnough;
		}
		else if (userId == 0002) {
			return ResultMessage.userNotExist;
		}
		else if(userId == 0003){
			return ResultMessage.hotelNotExist;
		}
		else {
			return ResultMessage.success;
		}
	}
	public ResultMessage revoke(int orderId){
		if(orderId == 0001){
			return ResultMessage.fail;
		}
		else
			return ResultMessage.success;
	}
	public void confirm(){
		System.out.println("Confirm!");
		
	}
	public void cancel(){
		System.out.println("Cancel!");
	}
	public void recover(int orderId){
		System.out.println("Revoke!");
	}
	public void changeError(int orderId){
		System.out.println("changeError");
	}
	
}
