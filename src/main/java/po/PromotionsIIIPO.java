package po;

public class PromotionsIIIPO extends PromotionsPO{
  
    int num;
    public int getNum(){
    	return num;
    }
    public PromotionsIIIPO(int type,String hotel,String introduction,int num,double discount){
    	super(type, hotel, introduction, discount);
    	this.num=num;
    }
    
}
