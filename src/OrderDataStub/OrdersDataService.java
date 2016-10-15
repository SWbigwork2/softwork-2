package OrderDataStub;

import java.util.ArrayList;

import OrderStub.OrderType;

public interface OrdersDataService {
	public void insert(OrderPO orderPO);
	public void delet(OrderPO orderPO);
	public void update(OrderPO orderPO);
	public OrderPO find(int orderId);
	public ArrayList<OrderPO> findOrderList(int userId,OrderType orderType);
	

}
