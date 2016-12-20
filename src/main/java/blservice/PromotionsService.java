package blservice;

import java.sql.SQLException;
import java.util.ArrayList;

import Promotionsblimpl.PriceInfo;
import view.marketer.PromotionsII2VO;
import view.marketer.PromotionsVIVO;
import view.marketer.PromotionsVVO;
import view.staff.PromotionsIIIVO;
import view.staff.PromotionsIIVO;
import view.staff.PromotionsIVO;
import view.staff.PromotionsIVVO;
import view.staff.PromotionsVO;

/**
 * @author admin
 *
 */
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
	
	/**
	 * @param promotionsIVO
	 * @return  添加策略一生日特惠
	 */
	public boolean addPromotionsII(PromotionsIIVO promotionsIIVO);
	
	/**
	 * @param promotionsII2VO
	 * @return  添加策略二节日特惠
	 */
	public boolean addPromotionsII2(PromotionsII2VO promotionsII2VO);
	
	/**
	 * @param promotionsIIIVO
	 * @return  添加策略三多间特惠
	 */
	public boolean addPromotionsIII(PromotionsIIIVO promotionsIIIVO);
	
	/**
	 * @param promotionsIVVO
	 * @return  添加策略四合作企业特惠
	 */
	public boolean addPromotionsIV(PromotionsIVVO promotionsIVVO);
	
	/**
	 * @param promotionsVVO
	 * @return  添加策略五商圈特惠
	 */
	public boolean addPromotionsV(PromotionsVVO promotionsVVO);
	
	/**
	 * @param promotionsVIVO
	 * @return  添加策略六等级特惠
	 */
	public boolean addPromotionsVI(PromotionsVIVO promotionsVIVO);
	
	/**
	 * @param promotionsVO
	 * @return  删除促销策略
	 */
	public boolean deletePromotions(PromotionsVO promotionsVO);
	
	/**
	 * @param hotel
	 * @return  返回酒店拥有的促销策略
	 */
	public ArrayList<String> getHotelPromotion(String hotel);



}
