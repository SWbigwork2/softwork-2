package ordersblimpl;

import Promotionsblimpl.PriceInfo;

public interface PromotionGetPrice {
	public PriceInfo getPrice(String hotel,double price,int roomNum,String userId,int days);
	
}