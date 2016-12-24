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
	/**
	 * @param promotionsIPO
	 * @return 制定策略一生日特惠
	 */
	public boolean addPromotionsI(PromotionsIPO promotionsIPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsI(promotionsIPO);
	}
	/**
	 * @param promotionsIIPO
	 * @return 制定策略二节日特惠
	 */
	public boolean addPromotionsII(PromotionsIIPO promotionsIIPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsII(promotionsIIPO);
	}
	/**
	 * @param promotionsIIIPO
	 * @return 制定策略三多间特惠
	 */
	public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsIII(promotionsIIIPO);
	}
	/**
	 * @param promotionsIVPO
	 * @return 制定策略四合作企业特惠
	 */
	public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsIV(promotionsIVPO);
	}
	/**
	 * @param promotionsVPO
	 * @return 制定策略五商圈特惠
	 */
	public boolean addPromotionsV(PromotionsVPO promotionsVPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsV(promotionsVPO);
	}
	/**
	 * @param promotionsVIPO
	 * @return 制定策略六等级特惠
	 */
	public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.addPromotionsVI(promotionsVIPO);
	}
	/**
	 * @param promotionsPO
	 * @return 删除策略
	 */
	@Override
	public ArrayList<PromotionsPO> getHotelPromotions(String hotel) {
		// TODO Auto-generated method stub
		return promotionsDataHelper.getHotelPromotions(hotel);
	}

}
