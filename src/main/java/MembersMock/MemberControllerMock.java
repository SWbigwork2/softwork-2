package MembersImpl;

import java.util.ArrayList;

import OrdersMock.OrderItem;
import OrdersMock.OrderVO;
import OrdersMock.OrdersListMock;
import OrdersMock.OrdersMock;

public class MemberControllerMock extends Member{
	public MemberControllerMock(OrdersMock order) {
		ordersmock = order;
		// TODO Auto-generated constructor stub
	}
	String memberdata[][]=new String[10000][4];
	int m=0;
	ResultMessage result=ResultMessage.Success;
	OrdersMock ordersmock;
    public  ArrayList<OrderVO> getOrder(String id){
    	  	
		return ordersmock.getOrderHistory(id,null);
    	
    }
    public  ArrayList<String> getHotel(String id){
    	return ordersmock.getHistoyHotel(id);
		
    	
    }
}
