package PromotionsMock;

import OrdersMock.RoomsInfo;

public class Promotions {
	public double getPrice(RoomsInfo info,int num){
		return info.price*num;
	}

}
