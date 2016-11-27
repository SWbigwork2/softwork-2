package data.dataHelper;

import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;

public interface PromotionsDataHelper {
  public boolean addPromotionsI(PromotionsIPO promotionsIPO);
  public boolean addPromotionsII(PromotionsIIPO promotionsIIPO);
  public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO);
  public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO);
  public boolean addPromotionsV(PromotionsVPO promotionsVPO);
  public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO);
  public boolean deletePromotions(int type,String hotel,String introduction);
}
