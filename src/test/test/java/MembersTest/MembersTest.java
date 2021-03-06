package MembersTest;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;
import HotelsMock.HotelsInfo;
import MembersMock.MemberControllerMock;
import MembersMock.MembersInfo;
import MembersMock.ResultMessage;
import OrdersMock.OrdersMock;
import PromotionsMock.Promotions;
import RoomsMock.RoomType;
import RoomsMock.RoomsInfo;
import po.HotelPO;
import po.MemberPO;
import po.RoomPO;
public class MembersTest {
Date date = new Date(2016, 11,1);
	
	RoomsInfo rI = new RoomPO("0001", "皇朝", RoomType.big, "", 100, new int[3]);
	MembersInfo mI = new MemberPO("0001", "admin","admin","10086", 300);
	HotelsInfo hI = new HotelPO("皇朝", "仙林大道103",HotelTradeArea.栖霞区, "", "", HotelRanking.oneStar);
	Promotions po = new Promotions();
	String memberId="admin";
    String memberPassword="123456";
    String memberName="小明";
    String memberTelephone="8888";
    double credit=100;
    @Test
	public void Addmembertest() {
    	MemberControllerMock membercontrollerMock =new MemberControllerMock(new OrdersMock());
    	
    	assertEquals(membercontrollerMock.addmember(memberId, memberPassword,memberName, memberTelephone),ResultMessage.Success);
    	assertEquals(membercontrollerMock.addmember(memberId, memberPassword,memberName, memberTelephone),ResultMessage.Failure);
		
		
	}
    @Test
    public void getHotelTest(){
    	String id="admin";
    	OrdersMock om=new OrdersMock();
    	
    	MemberControllerMock mcm=new MemberControllerMock(om);
    	ArrayList<String> s2=om.getHistoyHotel(id);
    	ArrayList<String> s1=mcm.getHotel(id);
    	
    	assertEquals(s1,s2);   	
    }
    @Test
    public void getOrderTest(){
    	String id="admin";
    	OrdersMock om=new OrdersMock();
    	MemberControllerMock mcm=new MemberControllerMock(om);
    	assertEquals(mcm.getOrder(id),om.getOrderHistory(id, null));   	
    }
}
