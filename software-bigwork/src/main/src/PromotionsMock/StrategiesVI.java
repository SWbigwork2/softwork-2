package PromotionsMock;

import java.util.Date;

public class StrategiesVI extends Strategies{
	String hotel;
    int viplevel;
    String introduction;
    double vipdiscount;
    public String getHotel(){
    	return hotel;
    }
    public int getViplevel(){
    	return viplevel;
    }
    public String getIntroduction(){
    	return introduction;
    }
    public double getVipdiscount(){
    	return vipdiscount;
    }
	    public StrategiesVI(String hotel,String introduction,int viplevel,double vipdiscount){
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.vipdiscount=vipdiscount;
	    	this.viplevel=viplevel;
	    }
    public double calprice(double price,int roomNum,double vipdiscount){
    	double totalprice=roomNum*price*vipdiscount;
		return totalprice;
    			
    }
}
