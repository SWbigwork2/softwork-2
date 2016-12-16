package data.dataservice;

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
  public ArrayList<PromotionsPO> getHotelPromotions(String hotel) throws RemoteException;
  public boolean addPromotionsI(PromotionsIPO promotionsIPO) throws RemoteException;
  public boolean addPromotionsII(PromotionsIIPO promotionsIIPO) throws RemoteException;
  public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO) throws RemoteException;
  public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO) throws RemoteException;
  public boolean addPromotionsV(PromotionsVPO promotionsVPO) throws RemoteException;
  public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO) throws RemoteException;
  public boolean deletePromotions(PromotionsPO promotionsPO) throws RemoteException;
}
