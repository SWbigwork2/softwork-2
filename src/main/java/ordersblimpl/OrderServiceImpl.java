package ordersblimpl;
import java.util.ArrayList;
import java.util.Date;
import Hotelblimpl.HotelsInfo;
import Membersblimpl.MemberServiceImpl;
import Promotionsblimpl.PriceInfo;
import Promotionsblimpl.PromotionsServiceImpl;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomsInfo;
import blservice.OrdersService;
import data.dao.OrdersDao;
import data.rmi.RemoteHelper;
import po.OrderPO;
import vo.OrderVo;

public class OrderServiceImpl implements OrdersService{
	OrdersDao dao;
	RemoteHelper remoteHelper;
	int orderId;
	PromotionGetPrice promotions;
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
	MembersInfo membersService;
	OrderPoVoTran tran;
	
	public OrderServiceImpl() {
		remoteHelper = RemoteHelper.getInstance();
		dao = remoteHelper.getOrdersDao();
		tran = new OrderPoVoTran();
		membersService = new MemberServiceImpl();
		promotions = new PromotionsServiceImpl();
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param orderId
	 * @return 查找order，返回一个po
	 */
	private OrderPO findOrder(int orderId) {
		return dao.getOrder(orderId);		
	}
	//根据type得到orderItem的list
	@Override
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

	@Override
	public double revoke(int orderId){
		double changeCredit = 0;
		OrderPO findPo = dao.getOrder(orderId);
		findPo.setOrderType(OrderType.revoke);
		Date revokeDate = new Date();
		findPo.setCompleteDate(revokeDate);    //将完成时间设为撤回时间
		int hours = ((int)(findPo.getDeadLine().getTime()-revokeDate.getTime()))/(3600*1000); //判断撤回时差
		RoomReservationService reservationService = new RoomServiceImpl();   //将room时间段移除
		reservationService.revokeReservatio(findPo.getOrderId());
		if(dao.updata(findPo)){
			if(hours<6){
				membersService.updateMemberCredit(findPo.getUserId(), -findPo.getPrice()/2.0,findPo.getOrderId(),"撤销订单");
				changeCredit = findPo.getPrice()/2.0;
			}
			return changeCredit;
		}
		else{
			return changeCredit;
		}
	}
	
	/**
	 * @param memberId
	 * @return 得到住过的所有酒店
	 */
	@Override
	public ArrayList<String> getHotelList(String memberId){
		
		ArrayList<OrderPO> tempList =dao.getOrderList(memberId);
		ArrayList<String> resultList = new ArrayList<String>();
		for(OrderPO po:tempList){
			if(!resultList.contains(po.getHotelNameString())){
			resultList.add(po.getHotelNameString());
			}
		}
		return resultList;
	}
	
	@Override
	public ArrayList<OrderVo> getOrderHistory(String memberId,String HotelName) {
	
		
		ArrayList<OrderVo> allList =getOrderList(memberId,OrderType.all);
		
		ArrayList<OrderVo> resultList = new ArrayList<OrderVo>();
		for(OrderVo vo:allList){
			if(vo.getHotel().equals(HotelName)){
				resultList.add(vo);
			}
		}
		return resultList;
	}
	
	@Override
	public OrderVo getOrder(int orderId) {
		return tran.po2vo(dao.getOrder(orderId));
	}
	@Override
	public double addPre(OrderVo info) {
		return 0;
	}
	@Override
	public void confirmAdd(OrderVo info) {
		OrderPO po = tran.vo2po(info);    
		dao.insert(po);
		RoomReservationService reservationService = new RoomServiceImpl();
		reservationService.makeReservation(po.getOrderId(), po.getHotelNameString(), po.getRoomType(), po.getInDate(), po.getOutDate(),po.getRoomNum());
	}
	@Override
	public void delete(int orderId){
		dao.delete(orderId);
	}
	@Override
	public ResultMessage recover(int orderId, double recoverPer) {
		OrderPO tempPo = dao.getOrder(orderId);
		tempPo.setOrderType(OrderType.revoke);
		tempPo.setCompleteDate(new Date());
		return null;
	}
	@Override
	public boolean update(OrderVo info) {
		OrderPO po = tran.vo2po(info);
		return dao.updata(po);
	}
	@Override
	public PriceInfo getPrice(String hotel, double price, int roomNum, String userId, int days) {
		return promotions.getPrice(hotel, price, roomNum, userId, days);
	}
	@Override
	public void recordIn(int orderId, Date inDate) {
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
	}
	@Override
	public void setType(int orderId, OrderType type) {
		OrderPO tempPo = findOrder(orderId);
		tempPo.setOrderType(type);
		dao.updata(tempPo);
	}
	@Override
	public void completeOrder(int orderId, Date outDate) {
		OrderPO tempPo = findOrder(orderId);
		tempPo.setOutDate(outDate);
		tempPo.setCompleteDate(new Date());
		tempPo.setOrderType(OrderType.done);
		membersService.updateMemberCredit(tempPo.getUserId(), tempPo.getPrice(),tempPo.getOrderId(),"完成订单");
	}
	@Override
	public void errorHandle(int orderId) {
		OrderPO tempPo = findOrder(orderId);
		tempPo.setCompleteDate(new Date());
		tempPo.setOrderType(orderType.error);
		RoomReservationService reservationService = new RoomServiceImpl();   //将room时间段移除
		reservationService.revokeReservatio(orderId);
		dao.updata(tempPo);
		membersService.updateMemberCredit(tempPo.getUserId(), -tempPo.getPrice(),tempPo.getOrderId(),"异常订单");
	}
	@Override
	public void checkOrder() {
		Date nowDate = new Date();
		ArrayList<OrderPO> allOrderList = dao.getAllOrderList();
		for(OrderPO po:allOrderList){
			Date deadline = po.getDeadLine();
			if(nowDate.getTime()>deadline.getTime()&&po.getOrderType().equals(OrderType.normal)){
				errorHandle(po.getOrderId());
			}
		}
	}
	@Override
	public ArrayList<OrderVo> getHotelOrder(String hotelName) {
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
		return resultList;
	}
	@Override
	public ArrayList<OrderVo> getHotelOrderList(String hotel, String userId, OrderType type) {
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
