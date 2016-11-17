package PromotionsMock;

import java.util.Date;

public class StrategiesIII extends Strategies{

    String hotel;
    String introduction;
    int num;
    double discount;
    public String getHotel(){
    	return hotel;
    }
    public int getNum(){
    	return num;
    }
    public String getIntroduction(){
    	return introduction;
    }
    public double getDiscount(){
    	return discount;
    }
    public StrategiesIII(String hotel,int num,String introduction,double discount){
    	this.hotel=hotel;
    	this.introduction=introduction;
    	this.discount=discount;
    	this.num=num;
    }
    public double calprice(int num,double price,int roomNum,double discount){
    	double totalprice;
    	if(roomNum>=num){
    		totalprice=roomNum*price*discount;
    	}else{
    		totalprice=roomNum*price;
    	}
    	
		return totalprice;
    	
    }
}
