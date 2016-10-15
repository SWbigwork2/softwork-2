package OrderStub;

import java.util.Date;

public class Client {
	public static void main(String[] args) {
		OrdersBlService orderBlService_Stub = new OrderBlService_Stub(0001, 0001, "winter", "qitian", RoomType.big, 1, 100, OrderType.normal, new Date(), new Date(), new Date(), new Date(), new Date());
		OrderBlService_Driver driver = new OrderBlService_Driver();
		driver.drive(orderBlService_Stub);
	}

}
