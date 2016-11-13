package MembersTest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import MembersMock.MemberControllerMock;
import MembersMock.ResultMessage;
import OrdersMock.OrdersMock;
public class MembersTest {
	String memberId="admin";
    String memberPassword="123456";
    String memberName="ะกร๗";
    String memberTelephone="8888";
    double credit=100;
    @Test
	public void Addmembertest() {
    	MemberControllerMock membercontrollerMock =new MemberControllerMock();
    	membercontrollerMock.addmember(memberId, memberPassword,memberName, memberTelephone);
    	assertEquals(membercontrollerMock.addmember(memberId, memberPassword,memberName, memberTelephone),ResultMessage.Success);
    	assertEquals(membercontrollerMock.addmember(memberId, memberPassword,memberName, memberTelephone),ResultMessage.Failure);
		
		
	}
    @Test
    public void getHotelTest(){
    	String id="admin";
    	OrdersMock om=new OrdersMock();
    	MemberControllerMock mcm=new MemberControllerMock();
    	assertEquals(mcm.getHotel(id),om.getHistoyHotel(id));   	
    }
    @Test
    public void getOrderTest(){
    	String id="admin";
    	OrdersMock om=new OrdersMock();
    	MemberControllerMock mcm=new MemberControllerMock();
    	assertEquals(mcm.getOrder(id),om.getOrderHistory(id, null));   	
    }
}
