package PromotionsMock;

import java.text.DateFormat;
import java.util.Date;

public class StrategiesI extends Strategies {
    String hotel;
    Date birthday;
    String introduction;
    double discount;
    public String getHotel(){
    	return hotel;
    }
    public Date getBirthday(){
    	return birthday;
    }
    public String getIntroduction(){
    	return introduction;
    }
    public double getDiscount(){
    	return discount;
    }
	    public StrategiesI(String hotel,Date birthday,String introduction,double discount){
	    	this.hotel=hotel;
	    	this.birthday=birthday;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    }
    public double calprice(double price,int roomNum,double discount){
    	double totalprice=price*discount*roomNum;
    	
    	return totalprice;
    }
}
