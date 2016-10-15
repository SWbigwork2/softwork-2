package OrderStub;

import java.util.Date;

public class OrderBlService_Driver {
	public void drive(OrderBlService_Stub orderBlService_Stub){
		ResultMessage result = orderBlService_Stub.add(0001, "qitian", "normal", 1, 1, new Date(), new Date(), new Date());
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
		if(orderBlService_Stub.find(0001).equals(null)){
			System.out.println("Didn't find the order");
		}
		else{
			System.out.println("Have found a order");
		}
		if(orderBlService_Stub.getOrderList(0001, OrderType.done).isEmpty()){
			System.out.println("No list found");
		}
		else{
			System.out.println("Have found a list");
		}
		ResultMessage revokeMessage = orderBlService_Stub.revoke(0001);
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
		orderBlService_Stub.confirm();
		orderBlService_Stub.cancel();
		orderBlService_Stub.recover(0001);
		orderBlService_Stub.changeError(0001);
	}

}
