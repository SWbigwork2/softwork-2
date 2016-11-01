package PromotionDataStub;

import java.util.ArrayList;

import PromotionStub.Hotel;
import PromotionStub.PromotionRole;

public class PromotionDataServiceMysqlImpl_Stub implements PromotionDataService{

	public PromotionDataServiceMysqlImpl_Stub() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void insert(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		System.out.println("Insert succeed");
	}

	@Override
	public void delete(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		System.out.println("Delet succeed");
	}

	@Override
	public void update(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		System.out.println("Update succeed");
	}

	
	@Override
	public ArrayList<PromotionPO> findPromotionList(PromotionRole role,Hotel hotel,String type) {
		ArrayList<PromotionPO> promotionList = new ArrayList<PromotionPO>();
		PromotionPO po = new PromotionPO(PromotionRole.hotelworker,Hotel.ИзјТ,"1");
		promotionList.add(po);
		// TODO Auto-generated method stub
		return promotionList;
	}
}

