package EvaluateMock;

import HotelsMock.HotelPO;
import MembersMock.MemberPO;
import OrdersMock.OrderPO;
import OrdersMock.ResultMessage;

public class EvaluateMock {
    HotelInfo hotel;
    MemberInfo member;
    OrdersInfo order;
    
    public EvaluateMock(HotelPO hotel,MemberPO member,OrderPO order){
    	this.hotel=(HotelInfo) hotel;
    	this.member=(MemberInfo) member;
    	this.order=(OrdersInfo) order;
    }
    
    public ResultMessage evaluate(String hotelName,String memberId,int orderId,int score){
    	if(hotel.getName().equals(hotelName)&&member.getID().equals(memberId)&&order.getOrderId()==orderId&&(score>5||score<0)){
    		return ResultMessage.success;
    	}else{
    	    return ResultMessage.fail; 
    	}
		
    }
}
