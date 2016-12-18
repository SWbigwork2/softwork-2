package po;

public class PromotionsIIIPO extends PromotionsPO{
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 8002205771319356144L;
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
