package data.dataHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;

public interface PromotionsDataHelper {
	 /**
	 * @param hotel
	 * @return 得到酒店促销策略
	 */
  public ArrayList<PromotionsPO> getHotelPromotions(String hotel);
  /**
	 * @param promotionsIPO
	 * @return 制定策略一生日特惠
	 */
public boolean addPromotionsI(PromotionsIPO promotionsIPO);
/**
 * @param promotionsIIPO
 * @return 制定策略二节日特惠
 */
  public boolean addPromotionsII(PromotionsIIPO promotionsIIPO);
  /**
	 * @param promotionsIIIPO
	 * @return 制定策略三多间特惠
	 */
  public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO);
  /**
   * @param promotionsIVPO
   * @return 制定策略四合作企业特惠
   */
  public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO);
  /**
   * @param promotionsVPO
   * @return 制定策略五商圈特惠
   */
  public boolean addPromotionsV(PromotionsVPO promotionsVPO);
  /**
   * @param promotionsVIPO
   * @return 制定策略六等级特惠
   */
  public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO);
  /**
   * @param promotionsPO
   * @return 删除策略
   */
  public boolean deletePromotions(PromotionsPO promotionsPO);
}
