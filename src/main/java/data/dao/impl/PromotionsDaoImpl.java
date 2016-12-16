package data.dao.impl;

import java.util.ArrayList;

import data.dao.PromotionsDataService;
import data.dataHelper.DataFactory;
import data.dataHelper.PromotionsDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import data.dataservice.PromotionsDao;
import data.rmi.RemoteHelper;
import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;

public class PromotionsDaoImpl implements PromotionsDataService{

	private static PromotionsDaoImpl promotionsDaoImpl;
	private static PromotionsDataHelper promotionsDataHelper;
	private DataFactory dataFactory;
	private RemoteHelper remoteHelper;
	private PromotionsDao promotionsDao;
	public PromotionsDaoImpl() {
		remoteHelper = RemoteHelper.getInstance();
		promotionsDao = remoteHelper.getPromotionsDao();
		// TODO Auto-generated constructor stub
		dataFactory = new DataFactoryImpl();
        promotionsDataHelper =dataFactory.getPromtionsDataHelper();
		// TODO Auto-generated constructor stub
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
		
		return promotionsDao.deletePromotions(promotionsPO);
	}

	public boolean addPromotionsI(PromotionsIPO promotionsIPO) {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsI(promotionsIPO);
	}

	public boolean addPromotionsII(PromotionsIIPO promotionsIIPO) {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsII(promotionsIIPO);
	}

	public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO) {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsIII(promotionsIIIPO);
	}

	public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO) {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsIV(promotionsIVPO);
	}

	public boolean addPromotionsV(PromotionsVPO promotionsVPO) {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsV(promotionsVPO);
	}

	public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO) {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsVI(promotionsVIPO);
	}
	@Override
	public ArrayList<PromotionsPO> getHotelPromotions(String hotel) {
		// TODO Auto-generated method stub
		return promotionsDao.getHotelPromotions(hotel);
	}

}
