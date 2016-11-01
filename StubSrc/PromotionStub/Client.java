package PromotionStub;


public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	PromotionBLService_Stub promotionBlService_Stub = new PromotionBLService_Stub(PromotionRole.hotelworker,Hotel.ИзјТ,"1");
	PromotionBLService_Driver driver = new PromotionBLService_Driver();
	driver.drive(promotionBlService_Stub);
}
}
