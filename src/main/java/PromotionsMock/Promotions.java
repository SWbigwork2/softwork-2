package PromotionsMock;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import RoomsMock.RoomsInfo;


public class Promotions implements PromotionGetPrice{
	ArrayList<Strategies> strategieslist=new ArrayList<Strategies>();				
//	String promotions[][]=new String[1000][3];
//	int pronums=0;
	public  String getHotelPromotion(String hotel){
		if(hotel==null){
			return null;
		}else{
			for(Strategies item:strategieslist){
				if(item.getHotel().equals(hotel)){
					
					return item.getIntroduction();
					
				}
			}
    		
    		return null;
		}		
		
	
		
	}
	public double getPrice(RoomsInfo info,int num){
		double discount=1;
		String hotelname=info.getHotelBelongTo();
		for(Strategies item:strategieslist){
			if(item.getHotel().equals(hotelname)){
				discount=item.getDiscount();
			}
		}
				
		return info.getPrice()*num*discount;
	}
	public ResultMessage addStrategiesI(String hotel,Date birthday,String introduction,double discount){
		Date date = new Date();
    	DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日  
    	if(hotel==null){
			return ResultMessage.Failure;
		}//当时间等于生日时把这个策略添加到酒店。这个方法不知道该怎么实现。他好像是一直在后台监控。while会不会跑死
    	else if(birthday.equals(df1.format(date))){
    		Strategies temp = new StrategiesI(hotel,birthday,introduction,discount);
    		strategieslist.add(temp);
    		return ResultMessage.Success;
    	}
    	return ResultMessage.Failure;
	}
	public ResultMessage addStrategiesII(String hotel,Date startdate,Date enddate,String introduction,double discount ){
		Date date = new Date();
    	DateFormat df = DateFormat.getDateInstance();
    	if(hotel==null){
			return ResultMessage.Failure;
		}
		if(df.format(date).compareTo(df.format(startdate))<-1&&df.format(date).compareTo(df.format(enddate))>1){
			return ResultMessage.Failure;	
		}
		else{
			Strategies tempII=new StrategiesII(hotel,startdate,enddate,introduction,discount);
			strategieslist.add(tempII);
			return ResultMessage.Success;
		}
		
	}
	public ResultMessage addStrategiesIII(String hotel,int num,String introduction,double discount){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			Strategies tempIII = new StrategiesIII(hotel,num,introduction,discount);
    		strategieslist.add(tempIII);
    		return ResultMessage.Success;
		}				
	}	
	public ResultMessage addStategiesIV(String hotel,String introduction,double discount){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			Strategies temp = new StrategiesIV(hotel,introduction,discount);
    		strategieslist.add(temp);
    		return ResultMessage.Success;
		}		
		
	}
	public ResultMessage addStrategiesV(String hotel,int viplevel,String area,String introduction,double discount){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			Strategies temp = new StrategiesV(hotel,viplevel,area,introduction,discount);
    		strategieslist.add(temp);
    		return ResultMessage.Success;
		}		
		
	}
	public ResultMessage addStrategiesVI(String hotel,String introduction,int viplevel,double vipdiscount){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			Strategies temp = new StrategiesVI(hotel,introduction,viplevel,vipdiscount);
    		strategieslist.add(temp);
    		return ResultMessage.Success;
		}		
		
	}
	
	
	public ResultMessage deleteStrategies(String hotel){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			for(Strategies item:strategieslist){
				if(item.getHotel().equals(hotel)){
					strategieslist.remove(item);
					return ResultMessage.Success;
					
				}
			}
    		
    		return ResultMessage.Failure;
		}		
		
		
	}



}
