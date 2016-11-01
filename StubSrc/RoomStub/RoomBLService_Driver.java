package RoomStub;

import java.util.Date;

import OrderStub.RoomType;

public class RoomBLService_Driver {

	// 为了创建一个RoomVO而引进的属性
	int[] unavailablePeriod = { 1, 2 };
	RoomType roomtype;
	//为了创建一个OccupancyVO而引进的属性
	OccupancyType type;
	

	public void drive(RoomBLService roomBLService) {
		
		//测试添加新房间的方法
		ResultMessage addMessage = roomBLService
				.addRoom(new RoomVO("0001", "qitian",roomtype , "Nice", 238.0, unavailablePeriod));
		switch (addMessage) {
		case roomExist:
			System.out.println("add success");
			break;
		case roomNotExist:
			System.out.println("add failed");
			break;
		default:
			break;
		}
		
		//测试记录入住信息的方法
		ResultMessage occupancyMessage = roomBLService
				.recordOccupancy(new OccupancyVO(type, "A301", new Date(), new Date()));
		switch (occupancyMessage) {
		case success:
			System.out.println("recordOccupancy success");
		case fail:
			System.out.println("recordOccupancy failed");
		default:
			break;
		}
		
		//测试记录退房信息的方法
		ResultMessage checkOutMessage = roomBLService.recordCheckout(new CheckoutVO("A301", new Date()));
		switch (checkOutMessage) {
		case success:
			System.out.println("recordCheckOut success");
		case fail:
			System.out.println("recordCheckOut failed");
		default:
			break;
		}

	}

}
