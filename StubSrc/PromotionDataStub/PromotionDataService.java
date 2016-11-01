package PromotionDataStub;

import java.util.ArrayList;

import DataFactoryStub.DataService;
import PromotionStub.Hotel;
import PromotionStub.PromotionRole;

public interface PromotionDataService extends DataService{
	public void insert(PromotionPO promotionPO);
	public void delete(PromotionPO promotionPO);
	public void update(PromotionPO promotionPO);
	public ArrayList<PromotionPO> findPromotionList(PromotionRole role,Hotel hotel,String type);
	

}
