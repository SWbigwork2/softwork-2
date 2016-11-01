package OrderDataStub;

import java.util.ArrayList;
import java.util.Date;

import OrderStub.OrderType;
import OrderStub.ResultMessage;
import OrderStub.RoomType;

public class OrderDateService_Driver {
	public void drive(OrdersDataService ordersDataService){
		OrderPO po = new OrderPO(0001, 0001, "ะกร๗", "qitian", RoomType.big, 1, 100, OrderType.normal, new Date(), new Date(), new Date(), new Date(), new Date());
		OrderPO findPo = ordersDataService.find(0001);
		if(findPo.equals(null)){
			System.out.println("Order doesn't exist");
		}
		else{
			System.out.println("Order exists");
		}
		ArrayList<OrderPO> orderPOs = ordersDataService.findOrderList(0001, OrderType.normal);
		if(orderPOs.isEmpty()){
			System.out.println("List doesn't exist");
		}
		else{
			System.out.println("List exists");
		}
		ordersDataService.delet(po);
		ordersDataService.insert(po);
		ordersDataService.update(po);
	}

}
