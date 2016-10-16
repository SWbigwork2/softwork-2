package PromotionStub;

public class PromotionVO {
	   Hotel hotel;
	   String type;
	   PromotionRole role;
	  public PromotionVO(PromotionRole role,Hotel hotel,String type ){
	  	    this.hotel=hotel;
	  	    this.type=type;
	  	    this.role=role;
	    }
}
