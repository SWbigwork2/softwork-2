package po;

public class PromotionsIIIPO extends PromotionsPO{

    String hotel;
    int type;
    String introduction;
    int num;
    double discount;

    public int getNum(){
    	return num;
    }
    public PromotionsIIIPO(int type,String hotel,String introduction,int num,double discount){
    	this.hotel=hotel;
    	this.introduction=introduction;
    	this.discount=discount;
    	this.num=num;
    }
    
}
