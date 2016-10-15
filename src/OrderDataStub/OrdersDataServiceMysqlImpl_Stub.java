package OrderDataStub;

import java.util.ArrayList;
import java.util.Date;

import OrderStub.OrderType;
import OrderStub.RoomType;

public class OrdersDataServiceMysqlImpl_Stub implements OrdersDataService{

	public OrdersDataServiceMysqlImpl_Stub() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void insert(OrderPO orderPO) {
		// TODO Auto-generated method stub
		System.out.println("Insert succeed");
	}

	@Override
	public void delet(OrderPO orderPO) {
		// TODO Auto-generated method stub
		System.out.println("Delet succeed");
	}

	@Override
	public void update(OrderPO orderPO) {
		// TODO Auto-generated method stub
		System.out.println("Update succeed");
	}

	@Override
	public OrderPO find(int orderId) {
		// TODO Auto-generated method stub
		return new OrderPO(0001, 0001, "小明", "qitian", RoomType.big, 1, 100, OrderType.normal, new Date(), new Date(), new Date(), new Date(), new Date());
	}

	@Override
	public ArrayList<OrderPO> findOrderList(int userId, OrderType orderType) {
		ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
		OrderPO po = new OrderPO(0001, 0001, "小明", "qitian", RoomType.big, 1, 100, OrderType.normal, new Date(), new Date(), new Date(), new Date(), new Date());
		orderList.add(po);
		// TODO Auto-generated method stub
		return orderList;
	}

}
