package data.dao.impl;

import java.util.ArrayList;

import data.dao.PromotionsDao;
import data.dataHelper.DataFactory;
import data.dataHelper.PromotionsDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;

public class PromotionsDaoImpl implements PromotionsDao{

	private static PromotionsDaoImpl promotionsDaoImpl;
	private static PromotionsDataHelper promotionsDataHelper;
	private DataFactory dataFactory;
	public PromotionsDaoImpl() {
		// TODO Auto-generated constructor stub
		dataFactory = new DataFactoryImpl();
        promotionsDataHelper =dataFactory.getPromtionsDataHelper();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		PromotionsDaoImpl promotionsdao = new PromotionsDaoImpl();
	}
	public static PromotionsDaoImpl getInstance(){
		if(promotionsDaoImpl ==null){
			promotionsDaoImpl = new PromotionsDaoImpl();
			return promotionsDaoImpl;
		}
		else{
			return promotionsDaoImpl;
		}
	}
	public boolean deletePromotions(PromotionsPO promotionsPO) {
		// TODO Auto-generated method stub
		
		return promotionsDataHelper.deletePromotions(promotionsPO);
	}

	public boolean addPromotionsI(PromotionsIPO promotionsIPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsI(promotionsIPO);
	}

	public boolean addPromotionsII(PromotionsIIPO promotionsIIPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsII(promotionsIIPO);
	}

	public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsIII(promotionsIIIPO);
	}

	public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsIV(promotionsIVPO);
	}

	public boolean addPromotionsV(PromotionsVPO promotionsVPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsV(promotionsVPO);
	}

	public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsVI(promotionsVIPO);
	}
	@Override
	public ArrayList<PromotionsPO> getHotelPromotions(String hotel) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.getHotelPromotions(hotel);
	}

}
