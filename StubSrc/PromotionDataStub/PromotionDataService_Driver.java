package PromotionDataStub;

import PromotionStub.Hotel;
import PromotionStub.PromotionRole;

public class PromotionDataService_Driver {
	public void drive(PromotionDataService promotionDataService){
		PromotionPO po = new PromotionPO(PromotionRole.hotelworker,Hotel.ИзјТ,"1");
	
		promotionDataService.delete(po);
		promotionDataService.insert(po);
		promotionDataService.update(po);
	}
}
