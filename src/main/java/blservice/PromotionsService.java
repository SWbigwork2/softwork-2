package blservice;

import java.sql.SQLException;

import Promotionsblimpl.PriceInfo;
import view.marketer.PromotionsII2VO;
import view.marketer.PromotionsVIVO;
import view.marketer.PromotionsVVO;
import view.staff.PromotionsIIIVO;
import view.staff.PromotionsIIVO;
import view.staff.PromotionsIVO;
import view.staff.PromotionsIVVO;
import view.staff.PromotionsVO;

public interface PromotionsService {
	/**
	 * @param hotel
	 * @param price
	 * @param roomNum
	 * @param userId
	 * @param days
	 * @return 计算最优价格，返回价格信息
	 * @throws SQLException 
	 */
	public PriceInfo getPrice(String hotel,double price,int roomNum,String userId,int days);
	public boolean addPromotionsI(PromotionsIVO promotionsIVO);
	public boolean addPromotionsII(PromotionsIIVO promotionsIIVO);
	public boolean addPromotionsII2(PromotionsII2VO promotionsII2VO);
	public boolean addPromotionsIII(PromotionsIIIVO promotionsIIIVO);
	public boolean addPromotionsIV(PromotionsIVVO promotionsIVVO);
	public boolean addPromotionsV(PromotionsVVO promotionsVVO);
	public boolean addPromotionsVI(PromotionsVIVO promotionsVIVO);
	public boolean deletePromotions(PromotionsVO promotionsVO);




}
