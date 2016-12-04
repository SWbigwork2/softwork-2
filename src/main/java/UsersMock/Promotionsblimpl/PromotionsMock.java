package Promotionsblimpl;

import java.text.DateFormat;
import java.util.Date;

import RoomsMock.RoomsInfo;
import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;

public class PromotionsMock extends Promotions{
	public  String getHotelPromotion(String hotel){
		if(hotel==null){
			return null;
		}else{
			for(PromotionsPO item:strategieslist){
				if(item.getHotel().equals(hotel)){
					
					return item.getIntroduction();
					
				}
			}
    		
    		return null;
		}		
		
	
		
	}
//	public double getPrice(RoomsInfo info,int num){
//		double discount=1;
//		String hotelname=info.getHotelBelongTo();
//		for(PromotionsPO item:strategieslist){
//			if(item.getHotel().equals(hotelname)){
//				discount=item.getDiscount();
//			}
//		}
//				
//		return info.getPrice()*num*discount;
//	}
	//添加策略一
	public ResultMessage addPromotionsI(int type,String hotel,String introduction,double discount){
//		Date date = new Date();
//    	DateFormat df1 = DateFormat.getDateInstance();//���ڸ�ʽ����ȷ����  
    	if(hotel==null){
			return ResultMessage.Failure;
		}
    	else {
    		PromotionsPO temp = new PromotionsIPO(type,hotel,introduction,discount);
    		strategieslist.add(temp);
    		return ResultMessage.Success;
    	}
	}
	//添加策略二
	public ResultMessage addPromotionsII(int type,String hotel,String introduction,Date startdate,Date enddate,double discount){
		Date date = new Date();
    	DateFormat df = DateFormat.getDateInstance();
    	if(hotel==null){
			return ResultMessage.Failure;
		}
		if(df.format(date).compareTo(df.format(startdate))<-1&&df.format(date).compareTo(df.format(enddate))>1){
			return ResultMessage.Failure;	
		}
		else{
			PromotionsPO tempII=new PromotionsIIPO(type,hotel,introduction,startdate,enddate,discount);
			strategieslist.add(tempII);
			return ResultMessage.Success;
		}
		
	}
	//添加策略三
	public ResultMessage addPromotionsIII(int type,String hotel,String introduction,int num,double discount){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			PromotionsPO tempIII = new PromotionsIIIPO(type,hotel,introduction,num,discount);
    		strategieslist.add(tempIII);
    		return ResultMessage.Success;
		}				
	}
	//添加策略四
	/**
	 * @param type
	 * @param hotel
	 * @param introduction
	 * @param companyname
	 * @param discount
	 * @return
	 */
	public ResultMessage addPromotionsIV(int type,String hotel,String introduction,String companyname,double discount){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			PromotionsPO temp = new PromotionsIVPO(type,hotel,introduction,companyname,discount);
    		strategieslist.add(temp);
    		return ResultMessage.Success;
		}		
		
	}
	//添加策略五
	public ResultMessage addPromotionsV(int type,String hotel,String introduction,int viplevel,String area,double discount){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			PromotionsPO temp = new PromotionsVPO(type,hotel,introduction,viplevel,area,discount);
    		strategieslist.add(temp);
    		return ResultMessage.Success;
		}		
		
	}
	//添加策略六
	public ResultMessage addPromotionsVI(int type,String hotel,String introduction,int viplevel,double discount){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			PromotionsPO temp = new PromotionsVIPO(type,hotel,introduction,viplevel,discount);
    		strategieslist.add(temp);
    		return ResultMessage.Success;
		}		
		
	}
	
	
	public ResultMessage deleteStrategies(String hotel){
		if(hotel==null){
			return ResultMessage.Failure;
		}else{
			for(PromotionsPO item:strategieslist){
				if(item.getHotel().equals(hotel)){
					strategieslist.remove(item);
					return ResultMessage.Success;
					
				}
			}
    		
    		return ResultMessage.Failure;
		}		
		
		
	}


}