package EvaluateTester;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;
import EvaluateMock.ResultMessage;
import OrdersMock.OrderType;
import RoomsMock.RoomType;
import EvaluateMock.EvaluateMock;
import EvaluateMock.HotelInfo;
import EvaluateMock.MemberInfo;
import EvaluateMock.OrdersInfo;
public class EvaluateTester {
	HotelInfo hotel=new HotelInfo("�ʳ�", "���ִ��103",HotelTradeArea.��ϼ��, "", "", HotelRanking.oneStar);
	MemberInfo member=new MemberInfo("0001", "admin","admin","10086", 300);
	OrdersInfo order= new OrdersInfo(1234,"0001","admin","�ʳ�",RoomType.big,1,100,OrderType.done,new Date(2016,10,4),new Date(2016,10,5)
			                  ,new Date(2016,10,5),null,null);
	EvaluateMock em=new EvaluateMock(hotel,member, order);
    
	@Test
	public void evaluateTest(){
		assertEquals(em.evaluate("�ʳ�", "0001", 1234, 3,"good"),ResultMessage.success);
		assertEquals(em.evaluate("��", "0001", 1234, 3,"good"),ResultMessage.fail);
		assertEquals(em.evaluate("�ʳ�", "001", 1234, 3,"good"),ResultMessage.fail);
		assertEquals(em.evaluate("�ʳ�", "0001", 134, 3,"good"),ResultMessage.fail);
		assertEquals(em.evaluate("�ʳ�", "0001", 1234, 6,"good"),ResultMessage.fail);
	}
	
	@Test
	public void setAverageScore(){
	    assertEquals(hotel.setAverageScore(3),HotelsMock.ResultMessage.success);
	}
}
