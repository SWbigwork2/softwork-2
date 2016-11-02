package PromotionsMock;

import RoomsMock.RoomsInfo;

public class Promotions implements PromotionGetPrice{
	public double getPrice(RoomsInfo info,int num){
		return info.getPrice()*num;
	}

}
