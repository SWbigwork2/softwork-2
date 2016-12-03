package blservice;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import ordersblimpl.OrderType;
import ordersblimpl.ResultMessage;
import view.member.OrderVo;

public interface OrderService {
	
	/**
	 * @param type
	 * @return 根据type返回的订单列表
	 */
	public ArrayList<OrderVo> getOrderList(String memberId,OrderType type);
	
	/**
	 * @param orderId
	 * @return 根据id查找的order
	 */
	public OrderVo getOrder(int orderId);
	
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
	public ResultMessage confirmAdd(OrderVo info);
	
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
	 * @param recoverPer 恢复的比率
	 * @return 恢复异常订单
	 */
	public ResultMessage recover(int orderId,double recoverPer);
	
	
}
