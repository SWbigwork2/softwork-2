package po;

public class PromotionsIPO extends PromotionsPO {
    String hotel;
     int type;
    String introduction;
    double discount;
 
	    public PromotionsIPO(int type,String hotel,String introduction,double discount){
	    	this.type=type;
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    }
   
}
