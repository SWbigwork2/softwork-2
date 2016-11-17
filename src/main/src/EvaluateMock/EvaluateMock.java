package EvaluateMock;

import HotelsMock.HotelMock;

public class EvaluateMock {
    HotelInfo hotel;
    MemberInfo member;
    OrdersInfo order;
    String s;
    int score;
    
    public EvaluateMock(HotelInfo hotel,MemberInfo member,OrdersInfo order){
    	this.hotel= hotel;
    	this.member=member;
    	this.order=order;
    }
    
    public ResultMessage evaluate(String hotelName,String memberId,int orderId,int score,String s){
    	if(hotel.getName().equals(hotelName)&&member.getID().equals(memberId)&&order.getOrderId()==orderId&&(score<5&&score>0)
    		){
    		HotelMock hotelMock=new HotelMock();
    		if(hotelMock.addHotelEvaluation(new EvaluatePO(hotelName, memberId, orderId, score, s))
    				.equals(HotelsMock.ResultMessage.success)){
    			return ResultMessage.success;
    		}else{
    			return ResultMessage.fail;
    		}
    	}else{
    	    return ResultMessage.fail; 
    	}
    }
    
    
    
}
