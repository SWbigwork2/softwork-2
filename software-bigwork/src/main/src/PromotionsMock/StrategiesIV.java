package PromotionsMock;



public class StrategiesIV extends Strategies{
	    String hotel;	 
	    String introduction;
	    double discount;
	    public String getHotel(){
	    	return hotel;
	    }
	  
	    public String getIntroduction(){
	    	return introduction;
	    }
	    public double getDiscount(){
	    	return discount;
	    }
	    public StrategiesIV(String hotel,String introduction,double discount){
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    }
	    public double calprice(double price,int roomNum,double discount){
	    	double totalprice=roomNum*price*discount;
			return totalprice;		
	    }
}
