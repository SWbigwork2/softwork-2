package ordersblimpl;

import Promotionsblimpl.PriceInfo;

/**
 * @author 朱润之
 * 抽离promotion得到的接口，用于计算最优价格
 */
public interface PromotionGetPrice {
	public PriceInfo getPrice(String hotel,double price,int roomNum,String userId,int days);
	
}