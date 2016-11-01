package OrdersMock;



import java.util.ArrayList;
import java.util.Date;

import PromotionsMock.Promotions;

public class OrdersMock extends Orders{
	int orderId;
	OrderItem tempItem;
	Promotions promotions;
	MembersInfo membersInfo;
	//String hotelsInfo.getName();
	HotelsInfo hotelsInfo;
	RoomsInfo roomsInfo;
	int roomNum;
	double price;
	OrderType orderType;
	Date inDate;
	Date outDate;
	Date completeDate;
	Date revokeDate;
	Date deadLine;
	OrdersListMock ordersListMock;
	public void setUp(Promotions p,HotelsInfo h,RoomsInfo r,MembersInfo m){
		promotions = p;
		hotelsInfo = h;
		membersInfo = m;
		roomsInfo =r;
		ordersListMock = new OrdersListMock();
	}
	/*public OrderBlService_Stub(int orderId, int userId, String userNameString, String hotelsInfo.getName(),
			roomsInfo.getType() roomsInfo.getType(), int roomNum, double price, OrderType orderType, Date inDate, Date outDate,
			Date completeDate, Date revokeDate, Date deadLine) {
		this.orderId = orderId;
		this.userId = userId;
		this.userNameString = userNameString;
		this.hotelsInfo.getName() = hotelsInfo.getName();
		this.roomsInfo.getType() = roomsInfo.getType();
		this.roomNum = roomNum;
		this.price = price;
		this.orderType = orderType;
		this.inDate = inDate;
		this.outDate = outDate;
		this.completeDate = completeDate;
		this.revokeDate = revokeDate;
		this.deadLine = deadLine;
	}*/
	//订单界面得到订单信息
	public OrderVO view(){
		
				OrderVO vo = new OrderVO(tempItem);
				return vo;
		
		
		
		
	}
	//执行订单步骤
	public ArrayList<OrderItem> getOrderList(OrderType orderType){
		
		return ordersListMock.getList(orderType);
		
	}
	private int makeId() {
		int size = ordersListMock.orderList.size();
		return size+1;
	}

	public ResultMessage add(int userId,HotelsInfo hotelsInfo,RoomsInfo roomsInfo, int peopleNum, Date beginDate, Date endDate, Date deadline){
		if(membersInfo.credit<200){
			return ResultMessage.notEnough;
		}
		int orderId = makeId();
		tempItem = new OrderItem(promotions, orderId,  membersInfo, hotelsInfo, roomsInfo, roomNum, orderType, beginDate, deadline, beginDate, endDate, deadline);
		
		
			return ResultMessage.success;
		
		
		
	}
	public OrderItem findOrder(int orderId) {
		
		return ordersListMock.findOrder(orderId);	
		
			
	}
	public ResultMessage revoke(int orderId){
		OrderItem temp=null;
		temp = findOrder(orderId);
		if(temp==null){
			return ResultMessage.orderNotExist;
		}
		else{
			temp.orderType = OrderType.normal;
			return ResultMessage.success;
		}

	}
	public void confirm(){
		ordersListMock.add(tempItem);
		
	}
	public ResultMessage cancel(int orderId){
		OrderItem temp=null;
		temp = ordersListMock.findOrder(orderId);
		if(temp==null){
			return ResultMessage.orderNotExist;
		}
		else{
			tempItem = null;
			return ResultMessage.success;
		}
	}
	public ResultMessage recover(int orderId){
		OrderItem temp=null;
		temp = ordersListMock.findOrder(orderId);
		if(temp==null){
			return ResultMessage.orderNotExist;
		}
		else{
			temp.orderType = OrderType.done;
			return ResultMessage.success;
		}
	}
	public ResultMessage changeError(int orderId){
		OrderItem temp=null;
		temp = ordersListMock.findOrder(orderId);
		if(temp==null){
			return ResultMessage.orderNotExist;
		}
		else{
			temp.orderType = OrderType.done;
			return ResultMessage.success;
		}
	}
	
}
