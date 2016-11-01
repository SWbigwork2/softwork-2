package RoomStub;

import OrderStub.RoomType;

public class Client {
	public static void main(String[] args) {
		int a[]={1,2};
		RoomBLService roomBLService = new RoomBLService_Stub("r", "h", RoomType.big, "i", 100.0,a);
		RoomBLService_Driver driver = new RoomBLService_Driver();
		driver.drive(roomBLService);
		
	}
	

}
