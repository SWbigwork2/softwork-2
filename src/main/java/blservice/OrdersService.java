package blservice;

import java.util.ArrayList;
import java.util.Date;



import Promotionsblimpl.PriceInfo;

import ordersblimpl.OrderType;
import ordersblimpl.ResultMessage;
import vo.OrderVo;

public interface OrdersService {
	
	/**
	 * @param hotel
	 * @param price
	 * @param roomNum
	 * @param userId
	 * @param days
	 * @return 订单总价格
	 */
	public PriceInfo getPrice(String hotel,double price,int roomNum,String userId,int days);
		
	/**
	 * @param orderId
	 * @param outDate
	 * 完成订单
	 */
	public void completeOrder(int orderId,Date outDate);
		
	
	
	/**
	 * @param type
	 * @return 根据type返回的订单列表
	 */
	public ArrayList<OrderVo> getOrderList(String memberId,OrderType type);
	
	
	/**
	 * @param memberId
	 * @return 得到用户住过的酒店
	 */
	public ArrayList<String> getHotelList(String memberId);
	/**
	 * @param orderId
	 * @return 根据id查找的order
	 */
	public OrderVo getOrder(int orderId);
	/**
	 * @param orderId
	 * @param inDate
	 * 记录入住时间
	 */
	public void recordIn(int orderId,Date inDate);
	
	/**
	 * @param orderId
	 * @param outDate
	 * 记录退房时间
	 */
	public void recordOut(int orderId,Date outDate);
		
	
	/**
	 * @param orderId
	 * @param type 
	 * 设置orderType
	 */
	public void setType(int orderId,OrderType type);
	/**
	 * @param info
	 * @return	更新订单信息
	 */
	public ResultMessage update(OrderVo info);
	
	/**
	 * @param info
	 * @return 生成订单预览界面，显示价格，等待确认
	 */
	public double addPre(OrderVo info);
	
	/**
	 * @param info
	 * @return 确认添加订单
	 */
	public void confirmAdd(OrderVo info);
	
	/**
	 * @param orderId
	 * @return 删除订单信息
	 */
	public void delete(int orderId);
	
	/**
	 * @param orderId
	 * @return 撤销订单
	 */
	public ResultMessage revoke(int orderId);
	
	/**
	 * @param orderId
	 * 将订单置为异常订单
	 */
	public void errorHandle(int orderId);
	
	/**
	 * 检查是否有订单超时
	 */
	public void checkOrder();
	/**
	 * @param orderId
	 * @param recoverPer 恢复的比率
	 * @return 恢复异常订单
	 */
	public ResultMessage recover(int orderId,double recoverPer);
	
	
}
