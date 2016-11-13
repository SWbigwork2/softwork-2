package PromotionsMock;

import java.util.Date;

public class StrategiesII extends Strategies{
	
	    String hotel;
	    Date startdate,enddate;
	    String introduction;
	    double discount;
	    public String getHotel(){
	    	return hotel;
	    }
	    public Date getStartdate(){
	    	return startdate;
	    }
	    public Date getEnddate(){
	    	return enddate;
	    }
	    public String getIntroduction(){
	    	return introduction;
	    }
	    public double getDiscount(){
	    	return discount;
	    }
	    public StrategiesII(String hotel,Date startdate,Date enddate,String introduction,double discount){
	    	this.hotel=hotel;
	    	this.startdate=startdate;
	    	this.enddate=enddate;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    }
	    public double calprice(double price,int roomNum,double discount){
	    	double totalprice=roomNum*price*discount;
			return totalprice;
	    	
	    }
}
