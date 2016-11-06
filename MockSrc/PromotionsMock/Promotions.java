package PromotionsMock;

import RoomsMock.RoomsInfo;


public class Promotions implements PromotionGetPrice{
	String promotions[][]=new String[1000][3];
	int pronums=0;
	public PromotionsPO getHotelPromotion(String hotel){
		
		for(int i=0;i<1000;i++){
			if(promotions[i][1].equals(hotel)){
				PromotionsPO promotionspo=new PromotionsPO(promotions[i][0],promotions[i][1],promotions[i][2]);
				return promotionspo;
			}
		}
		return null;
		
	}
	public double getPrice(RoomsInfo info,int num){
		return info.getPrice()*num;
	}
	public ResultMessage addStrategies(String Role,String hotel,String type){
		for(int i=0;i<1000;i++){
			if(hotel.equals(promotions[pronums][1])){
				return ResultMessage.hasexistpromotion;
			}
		}
		promotions[pronums][0]=Role;
		promotions[pronums][1]=hotel;
		promotions[pronums][2]=type;
		pronums++;
		return ResultMessage.Success;
		
	}
	public ResultMessage deleteStrategies(String Role,String hotel,String type){
		for(int i=0;i<1000;i++){
			if(promotions[i][0].equals(Role)&&promotions[i][1].equals(hotel)&&promotions.equals(type)){
				return ResultMessage.Success;
			}
		}
			return ResultMessage.Failure;
		
		
	}



}
