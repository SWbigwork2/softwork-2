package PromotionDataStub;

import PromotionStub.Hotel;
import PromotionStub.PromotionRole;

public class PromotionDataService_Driver {
	public void drive(PromotionDataService promotionDataService){
		PromotionPO po = new PromotionPO(PromotionRole.hotelworker,Hotel.���,"1");
	
		promotionDataService.delete(po);
		promotionDataService.insert(po);
		promotionDataService.update(po);
	}
}
