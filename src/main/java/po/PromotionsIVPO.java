package po;



public class PromotionsIVPO extends PromotionsPO{
	    String hotel;	 
	    String introduction;
	    double discount;
	    int type;
	    public PromotionsIVPO(int type,String hotel,String introduction,double discount){
	    	this.type=type;
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    }
	  
}
