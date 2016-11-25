package data.dataHelper;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrdersDataHelper {
	
	public ArrayList getOrdersList() throws SQLException;  //得到所有订单列表
	
	public boolean insertOrder(); //插入订单信息
	
	public boolean updataOrder(); //更新订单信息
	
	public boolean deleteOrder(); //删除订单信息

}
