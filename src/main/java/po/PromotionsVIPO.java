package po;

public class PromotionsVIPO extends PromotionsPO{
    int viplevel;
    public int getViplevel(){
    	return viplevel;
    }
	    public PromotionsVIPO(int type,String hotel,String introduction,int viplevel,double discount){
	    	this.type=type;
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    	this.viplevel=viplevel;
	    }
}
