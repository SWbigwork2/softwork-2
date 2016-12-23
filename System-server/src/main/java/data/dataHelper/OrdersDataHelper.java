package data.dataHelper;

import java.sql.SQLException;
import java.util.ArrayList;

import po.OrderPO;

/**
 * @author 朱润之
 * datahelper的接口，用于隔离数据层与具体实现
 */
public interface OrdersDataHelper {
	
	/**
	 * @return 得到订单列表
	 * @throws SQLException
	 */
	public ArrayList getOrdersList() throws SQLException;  
	
	/**
	 * @param po
	 * @return 插入订单
	 */
	public boolean insertOrder(OrderPO po);
	
	/**
	 * @param po
	 * @return 更新订单
	 */
	public boolean updataOrder(OrderPO po); 
	
	/**
	 * @param orderId
	 * @return 删除订单
	 */
	public boolean deleteOrder(int orderId);

}
