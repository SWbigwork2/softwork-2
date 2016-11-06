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
		PromotionsPO promotionPO1 = p.getPromotion("�Ͼ�����");
		assertEquals(promotionPO1.getHotel(),"�Ͼ�����");
	}
	
	@Test
	public void getHistoryHotelTest(){
		OrdersMock m =new OrdersMock();
		ArrayList <OrderPO> list = m. getHotelHistory ("�");
		for(OrderPO cell:list){
			assertEquals(cell.getUserNameString(),"�");
		}
	}
	
	public void getOrderHistoryTest(){
		OrdersMock m =new OrdersMock();
		ArrayList <OrderPO> list = m. getOrderHistory ("�","���극��");
		for(OrderPO cell:list){
			assertEquals(cell.getUserNameString(),"�");
			assertEquals(cell.getHotelNameString(),"���극��");
		}
	}
	
	
	
	
	

}
