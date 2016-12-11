package po;

public class PromotionsVIPO extends PromotionsPO{
    int viplevel;
    public int getViplevel(){
    	return viplevel;
    }
	    public PromotionsVIPO(int type,String hotel,String introduction,int viplevel,double discount){
	    	super(type, hotel, introduction, discount);
	    	this.viplevel=viplevel;
	    }
}
