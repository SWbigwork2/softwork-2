package PromotionStub;

public class PromotionBLService_Driver {
	public void drive(PromotionBLService promotionBlService){
		ResultMessage result = PromotionBLService.addStrategies(PromotionRole.hotelworker,Hotel.ИзјТ,"1");
		  if(result==ResultMessage.Failure){
			  System.out.println("promotion wrong");
		  }else System.out.println("success");
	}
}
