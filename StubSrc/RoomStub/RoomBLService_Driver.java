package RoomStub;

import java.util.Date;

import OrderStub.RoomType;

public class RoomBLService_Driver {

	// Ϊ�˴���һ��RoomVO������������
	int[] unavailablePeriod = { 1, 2 };
	RoomType roomtype;
	//Ϊ�˴���һ��OccupancyVO������������
	OccupancyType type;
	

	public void drive(RoomBLService roomBLService) {
		
		//��������·���ķ���
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
		
		//���Լ�¼��ס��Ϣ�ķ���
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
		
		//���Լ�¼�˷���Ϣ�ķ���
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
