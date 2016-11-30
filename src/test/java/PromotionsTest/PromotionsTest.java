package PromotionsTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import PromotionsMock.Promotions;
import PromotionsMock.PromotionsMock;
import PromotionsMock.ResultMessage;
import RoomsMock.RoomType;
import RoomsMock.RoomsInfo;
import po.PromotionsIPO;
import po.PromotionsPO;
import po.RoomPO;

public class PromotionsTest {
	@Test
	public void addPromotionsITest(){
		Date date=new Date(2016,11,3);
		PromotionsMock promotion=new PromotionsMock();		
		assertEquals(promotion.addPromotionsI(1,null, null, 1),ResultMessage.Failure);
		assertEquals(promotion.addPromotionsI(1,"南京饭店", "生日特惠打七折", 0.7),ResultMessage.Success);
		
	}
	@Test
	public void deleteStrategiesTest(){
		Date date=new Date(2016,11,3);
		PromotionsMock promotion=new PromotionsMock();
		PromotionsPO temp = new PromotionsIPO(1,"南京饭店", "生日特惠打七折", 0.7);
		ArrayList<PromotionsPO> strategieslist=new ArrayList<PromotionsPO>();
		strategieslist.add(temp);	
		assertEquals(promotion.deleteStrategies(null),ResultMessage.Failure);
		assertEquals(promotion.deleteStrategies("南京饭店"),ResultMessage.Failure);
		
	}
	@Test
	public void getPrice(){
		Promotions promotion=new Promotions();
		RoomsInfo rI = new RoomPO("0001", "皇朝", RoomType.big, "", 100, null);
		int num=3;
		assertEquals(promotion.getPrice(rI,num),300 ,0.0001);
		
	}
}
