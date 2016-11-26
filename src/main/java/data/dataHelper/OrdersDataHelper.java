package data.dataHelper;

import java.sql.SQLException;
import java.util.ArrayList;

import po.OrderPO;

public interface OrdersDataHelper {
	
	public ArrayList getOrdersList() throws SQLException;  //得到所有订单列表
	
	public boolean insertOrder(OrderPO po); //插入订单信息
	
	public boolean updataOrder(OrderPO po); //更新订单信息
	
	public boolean deleteOrder(int orderId); //删除订单信息

}
