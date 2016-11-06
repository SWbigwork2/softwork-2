package HotelTester;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import OrdersMock.OrderPO;
import OrdersMock.OrdersMock;
import PromotionsMock.PromotionsMock;
import PromotionsMock.PromotionsPO;

public class HotelTest {
	
	@Test
	public void AddHotelTest(){
		PromotionsMock p = new PromotionsMock();
		PromotionsPO promotionPO1 = p.getPromotion("南京饭店");
		assertEquals(promotionPO1.getHotel(),"南京饭店");
	}
	
	@Test
	public void getHistoryHotelTest(){
		OrdersMock m =new OrdersMock();
		ArrayList <OrderPO> list = m. getHotelHistory ("李安");
		for(OrderPO cell:list){
			assertEquals(cell.getUserNameString(),"李安");
		}
	}
	
	public void getOrderHistoryTest(){
		OrdersMock m =new OrdersMock();
		ArrayList <OrderPO> list = m. getOrderHistory ("李安","金陵饭店");
		for(OrderPO cell:list){
			assertEquals(cell.getUserNameString(),"李安");
			assertEquals(cell.getHotelNameString(),"金陵饭店");
		}
	}
	
	
	
	
	

}
