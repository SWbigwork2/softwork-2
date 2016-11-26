package PromotionsTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import PromotionsMock.Promotions;
import PromotionsMock.ResultMessage;
import PromotionsMock.Strategies;
import PromotionsMock.StrategiesI;
import RoomsMock.RoomType;
import RoomsMock.RoomsInfo;
import po.RoomPO;

public class PromotionsTest {
	@Test
	public void addStrategiesITest(){
		Date date=new Date(2016,11,3);
		Promotions promotion=new Promotions();		
		assertEquals(promotion.addStrategiesI(null, null, null, 1),ResultMessage.Failure);
		assertEquals(promotion.addStrategiesI("南京饭店", date, "生日特惠打七折", 0.7),ResultMessage.Failure);
		
	}
	@Test
	public void deleteStrategiesTest(){
		Date date=new Date(2016,11,3);
		Promotions promotion=new Promotions();
		Strategies temp = new StrategiesI("南京饭店", date, "生日特惠打七折", 0.7);
		ArrayList<Strategies> strategieslist=new ArrayList<Strategies>();
		strategieslist.add(temp);	
		assertEquals(promotion.deleteStrategies(null),ResultMessage.Failure);
		assertEquals(promotion.deleteStrategies("南京饭店"),ResultMessage.Failure);
		
	}
	@Test
	public void getPrice(){
		Promotions promotion=new Promotions();
		RoomsInfo rI = new RoomPO("0001", "皇朝", RoomType.big, "", 100, new int[3]);
		int num=3;
		assertEquals(promotion.getPrice(rI,num),300,0.0001);
		
	}
}
