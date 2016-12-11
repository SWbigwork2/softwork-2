package po;

public class PromotionsIIIPO extends PromotionsPO{
  
    int num;
    public int getNum(){
    	return num;
    }
    public PromotionsIIIPO(int type,String hotel,String introduction,int num,double discount){
    	this.type=type;
    	this.hotel=hotel;
    	this.introduction=introduction;
    	this.discount=discount;
    	this.num=num;
    }
    
}
