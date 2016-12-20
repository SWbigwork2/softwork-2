package ordersblimpl;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Hotelblimpl.HotelsInfo;
import Membersblimpl.MemberServiceImpl;
import Membersblimpl.MembersInfo;
import Promotionsblimpl.PriceInfo;
import Promotionsblimpl.PromotionGetPrice;
import Promotionsblimpl.Promotions;
import Promotionsblimpl.PromotionsServiceImpl;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomsInfo;
import blservice.MembersService;
import blservice.OrdersService;
import data.dao.OrdersDao;
import data.rmi.RemoteHelper;
import javafx.geometry.Pos;
import po.OrderPO;
import vo.OrderVo;

public class OrderServiceImpl implements OrdersService{
	OrdersDao dao;
	RemoteHelper remoteHelper;
	String memberId;
	int orderId;
	OrderItem tempItem;
	PromotionGetPrice promotions;
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

	MembersService membersService;
	OrderPoVoTran tran;
	public OrderServiceImpl() {
		remoteHelper = RemoteHelper.getInstance();
		dao = remoteHelper.getOrdersDao();
		tran = new OrderPoVoTran();
		membersService = new MemberServiceImpl();
		promotions = new PromotionsServiceImpl();
		
		// TODO Auto-generated constructor stub
	}
	private void setId(String memberId){
		this.memberId = memberId;
		
	}
	public void setUp(Promotions p,HotelsInfo h,RoomsInfo r,MembersInfo m){
		promotions = p;
		hotelsInfo = h;
		membersInfo = m;
		roomsInfo =r;
		
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
	//传到界面层的vo
	public OrderVo view(){
		
				return null;
		
		
		
		
	}
	//ִ根据type得到orderItem的list
	public ArrayList<OrderVo> getOrderList(String memberId,OrderType orderType){
		OrderPoVoTran tran = new OrderPoVoTran();
		ArrayList<OrderPO> poList =  dao.getOrderList(memberId);
		ArrayList<OrderVo> resultList = new ArrayList<OrderVo>();
		for(OrderPO po:poList){
			if(po.getOrderType().equals(orderType) || orderType==OrderType.all){
				resultList.add(tran.po2vo(po));
			}
		}
		return resultList;
		
	}
	

	
	public OrderPO findOrder(int orderId) {
		
		return dao.getOrder(orderId);
		
			
	}
	public ResultMessage revoke(int orderId){
		OrderPO findPo = dao.getOrder(orderId);
		findPo.setOrderType(OrderType.revoke);
		Date revokeDate = new Date();
		findPo.setCompleteDate(revokeDate);
		int hours = ((int)(findPo.getDeadLine().getTime()-revokeDate.getTime()))/(3600*1000);
		RoomReservationService reservationService = new RoomServiceImpl();
		reservationService.revokeReservatio(findPo.getOrderId());
		if(dao.updata(findPo)){
			if(hours<6){
				membersService.updateMemberCredit(findPo.getUserId(), -findPo.getPrice()/2.0,findPo.getOrderId(),"撤销订单");
			}
			
			return ResultMessage.success;
		}
		else{
			return ResultMessage.fail;
		}
		

	}
	
	
	
	
	/**
	 * @param memberId
	 * @return 得到住过的所有酒店
	 */
	public ArrayList<String> getHotelList(String memberId){
		
		ArrayList<OrderPO> tempList =dao.getOrderList(memberId);
		ArrayList<String> resultList = new ArrayList<String>();
		for(OrderPO po:tempList){
			resultList.add(po.getHotelNameString());
		}
		return resultList;
	}
	
	public ArrayList<OrderVo> getOrderHistory(String memberId,String HotelName) {
		setId(memberId);
		
		ArrayList<OrderVo> allList =getOrderList(memberId,OrderType.all);
		
		ArrayList<OrderVo> resultList = new ArrayList<OrderVo>();
		for(OrderVo vo:allList){
			if(vo.getHotel().equals(HotelName)){
				resultList.add(vo);
			}
		}
		
		
		
		// TODO Auto-generated method stub
		return resultList;
	}
	public OrderVo getOrder(int orderId) {
		// TODO Auto-generated method stub
		return tran.po2vo(dao.getOrder(orderId));
	}
	
	public double addPre(OrderVo info) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void confirmAdd(OrderVo info) {
		OrderPO po = tran.vo2po(info);
		dao.insert(po);
		RoomReservationService reservationService = new RoomServiceImpl();
		reservationService.makeReservation(po.getOrderId(), po.getHotelNameString(), po.getRoomType(), po.getInDate(), po.getOutDate(),po.getRoomNum());
	}
	public void delete(int orderId){
		dao.delete(orderId);
	}
	public ResultMessage recover(int orderId, double recoverPer) {
		OrderPO tempPo = dao.getOrder(orderId);
		tempPo.setOrderType(OrderType.revoke);
		tempPo.setCompleteDate(new Date());
		double changeCredit = tempPo.getPrice()*recoverPer;
		
		// TODO Auto-generated method stub
		return null;
	}
	public boolean update(OrderVo info) {
		OrderPO po = tran.vo2po(info);
		// TODO Auto-generated method stub
		return dao.updata(po);
	}
	@Override
	public PriceInfo getPrice(String hotel, double price, int roomNum, String userId, int days) {
	
		// TODO Auto-generated method stub
		return promotions.getPrice(hotel, price, roomNum, userId, days);
	}
	@Override
	public void recordIn(int orderId, Date inDate) {
		
		// TODO Auto-generated method stub
		OrderPO tempPo = findOrder(orderId);
		tempPo.setInDate(inDate);
		tempPo.setOrderType(OrderType.done);
		tempPo.setCompleteDate(new Date());
		dao.updata(tempPo);
		System.out.println("checkin");
	}
	@Override
	public void recordOut(int orderId, Date outDate) {
		OrderPO tempPo = findOrder(orderId);
		tempPo.setOutDate(outDate);
		dao.updata(tempPo);
		System.out.println("checkout");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setType(int orderId, OrderType type) {
		OrderPO tempPo = findOrder(orderId);
		tempPo.setOrderType(type);
		dao.updata(tempPo);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void completeOrder(int orderId, Date outDate) {
		// TODO Auto-generated method stub
		OrderPO tempPo = findOrder(orderId);
		tempPo.setOutDate(outDate);
		tempPo.setCompleteDate(new Date());
		tempPo.setOrderType(OrderType.done);
		membersService.updateMemberCredit(tempPo.getUserId(), tempPo.getPrice(),tempPo.getOrderId(),"完成订单");
	}
	@Override
	public void errorHandle(int orderId) {
		// TODO Auto-generated method stub
		OrderPO tempPo = findOrder(orderId);
		tempPo.setCompleteDate(new Date());
		tempPo.setOrderType(orderType.error);
		membersService.updateMemberCredit(tempPo.getUserId(), -tempPo.getPrice(),tempPo.getOrderId(),"异常订单");
	}
	@Override
	public void checkOrder() {
		// TODO Auto-generated method stub
		Date nowDate = new Date();
		ArrayList<OrderPO> allOrderList = dao.getAllOrderList();
		for(OrderPO po:allOrderList){
			Date deadline = po.getDeadLine();
			if(nowDate.getTime()>deadline.getTime()){
				errorHandle(po.getOrderId());
			}
		}
	}
	@Override
	public ArrayList<OrderVo> getHotelOrder(String hotelName) {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> allList = dao.getAllOrderList();
		ArrayList<OrderVo> resultList = new ArrayList<OrderVo>();
		for(OrderPO po:allList){
			if(po.getHotelNameString().equals(hotelName)){
				resultList.add(tran.po2vo(po));
			}
		}
		return resultList;
	}
	@Override
	public ArrayList<OrderVo> getUndoList() {
		ArrayList<OrderPO> allList = dao.getAllOrderList();
		ArrayList<OrderVo> resultList = new ArrayList<OrderVo>();
		for(OrderPO po:allList){
			if(po.getOrderType()==orderType.normal||po.getOrderType()==orderType.appeal||po.getOrderType()==orderType.error){
				resultList.add(tran.po2vo(po));
			}
		}
		// TODO Auto-generated method stub
		return resultList;
	}
	@Override
	public ArrayList<OrderVo> getHotelOrderList(String hotel, String userId, OrderType type) {
		// TODO Auto-generated method stub
		ArrayList<OrderVo> tempList = getOrderList(userId, type);
		ArrayList<OrderVo> resultList = new ArrayList<OrderVo>();
		for(OrderVo vo:tempList){
			if(vo.getHotel().equals(hotel)){
				resultList.add(vo);
			}
		}
		return resultList;
	}


	
}
