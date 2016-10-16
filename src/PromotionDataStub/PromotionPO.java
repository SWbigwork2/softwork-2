package PromotionDataStub;

import PromotionStub.Hotel;
import PromotionStub.PromotionRole;

public class PromotionPO {
	   Hotel hotel;
	   String type;
	   PromotionRole role;
	 
	  public  PromotionPO(PromotionRole role,Hotel hotel,String type ){
	  	    this.hotel=hotel;
	  	    this.type=type;
	  	    this.role=role;
	    }
	  public Hotel getHotel(){
	  	   return hotel;
	     }
		 public  String getType(){
			 return type;
		 }
		  
		  public PromotionRole getRole(){
			  return role;
		  }
		 
}
