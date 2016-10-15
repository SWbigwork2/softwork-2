package OrderStub;

import java.util.Date;

public class OrderBlService_Driver {
	public void drive(OrdersBlService orderBlService){
		ResultMessage result = orderBlService.add(0001, "qitian", RoomType.big, 1, 1, new Date(), new Date(), new Date());
		switch (result) {
		case userNotExist:
			System.out.println("User doesn't exist");
			break;
		case fail:
			System.out.println("Add order fail");
			break;
		case success:
			System.out.println("Add order success");
			break;
		case hotelNotExist:	
			System.out.println("The hotel doesn't exist");
			break;
		case notEnough:
			System.out.println("Your credit isn't enough");
			break;
		default:
			break;
		}
		if(orderBlService.find(0001).equals(null)){
			System.out.println("Didn't find the order");
		}
		else{
			System.out.println("Have found a order");
		}
		if(orderBlService.getOrderList(0001, OrderType.done).isEmpty()){
			System.out.println("No list found");
		}
		else{
			System.out.println("Have found a list");
		}
		ResultMessage revokeMessage = orderBlService.revoke(0001);
		switch (revokeMessage) {
		
		
		case fail:
			System.out.println("Add order fail");
			break;
		case success:
			System.out.println("Add order success");
			break;
		
		default:
			System.out.println("error");
			break;
		}
		orderBlService.confirm();
		orderBlService.cancel();
		orderBlService.recover(0001);
		orderBlService.changeError(0001);
	}

}
