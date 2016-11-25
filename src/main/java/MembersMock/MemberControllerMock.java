package MembersMock;

import java.util.ArrayList;

import OrdersMock.OrderItem;
import OrdersMock.OrderVO;
import OrdersMock.OrdersListMock;
import OrdersMock.OrdersMock;
import po.HotelPO;

public class MemberControllerMock extends Member{
	public MemberControllerMock(OrdersMock order) {
		ordersmock = order;
		// TODO Auto-generated constructor stub
	}
	String memberdata[][]=new String[10000][4];
	int m=0;
	ResultMessage result=ResultMessage.Success;
	OrdersMock ordersmock;
	public  ResultMessage addmember(String memberid,String memberPassword,String memberName,String memberTelephone){
		for(int i=0;i<memberdata.length;i++){
			if(memberid.equals(memberdata[i][0])){
				result=ResultMessage.Failure;
			}
			else{}
		}
		memberdata[m][0]=memberid;
		memberdata[m][1]=memberPassword;
		memberdata[m][2]=memberName;
		memberdata[m][3]=memberTelephone;
		m++;
		return result;
		
	}
    public  ArrayList<OrderVO> getOrder(String id){
    	  	
		return ordersmock.getOrderHistory(id,null);
    	
    }
    public  ArrayList<String> getHotel(String id){
    	return ordersmock.getHistoyHotel(id);
		
    	
    }
}
