package ordersblimpl;
import java.util.Date;

import Membersblimpl.MemberServiceImpl;
import Roomblimpl.RoomType;
import po.OrderPO;
import vo.OrderVo;

/**
 * @author 朱润之
 * 用于vo与po的互相转换
 */
public class OrderPoVoTran {
	/**
	 * @param po
	 * @return po转换为vo;
	 */
	public OrderVo po2vo(OrderPO po){
		int orderId = po.getOrderId();
		String userId = po.getUserId();
		String name =po.getName();
		String hotel = po.getHotelNameString();
		Date beginDate = po.getBeginDate();
		Date completeDate = po.getCompleteDate();
		Date inDate = po.getInDate();
		Date outDate = po.getOutDate();
		Date deadLine = po.getDeadLine();
		double price = po.getPrice();
		String type = po.getOrderType().toString();
		MembersInfo info = new MemberServiceImpl();
		String userLevel =info.getMemberLevel(po.getUserId());
		int roomNum = po.getRoomNum();
		String roomType = po.getRoomType().toString();
		int peopleNum = po.getPeopleNum();
		boolean hasChild = po.isHasChild();
		
		
		
		OrderVo vo = new OrderVo(userLevel, orderId, userId, name, hotel, beginDate, completeDate, inDate, outDate, deadLine, price, type, roomType, roomNum, peopleNum, hasChild);
		return vo;
	}
	
	/**
	 * @param vo
	 * @return vo转po
	 */
	public OrderPO vo2po(OrderVo vo){
		int orderId = vo.getOrderId();
		String userId = vo.getUserId();
		String hotelNameString = vo.getHotel();
		RoomType roomType = RoomType.valueOf(vo.getRoomType());
		int roomNum = vo.getRoomNum();
		double price = vo.getPrice();
		OrderType orderType = OrderType.valueOf(vo.getType());
		Date inDate = vo.getInDate();
		Date outDate = vo.getOutDate();
		Date completeDate = vo.getCompleteDate();
		Date beginDate = vo.getBeginDate();
		Date deadLine = vo.getDeadLine();
		int peopleNum = vo.getPeopleNum();
		boolean hasChild = vo.isHasChild();
		String name = vo.getName();
		OrderPO po = new OrderPO(orderId, userId, name,hotelNameString, roomType, roomNum, price, orderType, inDate, outDate, completeDate, deadLine, peopleNum, beginDate, hasChild);
		po.setHasChild(hasChild);
		return po;
	}
	
}