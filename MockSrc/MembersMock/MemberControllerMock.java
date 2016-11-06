package MembersMock;

import java.util.ArrayList;

import HotelsMock.HotelPO;
import OrdersMock.OrderItem;
import OrdersMock.OrderVO;
import OrdersMock.OrdersListMock;

public class MemberControllerMock extends Member{
	String memberdata[][]=new String[10000][4];
	int m=0;
	ResultMessage result=ResultMessage.Success;
	public  ResultMessage addmember(String memberid,String memberPassword,String memberName,String memberTelephone){
		for(int i=0;i<memberdata.length;i++){
			if(memberid.equals(memberdata[i][0])){
				result=ResultMessage.Memberhasexist;
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
    public  ArrayList<OrderItem> getOrder(String id){
    	ArrayList<OrderItem> orderlist=new ArrayList<OrderItem>();
    	
		return null;
    	
    }
    public  ArrayList<HotelPO> getHotel(String id){
		return null;
    	
    }
}
