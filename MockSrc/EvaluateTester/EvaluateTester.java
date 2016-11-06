package EvaluateTester;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import HotelsMock.HotelPO;
import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;
import HotelsMock.HotelsInfo;
import EvaluateMock.ResultMessage;
import MembersMock.MemberPO;
import MembersMock.MembersInfo;
import OrdersMock.OrderPO;
import OrdersMock.OrderType;
import RoomsMock.RoomType;
import EvaluateMock.EvaluateMock;
public class EvaluateTester {
	HotelPO hotel=new HotelPO("銘陳", "珈輿湮耋103",HotelTradeArea.へ牳⑹, "", "", HotelRanking.oneStar);
	MemberPO member=new MemberPO("0001", "admin","admin","10086", 300);
	OrderPO order= new OrderPO(1234,0001,"admin","銘陳",RoomType.big,1,100,OrderType.done,new Date(2016,10,4),new Date(2016,10,5)
			                  ,new Date(2016,10,5),null,null);
	EvaluateMock em=new EvaluateMock(hotel,member, order);
    
	@Test
	public void evaluateTest(){
		assertEquals(em.evaluate("銘陳", "0001", 1234, 3),ResultMessage.success);
		assertEquals(em.evaluate("陳", "0001", 1234, 3),ResultMessage.fail);
		assertEquals(em.evaluate("銘陳", "001", 1234, 3),ResultMessage.fail);
		assertEquals(em.evaluate("銘陳", "0001", 134, 3),ResultMessage.fail);
		assertEquals(em.evaluate("銘陳", "0001", 1234, 6),ResultMessage.fail);
	}
}
