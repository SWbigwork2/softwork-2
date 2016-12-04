package PromotionsMock;

import java.util.Date;

public class StrategiesV extends Strategies{
    int viplevel;
    String area;
    String introduction;
    String hotel;
    double discount;
    public String getHotel(){
    	return hotel;
    }
    public String getArea(){
    	return area;
    }
    public String getIntroduction(){
    	return introduction;
    }
    public double getDiscount(){
    	return discount;
    }
    public int getViplevel(){
    	return viplevel;
    }
    public StrategiesV(String hotel,int viplevel,String area,String introduction,double discount){
    	this.introduction=introduction;
    	this.discount=discount;
    	this.area=area;
    	this.viplevel=viplevel;
    	this.hotel=hotel;
    }
    public double calprice(double price,int roomNum,double discount){
    	double totalprice=roomNum*price*discount;
		return totalprice;		
    }
}
