package Membersblimpl;

import java.util.ArrayList;

import ordersblimpl.OrderServiceImpl;
import view.member.OrderVo;


public class MemberControllerMock extends Member{
	public MemberControllerMock(OrderServiceImpl order) {
		ordersmock = order;
		// TODO Auto-generated constructor stub
	}
	String memberdata[][]=new String[10000][4];
	int m=0;
	ResultMessage result=ResultMessage.Success;
	OrderServiceImpl ordersmock;
    public  ArrayList<OrderVo> getOrder(String id){
    	
		return ordersmock.getOrderHistory(id,null);
    	
    }
    public  ArrayList<String> getHotel(String id){
    	
    	return ordersmock.getHistoyHotel(id);
		
    	
    }
}
