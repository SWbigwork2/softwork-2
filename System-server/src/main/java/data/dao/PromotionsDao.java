package data.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;

public interface PromotionsDao extends Remote{
  /**
 * @param hotel
 * @return 得到酒店促销策略
 * @throws RemoteException
 */
public ArrayList<PromotionsPO> getHotelPromotions(String hotel) throws RemoteException;
  /**
 * @param promotionsIPO
 * @return 制定策略一生日特惠
 * @throws RemoteException
 */
public boolean addPromotionsI(PromotionsIPO promotionsIPO) throws RemoteException;
  /**
 * @param promotionsIIPO
 * @return 制定策略二节日特惠
 * @throws RemoteException
 */
public boolean addPromotionsII(PromotionsIIPO promotionsIIPO) throws RemoteException;
  /**
 * @param promotionsIIIPO
 * @return 制定策略三多间特惠
 * @throws RemoteException
 */
public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO) throws RemoteException;
  /**
 * @param promotionsIVPO
 * @return 制定策略四合作企业特惠
 * @throws RemoteException
 */
public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO) throws RemoteException;
  /**
 * @param promotionsVPO
 * @return 制定策略五商圈特惠
 * @throws RemoteException
 */
public boolean addPromotionsV(PromotionsVPO promotionsVPO) throws RemoteException;
  /**
 * @param promotionsVIPO
 * @return 制定策略六等级特惠
 * @throws RemoteException
 */
public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO) throws RemoteException;
  /**
 * @param promotionsPO
 * @return  删除策略
 * @throws RemoteException
 */
public boolean deletePromotions(PromotionsPO promotionsPO) throws RemoteException;
}
