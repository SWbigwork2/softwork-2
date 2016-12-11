package po;

public class PromotionsVPO extends PromotionsPO{
    int viplevel;
    String area;
  
    public String getArea(){
    	return area;
    }
 
    public int getViplevel(){
    	return viplevel;
    }
    public PromotionsVPO(int type,String hotel,String introduction,int viplevel,String area,double discount){
    	this.type=type;
    	this.hotel=hotel;
    	this.introduction=introduction;
    	this.discount=discount;
    	this.area=area;
    	this.viplevel=viplevel;
    	this.hotel=hotel;
    }
   
}
