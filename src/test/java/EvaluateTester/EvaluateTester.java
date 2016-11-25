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
	HotelInfo hotel=new HotelInfo("皇朝", "仙林大道103",HotelTradeArea.栖霞区, "", "", HotelRanking.oneStar);
	MemberInfo member=new MemberInfo("0001", "admin","admin","10086", 300);
	OrdersInfo order= new OrdersInfo(1234,"0001","admin","皇朝",RoomType.big,1,100,OrderType.done,new Date(2016,10,4),new Date(2016,10,5)
			                  ,new Date(2016,10,5),null,null,1,null);
	EvaluateMock em=new EvaluateMock(hotel,member, order);
    
	@Test
	public void evaluateTest(){
		assertEquals(em.evaluate("皇朝", "0001", 1234, 3,"good"),ResultMessage.success);
		assertEquals(em.evaluate("朝", "0001", 1234, 3,"good"),ResultMessage.fail);
		assertEquals(em.evaluate("皇朝", "001", 1234, 3,"good"),ResultMessage.fail);
		assertEquals(em.evaluate("皇朝", "0001", 134, 3,"good"),ResultMessage.fail);
		assertEquals(em.evaluate("皇朝", "0001", 1234, 6,"good"),ResultMessage.fail);
	}
	
}
