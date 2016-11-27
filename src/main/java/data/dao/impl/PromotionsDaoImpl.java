package data.dao.impl;

import data.dao.PromotionsDao;
import data.dataHelper.DataFactory;
import data.dataHelper.MembersDataHelper;
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
		
		return promotionsDaoImpl.deletePromotions(promotionsPO);
	}

	public boolean addPromotionsI(PromotionsIPO promotionsIPO) {
		// TODO Auto-generated method stub
		return promotionsDaoImpl.addPromotionsI(promotionsIPO);
	}

	public boolean addPromotionsII(PromotionsIIPO promotionsIIPO) {
		// TODO Auto-generated method stub
		return promotionsDaoImpl.addPromotionsII(promotionsIIPO);
	}

	public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO) {
		// TODO Auto-generated method stub
		return promotionsDaoImpl.addPromotionsIII(promotionsIIIPO);
	}

	public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO) {
		// TODO Auto-generated method stub
		return promotionsDaoImpl.addPromotionsIV(promotionsIVPO);
	}

	public boolean addPromotionsV(PromotionsVPO promotionsVPO) {
		// TODO Auto-generated method stub
		return promotionsDaoImpl.addPromotionsV(promotionsVPO);
	}

	public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO) {
		// TODO Auto-generated method stub
		return promotionsDaoImpl.addPromotionsVI(promotionsVIPO);
	}

}
